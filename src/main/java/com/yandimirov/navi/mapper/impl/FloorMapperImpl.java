package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.FloorMapper;
import com.yandimirov.navi.model.dto.FloorDto;
import com.yandimirov.navi.model.entity.Floor;
import com.yandimirov.navi.model.entity.Office;
import com.yandimirov.navi.repository.FloorRepository;
import com.yandimirov.navi.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class FloorMapperImpl implements FloorMapper{

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public Floor mapDtoToEntity(FloorDto floorDto) {
        if(ObjectUtils.isEmpty(floorDto)){
            return null;
        }

        return Floor.builder()
                .id(floorDto.getId())
                .name(floorDto.getName())
                .office(officeRepository.findOne(floorDto.getOfficeId()))
                .build();
    }

    @Override
    public FloorDto mapEntityToDto(Floor floor) {
        if(ObjectUtils.isEmpty(floor)){
            return null;
        }

        Office office = floor.getOffice();
        long officeId = 0L;
        if(!ObjectUtils.isEmpty(office)){
            officeId = office.getId();
        }

        return FloorDto.builder()
                .id(floor.getId())
                .name(floor.getName())
                .officeId(officeId)
                .build();
    }
}
