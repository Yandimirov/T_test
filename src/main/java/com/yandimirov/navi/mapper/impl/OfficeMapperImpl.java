package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.OfficeMapper;
import com.yandimirov.navi.model.dto.OfficeDto;
import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.model.entity.Office;
import com.yandimirov.navi.repository.CityRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class OfficeMapperImpl implements OfficeMapper {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Office mapDtoToEntity(OfficeDto officeDto) {
        if (ObjectUtils.isEmpty(officeDto)) {
            return null;
        }

        return Office.builder()
                .name(officeDto.getName())
                .address(officeDto.getAddress())
                .city(cityRepository.findOne(officeDto.getCityId()))
                .build();
    }

    @Override
    public OfficeDto mapEntityToDto(Office office) {
        if (ObjectUtils.isEmpty(office)) {
            return null;
        }

        City city = office.getCity();
        Long cityId = 0L;
        if(!ObjectUtils.isEmpty(city)){
            cityId = city.getId();
        }

        return OfficeDto.builder()
                .id(office.getId())
                .name(office.getName())
                .address(office.getAddress())
                .cityId(cityId)
                .build();
    }
}
