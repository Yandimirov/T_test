package com.yandimirov.navi.service;

import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findOne(long id);

    Employee save(EmployeeDto employeeDto);

    void delete(long id);
}
