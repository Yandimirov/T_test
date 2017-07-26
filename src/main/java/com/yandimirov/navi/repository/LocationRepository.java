package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
