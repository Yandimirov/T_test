package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
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
public class GroupController extends AbstractController<Group, Group> {

    @Autowired
    private GroupService groupService;

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Group.class)
    public List<Group> findAll() {
        LOGGER.info("Finding All Groups");
        return groupService.findAll();
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Group.class)
    public Group findOne(@PathVariable("id") Long id) {
        LOGGER.info("Finding Group With ID = {}", id);
        return groupService.findOne(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(RequestView.Group.class)
    public Group create(@RequestBody Group group) {
        LOGGER.info("Creating Group = {}", group);
        return groupService.save(group);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Group.class)
    public Group update(@PathVariable("id") Long id, @RequestBody Group group) {
        LOGGER.info("Updating Group With ID = {}, {}", id, group);
        group.setId(id);
        return groupService.save(group);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Group.class)
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deleting Group With ID = {}", id);
        groupService.delete(id);
    }
}
