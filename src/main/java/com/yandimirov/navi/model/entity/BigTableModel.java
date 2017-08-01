package com.yandimirov.navi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BigTableModel {

  @Id
  @Column(name = "COORD_ID")
  private Long coordId;

  @Column(name = "COORD_ADDR")
  private String coordAddress;

  @Column(name = "ENTITY_ID")
  private Long entityId;

  @Column(name = "ENTITY_NAME")
  private String entityName;

  @Column(name = "FLOOR_ID")
  private Long floorId;

  @Column(name = "FLOOR_NAME")
  private String floorName;

  @Column(name = "OFFICE_ID")
  private Long officeId;

  @Column(name = "OFFICE_NAME")
  private String officeName;

  @Column(name = "CITY_ID")
  private Long cityId;

  @Column(name = "CITY_NAME")
  private String cityName;

  @Column(name = "LOCATION_ID")
  private Long locationId;

  @Column(name = "LOCATION_NAME")
  private String locationName;
}
