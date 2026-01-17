package com.employee.demoemployee.repository;

import com.employee.demoemployee.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {

    List<ContactEntity> findAllByEmployee_Id(Long id);
}
