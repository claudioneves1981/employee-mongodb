package com.employee.demoemployee.repository;

import com.employee.demoemployee.entity.ModuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ModuleRepository extends JpaRepository<ModuleEntity, Long> {

    @Query("select m.id module_id, " +
            "                m.name module_name, " +
            "                e.id employee_id, " +
            "                e.name employee_name, " +
            "                e.salary employee_salary, " +
            "                e.birthday employee_birthday " +
            "                from modules m " +
            "                inner join accesses a " +
            "                on a.id.module.id = m.id " +
            "                inner join employees e " +
            "                on e.id = a.id.employee.id" +
            "                order by m.id")
    List<ModuleEntity> findAllParametrized();

}
