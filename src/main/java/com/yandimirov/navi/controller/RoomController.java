package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.entity.Room;
import com.yandimirov.navi.service.RoomService;
import lombok.extern.java.Log;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/rooms")
public class RoomController extends AbstractController<Room, Room> {

    @Autowired
    private RoomService roomService;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Room> findAll() {
        LOGGER.info("Finding All Rooms");
        return roomService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room findOne(@PathVariable("id") long id) {
        LOGGER.info("Finding Room With ID = {}", id);
        return roomService.findOne(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(@RequestBody Room room) {
        LOGGER.info("Create Room = {}", room);
        return roomService.save(room);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room update(@PathVariable("id") long id, @RequestBody Room room) {
        LOGGER.info("Update Room With ID = {}, {}", id, room);
        return roomService.save(room);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        LOGGER.info("Delete Room With ID = {}", id);
        roomService.delete(id);
    }

}
