package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.mapper.BigTableModelMapper;
import com.yandimirov.navi.model.entity.BigTableModel;
import com.yandimirov.navi.repository.BigTableModelRepository;
import com.yandimirov.navi.repository.CoordRepository;
import com.yandimirov.navi.service.BigTableModelSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BigTableModelServiceImpl implements BigTableModelSerivce{

    @Autowired
    private BigTableModelRepository bigTableModelRepository;

    @Autowired
    private CoordRepository coordRepository;

    @Autowired
    private BigTableModelMapper bigTableModelMapper;

    @Override
    public List<BigTableModel> findAll() {
        return coordRepository.findAll().stream()
            .map(coord -> bigTableModelMapper.mapCoordToBigTable(coord))
            .collect(Collectors.toList());
    }

    @Override
    public BigTableModel findOne(Long id) {
        return bigTableModelMapper.mapCoordToBigTable(coordRepository.findOne(id));
    }

    @Override
    public BigTableModel save(BigTableModel bigTableModel) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public List<BigTableModel> findAllByQuery(){
        return bigTableModelRepository.findAllbyQuery();
    }

    public BigTableModel findOneByQuery(Long id){
        return bigTableModelRepository.findOneByQuery(id);
    }
}
