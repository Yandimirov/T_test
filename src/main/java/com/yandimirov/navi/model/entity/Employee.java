package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "EMPLOYEES")
public class Employee {

  @Id
  @Column(name = "EMPLOYEE_ID")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_generator")
  @SequenceGenerator(name = "employee_generator", sequenceName = "employees_seq")
  @JsonView(RequestView.Base.class)
  private long id;

  @Column(name = "EMPLOYEE_NAME")
  @JsonView(RequestView.Base.class)
  private String name;

  @Column(name = "EMPLOYEE_SURNAME")
  @JsonView(RequestView.Employee.class)
  private String surName;

  @Column(name = "BIRTH_DATE")
  @Temporal(TemporalType.DATE)
  @JsonView(RequestView.Employee.class)
  private Date birthDate;

  @Column(name = "EMPLOYEE_ACTIVE")
  @JsonView(RequestView.Employee.class)
  private boolean active;

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
