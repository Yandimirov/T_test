package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EmployeeDto {

    private Long id;

    private String name;

    private String surName;

    private Date birthDate;

    private Long cityId;

    private String phoneNum;

    private Boolean active;

    private Long groupId;
}
