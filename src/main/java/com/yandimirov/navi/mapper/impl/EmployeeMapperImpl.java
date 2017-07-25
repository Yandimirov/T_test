package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.EmployeeMapper;
import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.repository.CityRepository;
import com.yandimirov.navi.repository.GroupRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Employee mapDtoToEntity(@NonNull EmployeeDto employeeDto) {
        return Employee.builder()
                .active(employeeDto.isActive())
                .birthDate(employeeDto.getBirthDate())
                .city(cityRepository.findOne(employeeDto.getCityId()))
                .group(groupRepository.findOne(employeeDto.getGroupId()))
                .name(employeeDto.getName())
                .surName(employeeDto.getSurName())
                .phoneNum(employeeDto.getPhoneNum())
                .build();
    }

    @Override
    public EmployeeDto mapEntityToDto(@NonNull Employee employee) {
        return EmployeeDto.builder()
                .active(employee.isActive())
                .birthDate(employee.getBirthDate())
                .cityId(employee.getCity().getId())
                .groupId(employee.getGroup().getId())
                .id(employee.getId())
                .name(employee.getName())
                .surName(employee.getSurName())
                .phoneNum(employee.getPhoneNum())
                .build();
    }
}
