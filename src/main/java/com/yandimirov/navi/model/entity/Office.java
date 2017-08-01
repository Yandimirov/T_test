package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "OFFICES")
public class Office {

  @Id
  @GeneratedValue
  @Column(name = "OFFICE_ID")
  @JsonView(RequestView.Base.class)
  private long id;

  @Column(name = "OFFICE_NAME")
  @JsonView(RequestView.Base.class)
  private String name;

  @Column(name = "ADDRESS")
  @JsonView(RequestView.Office.class)
  private String address;

  @ManyToOne
  @JoinColumn(name = "CITY_ID")
  @JsonView(RequestView.Office.class)
  private City city;
}
