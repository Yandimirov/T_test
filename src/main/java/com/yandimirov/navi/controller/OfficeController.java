package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.dto.OfficeDto;
import com.yandimirov.navi.model.entity.Office;
import com.yandimirov.navi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController extends AbstractController<Office, OfficeDto>{

    @Autowired
    private OfficeService officeService;

    @Override
    public Office findOne(@PathVariable long id) {
        LOGGER.info("Find Office With ID = {}", id);
        return officeService.findOne(id);
    }

    @Override
    public List<Office> findAll() {
        LOGGER.info("Find All Offices");
        return officeService.findAll();
    }

    @Override
    public Office create(@RequestBody OfficeDto officeDto) {
        LOGGER.info("Creating Office With ID = {}", officeDto);
        return officeService.save(officeDto);
    }

    @Override
    public Office update(@PathVariable long id, @RequestBody OfficeDto officeDto) {
        LOGGER.info("Updating Office With ID = {}, {}", id, officeDto);
        return officeService.save(officeDto);
    }

    @Override
    public void delete(@PathVariable long id) {
        LOGGER.info("Deleting Office With ID = {}", id);
        officeService.delete(id);
    }
}
