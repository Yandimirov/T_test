package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COORDS")
public class Coord {

    @Id
    @GeneratedValue
    @Column(name = "COORD_ID")
    private long id;

    @Column(name = "COORD_ADDR")
    private String address;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "FLOOR_ID")
    private Floor floor;

    @Column(name = "ENTITY_ID")
    @JsonIgnore
    private long entityId;
}
