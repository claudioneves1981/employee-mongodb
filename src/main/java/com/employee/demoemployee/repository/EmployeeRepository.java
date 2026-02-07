package com.employee.demoemployee.repository;
import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Page<EmployeeEntity> findAllByOrderByName(Pageable pageable);

    /*@Query(
    "SELECT e.id as employee_id," +
            "e.name, " +
            "e.salary, " +
            "e.birthday, " +
            "c.id as contact_id, " +
            "c.description," +
            "c.type " +
            "FROM employees e " +
            "LEFT JOIN contacts c " +
            "ON c.id = e.id " +
            "WHERE e.id = :id"
    )
    Optional<EmployeeEntity> findByIdParametrized(Long id);*/



}