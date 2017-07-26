package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
