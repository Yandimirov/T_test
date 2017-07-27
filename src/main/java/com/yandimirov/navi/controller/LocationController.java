package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.dto.LocationDto;
import com.yandimirov.navi.model.entity.Location;
import com.yandimirov.navi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController extends AbstractController<Location, LocationDto> {
    @Autowired
    private LocationService locationService;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Location.class)
    public Location findOne(@PathVariable("id") Long id) {
        LOGGER.info("Finding Location With ID = {}", id);
        return locationService.findOne(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Location.class)
    public List<Location> findAll() {
        LOGGER.info("Finding All Locations");
        return locationService.findAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(RequestView.Location.class)
    public Location create(@RequestBody LocationDto locationDto) {
        LOGGER.info("Creating Location = {}", locationDto);
        return locationService.save(locationDto);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Location.class)
    public Location update(@PathVariable("id") Long id, @RequestBody LocationDto locationDto) {
        LOGGER.info("Updating Location With ID = {}, {}", id, locationDto);
        locationDto.setId(id);
        return locationService.save(locationDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Location.class)
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deleting Location With ID = {}", id);
        locationService.delete(id);
    }
}
