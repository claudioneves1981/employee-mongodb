package com.employee.demoemployee.repository;

import com.employee.demoemployee.entity.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccessRepository extends JpaRepository<AccessEntity, Long> {

    @Modifying
    @Query("UPDATE accesses SET readData = :readData, deleteData = :deleteData, createData = :createData, updateData = :updateData WHERE id.employee.id = :employeeId AND id.module.id = :moduleId")
    void update(boolean readData, boolean deleteData, boolean createData, boolean updateData, long employeeId, long moduleId);

}
