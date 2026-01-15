package com.employee.demoemployee.repository;
import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CustomEmployeeRepository, JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findAllByOrderByName();

    @Query(
    "SELECT e.id as employee_id," +
            "e.name, " +
            "e.salary, " +
            "e.birthday, " +
            "c.id as contact_id, " +
            "c.description," +
            "c.type " +
            "FROM EmployeeEntity e " +
            "LEFT JOIN ContactEntity c " +
            "ON c.id = e.id " +
            "WHERE e.id = ?"
    )
    EmployeeEntity findByIdParametrized(Long id);



}