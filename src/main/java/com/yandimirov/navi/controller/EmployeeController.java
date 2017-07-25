package com.yandimirov.navi.controller;

import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.service.EmployeeService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findOne(@PathVariable("id") long id) {
        return employeeService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee update(@PathVariable("id") long id, @RequestBody EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        employeeService.delete(id);
    }
}
