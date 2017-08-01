package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CONTRACTS")
public class Contract {

  @Id
  @GeneratedValue
  @Column(name = "CONTRACT_ID")
  @JsonView(RequestView.Base.class)
  private long id;

  @Column(name = "CONTRACT_NAME")
  @JsonView(RequestView.Base.class)
  private String name;

  @Column(name = "SQUARE_METER_PRICE")
  @JsonView(RequestView.Contract.class)
  private long squareMeterPrice;
}
