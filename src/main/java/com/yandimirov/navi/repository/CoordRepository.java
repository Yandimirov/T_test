package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Coord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoordRepository extends JpaRepository<Coord, Long> {;

}
