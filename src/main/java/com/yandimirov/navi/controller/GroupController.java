package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.entity.Group;
import com.yandimirov.navi.service.GroupService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> findAll() {
        return groupService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group findOne(@PathVariable("id") long id) {
        return groupService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Group create(@RequestBody Group group) {
        return groupService.save(group);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group update(@PathVariable("id") long id, @RequestBody Group group) {
        return groupService.save(group);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        groupService.delete(id);
    }
}
