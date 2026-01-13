package com.employee.demoemployee.repository;
import java.util.List;
import java.util.Optional;

import com.employee.demoemployee.entity.EmployeeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String>, CustomEmployeeRepository {

    // Custom query to find employees by firstname
    @Query("{ 'firstname' : ?0 }")
    public List<EmployeeEntity> findByFirstname(String firstname);

    // Custom query to find employees by lastname
    @Query("{ 'lastname' : ?0 }")
    public List<EmployeeEntity> findByLastname(String lastname);

    // Custom query to find employees by firstname and lastname
    @Query("{ 'firstname' : ?0, 'lastname' : ?1}")
    public List<EmployeeEntity> findByFirstnameAndLastName(String firstname, String lastname);

    // Custom query to find employee by email
    @Query("{ 'email' : ?0 }")
    public Optional<EmployeeEntity> findByEmail(String email);

    /**
     * Custom paginated query to find all employees
     * projecting firstname, lastname, and email
     */
    @Query(value = "{}", fields = "{ 'firstname' : 1, 'lastname' : 1, 'email' : 1 }")
    public Page<EmployeeEntity> findAllProjectedBy(Pageable pageable);
}