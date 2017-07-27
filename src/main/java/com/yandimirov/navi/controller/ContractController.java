package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.entity.Contract;
import com.yandimirov.navi.service.ContractService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController extends AbstractController<Contract, Contract>{

    @Autowired
    private ContractService contractService;

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Contract.class)
    public Contract findOne(@PathVariable("id") Long id) {
        LOGGER.info("Finding All Contracts With ID = {}", id);
        return contractService.findOne(id);
    }

    @Override
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Contract.class)
    public List<Contract> findAll() {
        LOGGER.info("Finding All Contracts");
        return contractService.findAll();
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(RequestView.Contract.class)
    public Contract create(@RequestBody Contract contract) {
        LOGGER.info("Creating Contract = {}", contract);
        return contractService.save(contract);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Contract.class)
    public Contract update(@PathVariable("id") Long id, @RequestBody Contract contract) {
        LOGGER.info("Update Contract With ID = {}, {}", id, contract);
        contract.setId(id);
        return contractService.save(contract);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Contract.class)
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deleting Contract With ID = {}", id);
        contractService.delete(id);
    }
}
