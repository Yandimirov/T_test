package com.yandimirov.navi.mapper;

public interface BaseMapper<E, DTO> {

    E mapDtoToEntity(DTO dto);

    DTO mapEntityToDto(E e);
}
