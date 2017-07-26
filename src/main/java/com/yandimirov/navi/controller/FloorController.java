package com.yandimirov.navi.controller;

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
    public Floor findOne(@PathVariable("id") long id) {
        LOGGER.info("Finding Floor With ID = {}", id);
        return floorService.findOne(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Floor> findAll() {
        LOGGER.info("Finding All Floors");
        return floorService.findAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Floor create(@RequestBody FloorDto floorDto) {
        LOGGER.info("Creating Floor = {}", floorDto);
        return floorService.save(floorDto);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Floor update(@PathVariable("id") long id, @RequestBody FloorDto floorDto) {
        LOGGER.info("Updating Floor With ID = {}, {}", id, floorDto);
        return floorService.save(floorDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        LOGGER.info("Deleting Floor With ID = {}", id);
        floorService.delete(id);
    }
}
