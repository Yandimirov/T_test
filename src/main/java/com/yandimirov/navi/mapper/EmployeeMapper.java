package com.yandimirov.navi.mapper;

import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;
import lombok.NonNull;

public interface EmployeeMapper {

    Employee mapDtoToEntity(@NonNull EmployeeDto employeeDto);

    EmployeeDto mapEntityToDto(@NonNull Employee employee);
}
