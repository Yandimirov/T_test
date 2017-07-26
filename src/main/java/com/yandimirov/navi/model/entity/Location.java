package com.yandimirov.navi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "LOCATIONS")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "LOCATION_ID")
    private long id;

    @Column(name = "LOCATION_NAME")
    private String name;

    @Column(name = "SQUARE")
    private int square;

    @ManyToOne
    @JoinColumn(name = "CONTRACT_ID")
    private Contract contract;
}
