package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.service.CityService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City findOne(@PathVariable("id") long id) {
        return cityService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestBody City city) {
        return cityService.save(city);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City update(@PathVariable("id") long id, @RequestBody City city) {
        return cityService.save(city);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        cityService.delete(id);
    }
}
