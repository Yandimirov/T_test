package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.Room;
import com.yandimirov.navi.repository.RoomRepository;
import com.yandimirov.navi.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return StreamSupport
                .stream(roomRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Room findOne(long id) {
        return roomRepository.findOne(id);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void delete(long id) {
        roomRepository.delete(id);
    }
}
