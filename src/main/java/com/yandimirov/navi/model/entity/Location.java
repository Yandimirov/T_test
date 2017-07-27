package com.yandimirov.navi.model.entity;

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
@Entity(name = "LOCATIONS")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "LOCATION_ID")
    @JsonView(RequestView.Base.class)
    private long id;

    @Column(name = "LOCATION_NAME")
    @JsonView(RequestView.Base.class)
    private String name;

    @Column(name = "SQUARE")
    @JsonView(RequestView.Location.class)
    private int square;

    @ManyToOne
    @JoinColumn(name = "CONTRACT_ID")
    @JsonView(RequestView.Location.class)
    private Contract contract;
}
