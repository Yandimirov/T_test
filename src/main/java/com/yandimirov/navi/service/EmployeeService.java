package com.yandimirov.navi.service;

import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService extends BaseService<Employee, EmployeeDto>{
    Page<Employee> findAllByPage(Pageable pageable);
}
