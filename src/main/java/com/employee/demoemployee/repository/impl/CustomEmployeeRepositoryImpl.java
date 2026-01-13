package com.employee.demoemployee.repository.impl;

import com.employee.demoemployee.entity.EmployeeEntity;
import com.employee.demoemployee.repository.CustomEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public EmployeeEntity updateEmployee(String id, EmployeeEntity employee) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update()
                .set("firstname", employee.getFirstname())
                .set("lastname", employee.getLastname())
                .set("email", employee.getEmail());

        return mongoTemplate.findAndModify(
                query,
                update,
                FindAndModifyOptions.options().returnNew(true),
                EmployeeEntity.class);
    }
}
