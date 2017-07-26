package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.dto.CoordDto;
import com.yandimirov.navi.model.entity.Coord;
import com.yandimirov.navi.service.CoordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coords")
public class CoordController extends AbstractController<Coord, CoordDto> {

    @Autowired
    private CoordService coordService;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coord findOne(@PathVariable("id") long id) {
        LOGGER.info("Finding Coord With ID = {}", id);
        return coordService.findOne(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Coord> findAll() {
        LOGGER.info("Finding All Coords");
        return coordService.findAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coord create(@RequestBody CoordDto coordDto) {
        LOGGER.info("Creating Coord = {}", coordDto);
        return coordService.save(coordDto);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Coord update(@PathVariable("id") long id, @RequestBody CoordDto coordDto) {
        LOGGER.info("Updating Coord With ID = {}, {}", id, coordDto);
        return coordService.save(coordDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        LOGGER.info("Deleting Coord With ID = {}", id);
        coordService.delete(id);
    }
}
