package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  @Query(value = "select max(employee_id) + 1 from employees", nativeQuery = true)
  Long findMaxId();
}
