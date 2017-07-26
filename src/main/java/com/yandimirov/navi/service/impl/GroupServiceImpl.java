package com.yandimirov.navi.service.impl;

import com.yandimirov.navi.model.entity.Group;
import com.yandimirov.navi.repository.GroupRepository;
import com.yandimirov.navi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(rollbackFor = Exception.class)
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return StreamSupport
                .stream(groupRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Group findOne(long id) {
        return groupRepository.findOne(id);
    }

    @Override
    public Group save(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public void delete(long id) {
        groupRepository.delete(id);
    }
}
