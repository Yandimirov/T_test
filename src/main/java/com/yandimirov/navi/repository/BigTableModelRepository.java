package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.BigTableModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BigTableModelRepository extends CrudRepository<BigTableModel, Long> {

    @Query(value = "SELECT coord.coord_id,\n" +
                   "       coord.coord_addr,\n" +
                   "       floor.floor_id,\n" +
                   "       floor.floor_name,\n" +
                   "       office.office_id,\n" +
                   "       office.office_name,\n" +
                   "       city.city_id,\n" +
                   "       city.city_name,\n" +
                   "       location.location_id,\n" +
                   "       location.location_name,\n" +
                   "       entity.entity_id,\n" +
                   "       entity.entity_name" +
                   "  FROM coords as coord\n" +
                   "       LEFT JOIN\n" +
                   "            (SELECT employee.employee_id as entity_id,\n" +
                   "                    employee.employee_name as entity_name\n" +
                   "               FROM employees employee\n" +
                   "\n" +
                   "              UNION ALL\n" +
                   "\n" +
                   "             SELECT -room.room_id as entity_id,\n" +
                   "                    room.room_name as entity_name\n" +
                   "               FROM rooms room\n" +
                   "            ) as entity\n" +
                   "       ON coord.entity_id = entity.entity_id\n" +
                   "\n" +
                   "       LEFT JOIN floors as floor\n" +
                   "       ON coord.floor_id = floor.floor_id\n" +
                   "\n" +
                   "       LEFT JOIN offices as office\n" +
                   "       ON floor.office_id = office.office_id\n" +
                   "\n" +
                   "       LEFT JOIN cities as city\n" +
                   "       ON office.city_id = city.city_id\n" +
                   "\n" +
                   "       LEFT JOIN locations as location\n" +
                   "       ON coord.location_id =location.location_id\n", nativeQuery = true)
    List<BigTableModel> findAllbyQuery();

    @Query(value = "SELECT coord.coord_id,\n" +
                    "       coord.coord_addr,\n" +
                    "       floor.floor_id,\n" +
                    "       floor.floor_name,\n" +
                    "       office.office_id,\n" +
                    "       office.office_name,\n" +
                    "       city.city_id,\n" +
                    "       city.city_name,\n" +
                    "       location.location_id,\n" +
                    "       location.location_name,\n" +
                    "       entity.entity_id,\n" +
                    "       entity.entity_name" +
                    "  FROM coords as coord\n" +
                    "       LEFT JOIN\n" +
                    "            (SELECT employee.employee_id as entity_id,\n" +
                    "                    employee.employee_name as entity_name\n" +
                    "               FROM employees employee\n" +
                    "\n" +
                    "              UNION ALL\n" +
                    "\n" +
                    "             SELECT -room.room_id as entity_id,\n" +
                    "                    room.room_name as entity_name\n" +
                    "               FROM rooms room\n" +
                    "            ) as entity\n" +
                    "       ON coord.entity_id = entity.entity_id\n" +
                    "\n" +
                    "       LEFT JOIN floors as floor\n" +
                    "       ON coord.floor_id = floor.floor_id\n" +
                    "\n" +
                    "       LEFT JOIN offices as office\n" +
                    "       ON floor.office_id = office.office_id\n" +
                    "\n" +
                    "       LEFT JOIN cities as city\n" +
                    "       ON office.city_id = city.city_id\n" +
                    "\n" +
                    "       LEFT JOIN locations as location\n" +
                    "       ON coord.location_id =location.location_id\n" +
                    " WHERE coord.coord_id = :id", nativeQuery = true)
    BigTableModel findOneByQuery(@Param("id") Long id);

}
