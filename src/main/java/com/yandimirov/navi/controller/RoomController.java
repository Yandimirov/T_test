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
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Room> findAll(){
        return roomService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Room findOne(@PathVariable("id") long id){
        return roomService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room create(@RequestBody Room room){
        return roomService.save(room);
    }

}
