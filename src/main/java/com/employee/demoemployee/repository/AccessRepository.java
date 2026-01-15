package com.employee.demoemployee.repository;

import com.employee.demoemployee.entity.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<AccessEntity, Long> {

}
