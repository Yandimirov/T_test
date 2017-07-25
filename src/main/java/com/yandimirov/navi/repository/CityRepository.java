package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}
