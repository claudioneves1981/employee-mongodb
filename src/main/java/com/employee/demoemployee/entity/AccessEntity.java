package com.employee.demoemployee.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name ="accesses")
@Table(name="accesses")
public class AccessEntity {

    @EmbeddedId
    private AccessesBelogingPK id = new AccessesBelogingPK();

    private boolean readData;

    private boolean deleteData;

    private boolean createData;

    private boolean updateData;

}
