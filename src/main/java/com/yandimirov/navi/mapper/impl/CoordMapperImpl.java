package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.CoordMapper;
import com.yandimirov.navi.model.dto.CoordDto;
import com.yandimirov.navi.model.entity.Coord;
import com.yandimirov.navi.model.entity.EmployeeCoord;
import com.yandimirov.navi.model.entity.Floor;
import com.yandimirov.navi.model.entity.Location;
import com.yandimirov.navi.model.entity.RoomCoord;
import com.yandimirov.navi.repository.EmployeeRepository;
import com.yandimirov.navi.repository.FloorRepository;
import com.yandimirov.navi.repository.LocationRepository;
import com.yandimirov.navi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public final class CoordMapperImpl implements CoordMapper {

  @Autowired
  private RoomRepository roomRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private FloorRepository floorRepository;

  @Autowired
  private LocationRepository locationRepository;

  @Override
  public Coord mapDtoToEntity(final CoordDto coordDto) {
    if (ObjectUtils.isEmpty(coordDto)) {
      return null;
    }

    Coord.Builder builder = new Coord.Builder();

    return builder
        .address(coordDto.getAddress())
        .entityId(coordDto.getEntityId())
        .floor(floorRepository.findOne(coordDto.getFloorId()))
        .location(locationRepository.findOne(coordDto.getLocationId()))
        .build();
  }

  @Override
  public CoordDto mapEntityToDto(final Coord coord) {
    if (ObjectUtils.isEmpty(coord)) {
      return null;
    }

    Floor floor = coord.getFloor();
    long floorId = 0L;
    if (!ObjectUtils.isEmpty(floor)) {
      floorId = floor.getId();
    }

    Location location = coord.getLocation();
    long locationId = 0L;
    if (!ObjectUtils.isEmpty(location)) {
      locationId = location.getId();
    }

    return CoordDto.builder()
        .id(coord.getId())
        .address(coord.getAddress())
        .entityId(coord.getEntityId())
        .floorId(floorId)
        .locationId(locationId)
        .build();
  }

  @Override
  public Coord mapCoordToExtendedCoord(final Coord coord) {
    if (ObjectUtils.isEmpty(coord)) {
      return null;
    }

    Long entityId = coord.getEntityId();
    if (entityId == 0) {
      return coord;
    } else if (entityId > 0) {
      EmployeeCoord.Builder builder = new EmployeeCoord.Builder();
      return builder
          .address(coord.getAddress())
          .id(coord.getId())
          .employee(employeeRepository.findOne(entityId))
          .entityId(coord.getEntityId())
          .floor(coord.getFloor())
          .location(coord.getLocation())
          .build();
    } else {
      RoomCoord.Builder builder = new RoomCoord.Builder();
      return builder
          .address(coord.getAddress())
          .entityId(coord.getEntityId())
          .floor(coord.getFloor())
          .location(coord.getLocation())
          .room(roomRepository.findOne(-entityId))
          .id(coord.getId())
          .build();
    }
  }
}
