package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
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
    @JsonView(RequestView.Base.class)
    private Long id;

    @Column(name = "EMPLOYEE_NAME")
    @JsonView(RequestView.Base.class)
    private String name;

    @Column(name = "EMPLOYEE_SURNAME")
    @JsonView(RequestView.Employee.class)
    private String surName;

    @Column(name = "BIRTH_DATE")
    @JsonView(RequestView.Employee.class)
    private Date birthDate;

    @Column(name = "EMPLOYEE_ACTIVE")
    @JsonView(RequestView.Employee.class)
    private Boolean active;

    @Column(name = "PHONE_NUM")
    @JsonView(RequestView.Employee.class)
    private String phoneNum;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    @JsonView(RequestView.Employee.class)
    private City city;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    @JsonView(RequestView.Employee.class)
    private Group group;
}
