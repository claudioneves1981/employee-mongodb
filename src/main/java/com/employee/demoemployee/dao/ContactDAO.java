package com.employee.demoemployee.dao;

import com.employee.demoemployee.entity.ContactEntity;
import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.util.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ContactDAO {

    public void insert(final ContactEntity entity){

        try(

            var connection = ConnectionUtil.getConnection();
            var statement = connection.prepareStatement(
                    "INSERT INTO employees(description, type, employee_id) values(?,?,?);"
            )
        ){
            statement.setString(1, entity.getDescription());
            statement.setString(2,entity.getType());
            statement.setLong(3,entity.getEmployee().getId());


            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }

    }

    public List<ContactEntity> findByEmployeeId(final long employeeId){

       List<ContactEntity> entities = new ArrayList<>();

        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement("SELECT * FROM contacts WHERE employee_id = ?")
        ){
            statement.setLong(1,employeeId);
            statement.executeQuery();
            var resultSet = statement.getResultSet();
           while(resultSet.next()) {

                var entity = new ContactEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setDescription(resultSet.getString("description"));
                entity.setType(resultSet.getString("type"));
                entity.getEmployee().setId(resultSet.getLong("employee_id"));
                entities.add(entity);

            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }

        return entities;

    }


}
