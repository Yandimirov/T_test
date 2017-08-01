package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.repository.EmployeeRepository;
import com.yandimirov.navi.mapper.EmployeeMapper;
import com.yandimirov.navi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private EmployeeMapper employeeMapper;

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee findOne(final Long id) {
    return employeeRepository.findOne(id);
  }

  @Override
  public Employee save(final EmployeeDto employeeDto) {
    return employeeRepository.save(employeeMapper.mapDtoToEntity(employeeDto));
  }

  @Override
  public void delete(final Long id) {
    employeeRepository.delete(id);
  }

  @Override
  public Page<Employee> findAllByPage(final Pageable pageable) {
    return employeeRepository.findAll(pageable);
  }
}
