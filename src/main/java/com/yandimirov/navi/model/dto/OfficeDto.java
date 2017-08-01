package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OfficeDto {

  private long id;

  private String name;

  private String address;

  private long cityId;
}
