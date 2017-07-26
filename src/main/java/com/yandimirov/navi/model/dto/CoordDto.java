package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoordDto {

    private Long id;

    private Long entityId;

    private Long floorId;

    private String address;

    private Long locationId;
}
