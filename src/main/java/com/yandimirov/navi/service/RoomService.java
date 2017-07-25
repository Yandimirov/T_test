package com.yandimirov.navi.service;

import com.yandimirov.navi.model.entity.Room;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoomService {

    List<Room> findAll();

    Room findOne(long id);

    Room save(Room room);

    void delete(long id);
}
