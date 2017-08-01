package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FloorDto {

  private long id;

  private String name;

  private long officeId;
}
