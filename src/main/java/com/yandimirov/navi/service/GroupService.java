package com.yandimirov.navi.service;

import com.yandimirov.navi.model.entity.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();

    Group findOne(long id);

    Group save(Group group);

    void delete(long id);
}
