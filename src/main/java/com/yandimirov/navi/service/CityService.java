package com.yandimirov.navi.service;

import com.yandimirov.navi.model.entity.City;

import java.util.List;

/**
 * Created by miia0217 on 25.07.2017.
 */

public interface CityService {

    List<City> findAll();

    City findOne(long id);

    City save(City city);

    void delete(long id);
}
