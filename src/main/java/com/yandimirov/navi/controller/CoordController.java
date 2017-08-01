package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.dto.CoordDto;
import com.yandimirov.navi.model.entity.Coord;
import com.yandimirov.navi.service.CoordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/coords")
public final class CoordController extends AbstractController<Coord, CoordDto> {

  @Autowired
  private CoordService coordService;

  @Override
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Coord.class)
  public Coord findOne(@PathVariable("id") final Long id) {
    LOGGER.info("Finding Coord With ID = {}", id);
    return coordService.findOne(id);
  }

  @Override
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Coord.class)
  public List<Coord> findAll() {
    LOGGER.info("Finding All Coords");
    return coordService.findAll();
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @JsonView(RequestView.Coord.class)
  public Coord create(@RequestBody final CoordDto coordDto) {
    LOGGER.info("Creating Coord = {}", coordDto);
    return coordService.save(coordDto);
  }

  @Override
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Coord.class)
  public Coord update(@PathVariable("id") final Long id,
      @RequestBody final CoordDto coordDto) {
    LOGGER.info("Updating Coord With ID = {}, {}", id, coordDto);
    coordDto.setId(id);
    return coordService.save(coordDto);
  }

  @Override
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Coord.class)
  public void delete(@PathVariable("id") final Long id) {
    LOGGER.info("Deleting Coord With ID = {}", id);
    coordService.delete(id);
  }
}
