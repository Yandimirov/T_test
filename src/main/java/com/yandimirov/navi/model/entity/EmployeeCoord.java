package com.yandimirov.navi.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue("employee")
public class EmployeeCoord extends Coord{
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
