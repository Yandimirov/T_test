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
@Entity(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private long id;

    @Column(name = "location_name")
    private String name;

    @Column(name = "square")
    private int square;
}
