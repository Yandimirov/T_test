package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.dto.FloorDto;
import com.yandimirov.navi.model.entity.Floor;
import com.yandimirov.navi.service.BaseService;
import com.yandimirov.navi.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floors")
public class FloorController extends AbstractController<Floor, FloorDto>{

    @Autowired
    private FloorService floorService;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Floor.class)
    public Floor findOne(@PathVariable("id") Long id) {
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
    public Floor create(@RequestBody FloorDto floorDto) {
        LOGGER.info("Creating Floor = {}", floorDto);
        return floorService.save(floorDto);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Floor.class)
    public Floor update(@PathVariable("id") Long id, @RequestBody FloorDto floorDto) {
        LOGGER.info("Updating Floor With ID = {}, {}", id, floorDto);
        floorDto.setId(id);
        return floorService.save(floorDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Floor.class)
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deleting Floor With ID = {}", id);
        floorService.delete(id);
    }
}
