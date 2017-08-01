package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.entity.Room;
import com.yandimirov.navi.service.RoomService;
import lombok.extern.java.Log;
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

@Log
@RestController
@RequestMapping("api/rooms")
public final class RoomController extends AbstractController<Room, Room> {

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
  public Room findOne(@PathVariable("id") final Long id) {
    LOGGER.info("Finding Room With ID = {}", id);
    return roomService.findOne(id);
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Room create(@RequestBody final Room room) {
    LOGGER.info("Create Room = {}", room);
    return roomService.save(room);
  }

  @Override
  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Room update(@PathVariable("id") final Long id,
      @RequestBody final Room room) {
    LOGGER.info("Update Room With ID = {}, {}", id, room);
    room.setId(id);
    return roomService.save(room);
  }

  @Override
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable("id") final Long id) {
    LOGGER.info("Delete Room With ID = {}", id);
    roomService.delete(id);
  }

}
