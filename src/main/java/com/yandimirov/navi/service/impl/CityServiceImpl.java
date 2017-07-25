package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.repository.CityRepository;
import com.yandimirov.navi.service.CityService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return StreamSupport
                .stream(cityRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public City findOne(long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public void delete(long id) {
        cityRepository.delete(id);
    }
}
