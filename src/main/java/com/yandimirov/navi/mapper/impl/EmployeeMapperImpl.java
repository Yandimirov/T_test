package com.yandimirov.navi.mapper.impl;

import com.yandimirov.navi.mapper.EmployeeMapper;
import com.yandimirov.navi.model.dto.EmployeeDto;
import com.yandimirov.navi.model.entity.City;
import com.yandimirov.navi.model.entity.Employee;
import com.yandimirov.navi.model.entity.Group;
import com.yandimirov.navi.repository.CityRepository;
import com.yandimirov.navi.repository.GroupRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Employee mapDtoToEntity(EmployeeDto employeeDto) {
        if (ObjectUtils.isEmpty(employeeDto)) {
            return null;
        }
        return Employee.builder()
                .id(employeeDto.getId())
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
    public EmployeeDto mapEntityToDto(Employee employee) {
        if (ObjectUtils.isEmpty(employee)) {
            return null;
        }

        City city = employee.getCity();
        long cityId = 0;
        if (!ObjectUtils.isEmpty(city)) {
            cityId = city.getId();
        }

        Group group = employee.getGroup();
        long groupId = 0;
        if (!ObjectUtils.isEmpty(group)) {
            groupId = group.getId();
        }

        return EmployeeDto.builder()
                .active(employee.isActive())
                .birthDate(employee.getBirthDate())
                .cityId(cityId)
                .groupId(groupId)
                .id(employee.getId())
                .name(employee.getName())
                .surName(employee.getSurName())
                .phoneNum(employee.getPhoneNum())
                .build();
    }
}
