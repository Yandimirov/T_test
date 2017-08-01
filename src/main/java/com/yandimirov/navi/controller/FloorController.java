package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.dto.FloorDto;
import com.yandimirov.navi.model.entity.Floor;
import com.yandimirov.navi.service.FloorService;
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
@RequestMapping("api/floors")
public final class FloorController extends AbstractController<Floor, FloorDto> {

  @Autowired
  private FloorService floorService;

  @Override
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Floor.class)
  public Floor findOne(@PathVariable("id") final Long id) {
    LOGGER.info("Finding Floor With ID = {}", id);
    return floorService.findOne(id);
  }

  @Override
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Floor.class)
  public List<Floor> findAll() {
    LOGGER.info("Finding All Floors");
    return floorService.findAll();
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @JsonView(RequestView.Floor.class)
  public Floor create(@RequestBody final FloorDto floorDto) {
    LOGGER.info("Creating Floor = {}", floorDto);
    return floorService.save(floorDto);
  }

  @Override
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Floor.class)
  public Floor update(@PathVariable("id") final Long id,
      @RequestBody final FloorDto floorDto) {
    LOGGER.info("Updating Floor With ID = {}, {}", id, floorDto);
    floorDto.setId(id);
    return floorService.save(floorDto);
  }

  @Override
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Floor.class)
  public void delete(@PathVariable("id") final Long id) {
    LOGGER.info("Deleting Floor With ID = {}", id);
    floorService.delete(id);
  }
}
