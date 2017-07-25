package com.yandimirov.navi.service;

import com.yandimirov.navi.model.entity.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City findOne(long id);

    City save(City city);

    void delete(long id);
}
