package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
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
    @JsonView(RequestView.Base.class)
    private Long id;

    @Column(name = "COORD_ADDR")
    @JsonView(RequestView.Base.class)
    private String address;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    @JsonView(RequestView.Coord.class)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "FLOOR_ID")
    @JsonView(RequestView.Coord.class)
    private Floor floor;

    @Column(name = "ENTITY_ID")
    @JsonIgnore
    private Long entityId;
}
