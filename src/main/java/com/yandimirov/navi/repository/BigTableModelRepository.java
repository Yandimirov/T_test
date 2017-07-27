package com.yandimirov.navi.repository;

import com.yandimirov.navi.model.entity.BigTableModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface BigTableModelRepository extends CrudRepository<BigTableModel, Long> {

    @Override
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
                   "       JOIN floors as floor\n" +
                   "       ON floor.floor_id = coord.floor_id\n" +
                   "\n" +
                   "       JOIN offices as office\n" +
                   "       ON office.office_id = floor.office_id\n" +
                   "\n" +
                   "       JOIN cities as city\n" +
                   "       ON city.city_id = office.city_id\n" +
                   "\n" +
                   "       JOIN locations as location\n" +
                   "       ON location.location_id = coord.location_id\n", nativeQuery = true)
    List<BigTableModel> findAll();
}
