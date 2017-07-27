package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.entity.BigTableModel;
import com.yandimirov.navi.repository.BigTableModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by miia0217 on 27.07.2017.
 */

@RestController
@RequestMapping("/table_sql")
public class BigTableModelController {

    @Autowired
    private BigTableModelRepository bigTableModelRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BigTableModel> findAll(){
        return bigTableModelRepository.findAll();
    }
}
