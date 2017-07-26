package com.yandimirov.navi.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {

    private Long id;

    private String name;

    private int square;

    private Long contractId;
}
