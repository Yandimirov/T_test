package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.entity.BigTableModel;
import com.yandimirov.navi.repository.BigTableModelRepository;
import com.yandimirov.navi.service.BigTableModelSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/table")
public class BigTableModelController {

    @Autowired
    private BigTableModelSerivce bigTableModelSerivce;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BigTableModel> findAll(@RequestParam(defaultValue = "orm", required = false) String type){
        if(type.equals("sql")){
            return bigTableModelSerivce.findAllByQuery();
        } else if (type.equals("orm")){
            return bigTableModelSerivce.findAll();
        }
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigTableModel findOne(@PathVariable("id") Long id, @RequestParam(defaultValue = "orm", required = false) String type){
        if(type.equals("sql")){
            return bigTableModelSerivce.findOneByQuery(id);
        } else if (type.equals("orm")){
            return bigTableModelSerivce.findOne(id);
        }
        return null;
    }
}
