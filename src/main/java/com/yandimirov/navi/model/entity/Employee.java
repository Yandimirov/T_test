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
@Entity(name = "EMPLOYEES")
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private long id;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @Column(name = "EMPLOYEE_SURNAME")
    private String surName;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "EMPLOYEE_ACTIVE")
    private boolean active;

    @Column(name = "PHONE_NUM")
    private String phoneNum;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
}
