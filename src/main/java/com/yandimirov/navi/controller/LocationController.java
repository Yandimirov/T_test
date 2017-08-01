package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.dto.LocationDto;
import com.yandimirov.navi.model.entity.Location;
import com.yandimirov.navi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/locations")
public final class LocationController extends
    AbstractController<Location, LocationDto> {

  @Autowired
  private LocationService locationService;

  @Override
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Location.class)
  public Location findOne(@PathVariable("id") final Long id) {
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
  public Location create(@RequestBody final LocationDto locationDto) {
    LOGGER.info("Creating Location = {}", locationDto);
    return locationService.save(locationDto);
  }

  @Override
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Location.class)
  public Location update(@PathVariable("id") final Long id,
      @RequestBody final LocationDto locationDto) {
    LOGGER.info("Updating Location With ID = {}, {}", id, locationDto);
    locationDto.setId(id);
    return locationService.save(locationDto);
  }

  @Override
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Location.class)
  public void delete(@PathVariable("id") final Long id) {
    LOGGER.info("Deleting Location With ID = {}", id);
    locationService.delete(id);
  }
}
