package com.employee.demoemployee.dao;

import com.employee.demoemployee.entity.AccessEntity;
import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.util.ConnectionUtil;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class AccessDAO {

    public void insert(AccessEntity access){
        try(
                var connection = ConnectionUtil.getConnection();
                var statement = connection.prepareStatement("INSERT INTO accesses(employee_id, module_id) values(?,?)")
        ) {
                statement.setLong(1,access.getId().getEmployee().getId());
                statement.setLong(2,access.getId().getModule().getId());
                statement.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
