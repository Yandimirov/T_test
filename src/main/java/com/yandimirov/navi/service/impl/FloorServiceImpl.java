package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.mapper.FloorMapper;
import com.yandimirov.navi.model.dto.FloorDto;
import com.yandimirov.navi.model.entity.Floor;
import com.yandimirov.navi.repository.FloorRepository;
import com.yandimirov.navi.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class FloorServiceImpl implements FloorService {

  @Autowired
  private FloorMapper floorMapper;

  @Autowired
  private FloorRepository floorRepository;

  @Override
  public List<Floor> findAll() {
    return floorRepository.findAll();
  }

  @Override
  public Floor findOne(final Long id) {
    return floorRepository.findOne(id);
  }

  @Override
  public Floor save(final FloorDto floorDto) {
    Floor floor = floorMapper.mapDtoToEntity(floorDto);
    return floorRepository.save(floor);
  }

  @Override
  public void delete(final Long id) {
    floorRepository.delete(id);
  }
}
