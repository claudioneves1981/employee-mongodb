package com.employee.demoemployee.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class AccessEntity {

    @EmbeddedId
    private AccessesBelogingPK id = new AccessesBelogingPK();

    private boolean readData;

    private boolean deleteData;

    private boolean createData;

    private boolean updateData;

}
