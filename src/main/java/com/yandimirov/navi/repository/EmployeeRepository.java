package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{
}
