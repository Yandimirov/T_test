package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OfficeRepository extends JpaRepository<Office, Long> {
}
