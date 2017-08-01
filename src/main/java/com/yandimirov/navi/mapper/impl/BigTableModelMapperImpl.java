package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.BigTableModelMapper;
import com.yandimirov.navi.model.entity.BigTableModel;
import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.model.entity.Coord;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.model.entity.Floor;
import com.yandimirov.navi.model.entity.Location;
import com.yandimirov.navi.model.entity.Office;
import com.yandimirov.navi.model.entity.Room;
import com.yandimirov.navi.repository.EmployeeRepository;
import com.yandimirov.navi.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public final class BigTableModelMapperImpl implements BigTableModelMapper {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private RoomRepository roomRepository;

  @Override
  public BigTableModel mapCoordToBigTable(final Coord coord) {
    if (ObjectUtils.isEmpty(coord)) {
      return null;
    }

    BigTableModel bigTableModel = new BigTableModel();
    bigTableModel.setCoordId(coord.getId());
    bigTableModel.setCoordAddress(coord.getAddress());
    Floor floor = coord.getFloor();

    if (!ObjectUtils.isEmpty(floor)) {
      bigTableModel.setFloorId(floor.getId());
      bigTableModel.setFloorName(floor.getName());
      Office office = floor.getOffice();

      if (!ObjectUtils.isEmpty(office)) {
        bigTableModel.setOfficeId(office.getId());
        bigTableModel.setOfficeName(office.getName());
        City city = office.getCity();

        if (!ObjectUtils.isEmpty(city)) {
          bigTableModel.setCityId(city.getId());
          bigTableModel.setCityName(city.getName());
        }
      }
    }

    Location location = coord.getLocation();

    if (!ObjectUtils.isEmpty(location)) {
      bigTableModel.setLocationId(location.getId());
      bigTableModel.setLocationName(location.getName());
    }

    long entityId = coord.getEntityId();
    if (entityId > 0) {
      Employee employee = employeeRepository.findOne(entityId);

      if (!ObjectUtils.isEmpty(employee)) {
        bigTableModel.setEntityId(employee.getId());
        bigTableModel.setEntityName(employee.getName());
      }

    } else if (entityId < 0) {
      Room room = roomRepository.findOne(-entityId);

      if (!ObjectUtils.isEmpty(room)) {
        bigTableModel.setEntityName(room.getName());
        bigTableModel.setEntityId(room.getId());
      }
    }

    return bigTableModel;
  }
}
