package com.employee.demoemployee.dao;

import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.util.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Timestamp;

import static java.time.ZoneOffset.UTC;

public class EmployeeDAO {

    public void insert(final EmployeeEntity entity) {

        try (

                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement(
                        "INSERT INTO employees(name, salary, birthday) values(?,?,?);"
                )
        ) {
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setTimestamp(3,
                    Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime())
            );
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
