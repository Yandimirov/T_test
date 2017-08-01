package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoordDto {

  private long id;

  private long entityId;

  private long floorId;

  private String address;

  private long locationId;
}
