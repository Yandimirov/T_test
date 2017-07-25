package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "employee_id")
    private long id;

    @Column(name = "employee_name")
    private String name;

    @Column(name = "employee_surname")
    private String surName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "employee_active")
    private boolean active;

    @Column(name = "phone_num")
    private String phoneNum;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
