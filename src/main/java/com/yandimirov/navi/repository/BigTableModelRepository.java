package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.BigTableModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BigTableModelRepository extends
    CrudRepository<BigTableModel, Long> {

  @Query(value =
      "SELECT coord.coord_id," +
          "       coord.coord_addr," +
          "       floor.floor_id," +
          "       floor.floor_name," +
          "       office.office_id," +
          "       office.office_name," +
          "       city.city_id," +
          "       city.city_name," +
          "       location.location_id," +
          "       location.location_name," +
          "       entity.entity_id," +
          "       entity.entity_name" +
          "  FROM coords as coord" +
          "       LEFT JOIN" +
          "            (SELECT employee.employee_id as entity_id," +
          "                    employee.employee_name as entity_name" +
          "               FROM employees employee" +

          "              UNION ALL" +

          "             SELECT -room.room_id as entity_id," +
          "                    room.room_name as entity_name" +
          "               FROM rooms room" +
          "            ) as entity" +
          "       ON coord.entity_id = entity.entity_id" +

          "       LEFT JOIN floors as floor" +
          "       ON coord.floor_id = floor.floor_id" +

          "       LEFT JOIN offices as office" +
          "       ON floor.office_id = office.office_id" +

          "       LEFT JOIN cities as city" +
          "       ON office.city_id = city.city_id" +

          "       LEFT JOIN locations as location" +
          "       ON coord.location_id =location.location_id",
      nativeQuery = true)
  List<BigTableModel> findAllbyQuery();

  @Query(value =
      "SELECT coord.coord_id," +
          "       coord.coord_addr," +
          "       floor.floor_id," +
          "       floor.floor_name," +
          "       office.office_id," +
          "       office.office_name," +
          "       city.city_id," +
          "       city.city_name," +
          "       location.location_id," +
          "       location.location_name," +
          "       entity.entity_id," +
          "       entity.entity_name" +
          "  FROM coords as coord" +
          "       LEFT JOIN" +
          "            (SELECT employee.employee_id as entity_id," +
          "                    employee.employee_name as entity_name" +
          "               FROM employees employee" +

          "              UNION ALL" +

          "             SELECT -room.room_id as entity_id," +
          "                    room.room_name as entity_name" +
          "               FROM rooms room" +
          "            ) as entity" +
          "       ON coord.entity_id = entity.entity_id" +

          "       LEFT JOIN floors as floor" +
          "       ON coord.floor_id = floor.floor_id" +

          "       LEFT JOIN offices as office" +
          "       ON floor.office_id = office.office_id" +

          "       LEFT JOIN cities as city" +
          "       ON office.city_id = city.city_id" +

          "       LEFT JOIN locations as location" +
          "       ON coord.location_id =location.location_id" +
          " WHERE coord.coord_id = :id", nativeQuery = true)
  BigTableModel findOneByQuery(@Param("id") Long id);

}
