package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.dto.OfficeDto;
import com.yandimirov.navi.model.entity.Office;
import com.yandimirov.navi.service.OfficeService;
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
@RequestMapping("api/offices")
public final class OfficeController extends
    AbstractController<Office, OfficeDto> {

  @Autowired
  private OfficeService officeService;

  @Override
  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Office.class)
  public Office findOne(@PathVariable final Long id) {
    LOGGER.info("Finding Office With ID = {}", id);
    return officeService.findOne(id);
  }

  @Override
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Office.class)
  public List<Office> findAll() {
    LOGGER.info("Finding All Offices");
    return officeService.findAll();
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @JsonView(RequestView.Office.class)
  public Office create(@RequestBody final OfficeDto officeDto) {
    LOGGER.info("Creating Office With ID = {}", officeDto);
    return officeService.save(officeDto);
  }

  @Override
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Office.class)
  public Office update(@PathVariable final Long id,
      @RequestBody final OfficeDto officeDto) {
    LOGGER.info("Updating Office With ID = {}, {}", id, officeDto);
    officeDto.setId(id);
    return officeService.save(officeDto);
  }

  @Override
  @DeleteMapping("/id")
  @ResponseStatus(HttpStatus.OK)
  @JsonView(RequestView.Office.class)
  public void delete(@PathVariable final Long id) {
    LOGGER.info("Deleting Office With ID = {}", id);
    officeService.delete(id);
  }
}
