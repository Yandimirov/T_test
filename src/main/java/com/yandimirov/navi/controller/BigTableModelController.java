package com.yandimirov.navi.controller;

import java.util.ArrayList;
import java.util.List;
import com.yandimirov.navi.model.entity.BigTableModel;
import com.yandimirov.navi.service.BigTableModelSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/table")
public final class BigTableModelController {

  @Autowired
  private BigTableModelSerivce bigTableModelSerivce;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<BigTableModel> findAll(
      @RequestParam(defaultValue = "orm", required = false) final String type) {
    if (type.equals("sql")) {
      return bigTableModelSerivce.findAllByQuery();
    } else if (type.equals("orm")) {
      return bigTableModelSerivce.findAll();
    }
    return new ArrayList<>();
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public BigTableModel findOne(
      @PathVariable("id") final Long id,
      @RequestParam(defaultValue = "orm", required = false) final String type) {
    if (type.equals("sql")) {
      return bigTableModelSerivce.findOneByQuery(id);
    } else if (type.equals("orm")) {
      return bigTableModelSerivce.findOne(id);
    }
    return null;
  }
}
