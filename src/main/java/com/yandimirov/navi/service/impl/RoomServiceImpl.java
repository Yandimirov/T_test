package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.Room;
import com.yandimirov.navi.repository.RoomRepository;
import com.yandimirov.navi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoomServiceImpl implements RoomService {

  @Autowired
  private RoomRepository roomRepository;

  @Override
  public List<Room> findAll() {
    return roomRepository.findAll();
  }

  @Override
  public Room findOne(final Long id) {
    return roomRepository.findOne(id);
  }

  @Override
  public Room save(final Room room) {
    return roomRepository.save(room);
  }

  @Override
  public void delete(final Long id) {
    roomRepository.delete(id);
  }
}
