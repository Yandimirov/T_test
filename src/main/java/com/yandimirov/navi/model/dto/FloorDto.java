package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FloorDto {

    private Long id;

    private String name;

    private Long officeId;
}
