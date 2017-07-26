package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.mapper.OfficeMapper;
import com.yandimirov.navi.model.dto.OfficeDto;
import com.yandimirov.navi.model.entity.Office;
import com.yandimirov.navi.repository.OfficeRepository;
import com.yandimirov.navi.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OfficeServiceImpl implements OfficeService{

    @Autowired
    private OfficeMapper officeMapper;

    @Autowired
    private OfficeRepository officeRepository;

    @Override
    public List<Office> findAll() {
        return StreamSupport
                .stream(officeRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Office findOne(long id) {
        return officeRepository.findOne(id);
    }

    @Override
    public Office save(OfficeDto officeDto) {
        Office office = officeMapper.mapDtoToEntity(officeDto);
        return officeRepository.save(office);
    }

    @Override
    public void delete(long id) {
        officeRepository.delete(id);
    }
}
