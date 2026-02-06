package com.employee.demoemployee.repository;

import com.employee.demoemployee.entity.AccessEntity;
import com.employee.demoemployee.entity.AccessesBelogingPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccessRepository extends JpaRepository<AccessEntity, AccessesBelogingPK> {

    //@Modifying
    /*@Query("UPDATE accesses SET read_data = :readData, delete_data = :deleteData, create_data = :createData, update_data = :updateData WHERE id.employee.id = :employeeId AND id.module.id = :moduleId")
    void update(boolean readData, boolean deleteData, boolean createData, boolean updateData, long employeeId, long moduleId);*/

}
