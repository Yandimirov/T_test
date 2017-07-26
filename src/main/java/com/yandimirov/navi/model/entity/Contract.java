package com.yandimirov.navi.model.entity;

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
    private long id;

    @Column(name = "CONTRACT_NAME")
    private String name;

    @Column(name = "SQUARE_METER_PRICE")
    private long squareMeterPrice;
}
