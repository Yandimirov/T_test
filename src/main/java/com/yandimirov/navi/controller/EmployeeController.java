package com.yandimirov.navi.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.service.EmployeeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/employees")
public class EmployeeController extends AbstractController<Employee, EmployeeDto> {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Employee> findAll(){
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Employee.class)
    public Page<Employee> findAll(Pageable pageable) {
        LOGGER.info("Finding All Employees with page = {} and size = {}", pageable.getPageNumber(), pageable.getPageSize());
        return employeeService.findAllByPage(pageable);
    }

    @Override
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Employee.class)
    public Employee findOne(@PathVariable("id") Long id) {
        LOGGER.info("Finding Employee With ID = {}", id);
        return employeeService.findOne(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(RequestView.Employee.class)
    public Employee create(@RequestBody EmployeeDto employeeDto) {
        LOGGER.info("Creating Employee = {}", employeeDto);
        return employeeService.save(employeeDto);
    }

    @Override
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Employee.class)
    public Employee update(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
        LOGGER.info("Updating Employee With ID = {}, {}", id, employeeDto);
        employeeDto.setId(id);
        return employeeService.save(employeeDto);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(RequestView.Employee.class)
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deleting Employee With ID = {}", id);
        employeeService.delete(id);
    }
}
