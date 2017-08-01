package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.repository.CityRepository;
import com.yandimirov.navi.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CityServiceImpl implements CityService {

  @Autowired
  private CityRepository cityRepository;

  @Override
  public List<City> findAll() {
    return cityRepository.findAll();
  }

  @Override
  public City findOne(final Long id) {
    return cityRepository.findOne(id);
  }

  @Override
  public City save(final City city) {
    return cityRepository.save(city);
  }

  @Override
  public void delete(final Long id) {
    cityRepository.delete(id);
  }
}
