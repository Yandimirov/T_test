package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Group;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface GroupRepository extends PagingAndSortingRepository<Group, Long>{
}
