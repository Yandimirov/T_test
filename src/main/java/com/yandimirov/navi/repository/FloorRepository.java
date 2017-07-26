package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FloorRepository extends JpaRepository<Floor, Long> {
}
