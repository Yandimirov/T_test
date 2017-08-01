package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class EmployeeDto {

  private long id;

  private String name;

  private String surName;

  private Date birthDate;

  private long cityId;

  private String phoneNum;

  private boolean active;

  private long groupId;
}
