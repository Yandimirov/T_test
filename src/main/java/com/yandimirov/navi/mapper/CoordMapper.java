package com.yandimirov.navi.mapper;

import com.yandimirov.navi.model.dto.CoordDto;
import com.yandimirov.navi.model.entity.Coord;

public interface CoordMapper {

    Coord mapDtoToEntity(CoordDto coordDto);

    CoordDto mapEntityToDto(Coord coord);
}
