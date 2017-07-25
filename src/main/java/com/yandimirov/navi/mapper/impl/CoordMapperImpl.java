package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.CoordMapper;
import com.yandimirov.navi.model.dto.CoordDto;
import com.yandimirov.navi.model.entity.Coord;
import com.yandimirov.navi.repository.EmployeeRepository;
import com.yandimirov.navi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoordMapperImpl implements CoordMapper{

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Coord mapDtoToEntity(CoordDto coordDto) {
        if(coordDto.getEntityId() > 0){

        } else if(coordDto.getEntityId() < 0) {

        }

        return null;
    }

    @Override
    public CoordDto mapEntityToDto(Coord coord) {
        return null;
    }
}
