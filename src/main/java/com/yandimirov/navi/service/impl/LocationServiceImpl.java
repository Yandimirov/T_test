package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.mapper.LocationMapper;
import com.yandimirov.navi.model.dto.LocationDto;
import com.yandimirov.navi.model.entity.Location;
import com.yandimirov.navi.repository.LocationRepository;
import com.yandimirov.navi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class LocationServiceImpl implements LocationService {

  @Autowired
  private LocationRepository locationRepository;

  @Autowired
  private LocationMapper locationMapper;

  @Override
  public List<Location> findAll() {
    return locationRepository.findAll();
  }

  @Override
  public Location findOne(final Long id) {
    return locationRepository.findOne(id);
  }

  @Override
  public Location save(final LocationDto locationDto) {
    return locationRepository.save(locationMapper.mapDtoToEntity(locationDto));
  }

  @Override
  public void delete(final Long id) {
    locationRepository.delete(id);
  }
}
