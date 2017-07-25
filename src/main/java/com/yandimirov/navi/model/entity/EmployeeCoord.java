package com.yandimirov.navi.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue("employee")
public class EmployeeCoord extends Coord{
    @OneToOne
    @JoinColumn(name = "entity_id")
    private Employee employee;
}
