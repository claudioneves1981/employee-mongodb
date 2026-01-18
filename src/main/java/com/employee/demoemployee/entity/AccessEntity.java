package com.employee.demoemployee.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity(name ="accesses")
@Table(name="accesses")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AccessEntity {

    @EmbeddedId
    private AccessesBelogingPK id = new AccessesBelogingPK();

    private boolean readData;

    private boolean deleteData;

    private boolean createData;

    private boolean updateData;

}
