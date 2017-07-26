package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.service.CityService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController extends AbstractController<City, City> {

    @Autowired
    private CityService cityService;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<City> findAll() {
        LOGGER.info("Finding All Cities");
        return cityService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City findOne(@PathVariable("id") long id) {
        LOGGER.info("Finding City With ID = {}", id);
        return cityService.findOne(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestBody City city) {
        LOGGER.info("Creating City = {}", city);
        return cityService.save(city);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public City update(@PathVariable("id") long id, @RequestBody City city) {
        LOGGER.info("Update City With ID = {}, {}", id, city);
        return cityService.save(city);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        LOGGER.info("Deleting City With ID = {}", id);
        cityService.delete(id);
    }
}
