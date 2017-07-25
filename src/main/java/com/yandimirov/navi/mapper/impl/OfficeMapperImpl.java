package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.OfficeMapper;
import com.yandimirov.navi.model.dto.OfficeDto;
import com.yandimirov.navi.model.entity.Office;
import com.yandimirov.navi.repository.CityRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OfficeMapperImpl implements OfficeMapper {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Office mapDtoToEntity(@NonNull OfficeDto officeDto) {
        return Office.builder()
                .name(officeDto.getName())
                .address(officeDto.getAddress())
                .city(cityRepository.findOne(officeDto.getCityId()))
                .build();
    }

    @Override
    public OfficeDto mapEntityToDto(@NonNull Office office) {
        return OfficeDto.builder()
                .id(office.getId())
                .name(office.getName())
                .address(office.getAddress())
                .cityId(office.getCity().getId())
                .build();
    }
}
