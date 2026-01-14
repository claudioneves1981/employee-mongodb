package com.employee.demoemployee.dao;

import com.employee.demoemployee.entity.ContactEntity;
import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.entity.ModuleEntity;
import com.employee.demoemployee.util.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class EmployeeParamDAO {

    private final ContactDAO contactDAO = new ContactDAO();

    private final AccessDAO accessDAO = new AccessDAO();

    public void insert(final EmployeeEntity entity){
        try(var connection = ConnectionUtil.getConnection();
            var statement = connection.prepareStatement("INSERT INTO employees(name, salary,birthday) values(?,?,?);"
            )){

            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            var timestamp = Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC)
                            .toLocalDateTime());
            statement.setTimestamp(3, timestamp);
            statement.executeUpdate();

                entity.getModules().stream()
                        .map(ModuleEntity::getId)
                        .forEach(m -> accessDAO.insert(entity.getId(),m));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void update(final EmployeeEntity entity){

        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "UPDATE employees set name = ?, salary = ?, birthday = ? WHERE id = ?"
                )
        ) {
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );
            statement.setLong(4, entity.getId());
            statement.executeUpdate();
            System.out.printf("Foram afetados %s registros na base de dados", statement.getUpdateCount());

        }catch(SQLException ex){
            ex.printStackTrace();

        }

    }

    public void delete(final long id){

        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
                ){
            statement.setLong(1,id);
            statement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public List<EmployeeEntity> findAllByOrderByName(){

        List<EmployeeEntity> entities = new ArrayList<>();
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.createStatement()
                ){
            statement.executeQuery("SELECT * FROM employees ORDER BY name");
            var resultSet = statement.getResultSet();
            while(resultSet.next()) {
                var entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entity.setContacts(contactDAO.findByEmployeeId(resultSet.getLong("id")));
                entities.add(entity);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return entities;

    }

    public EmployeeEntity findById(final long id){
        var entity = new EmployeeEntity();
        var sql = "SELECT e.id employee_id" +
                "e.name, " +
                "e.salary, " +
                "e.birthday, " +
                "c.id contact_id, " +
                "c.description," +
                "c.type " +
                "FROM employees e " +
                "LEFT JOIN contacts c " +
                "ON c.employees_id = e.id " +
                "WHERE e.id = ?";
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(sql);
                ){
            statement.setLong(1,id);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
            if(resultSet.next()){
                entity.setId(resultSet.getLong("employee_id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entity.setContacts(new ArrayList<>());
                do {
                    var contact = new ContactEntity();

                    contact.setId(resultSet.getLong("contact_id"));
                    contact.setDescription(resultSet.getString("description"));
                    contact.setType(resultSet.getString("type"));
                    entity.getContacts().add(contact);

                }while(resultSet.next());

            }

        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return entity;
    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime){
        var utcDateTime = dateTime.withOffsetSameInstant(UTC);
        return utcDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
