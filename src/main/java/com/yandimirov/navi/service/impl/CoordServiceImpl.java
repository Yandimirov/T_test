package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.mapper.CoordMapper;
import com.yandimirov.navi.model.dto.CoordDto;
import com.yandimirov.navi.model.entity.Coord;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.model.entity.EmployeeCoord;
import com.yandimirov.navi.model.entity.RoomCoord;
import com.yandimirov.navi.repository.CoordRepository;
import com.yandimirov.navi.repository.EmployeeRepository;
import com.yandimirov.navi.repository.RoomRepository;
import com.yandimirov.navi.service.CoordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(rollbackFor = Exception.class)
public class CoordServiceImpl implements CoordService {

    @Autowired
    private CoordRepository coordRepository;

    @Autowired
    private CoordMapper coordMapper;

    @Override
    public List<Coord> findAll() {
        return coordRepository
                .findAll()
                .stream()
                .map(coord -> coordMapper.mapCoordToExtendedCoord(coord))
                .collect(Collectors.toList());
    }

    @Override
    public Coord findOne(Long id) {
        Coord coord = coordRepository.findOne(id);
        return coordMapper.mapCoordToExtendedCoord(coord);
    }

    @Override
    public Coord save(CoordDto coordDto) {
        Coord coord = coordMapper.mapDtoToEntity(coordDto);
        return coordRepository.save(coord);
    }

    @Override
    public void delete(Long id) {
        coordRepository.delete(id);
    }
}
