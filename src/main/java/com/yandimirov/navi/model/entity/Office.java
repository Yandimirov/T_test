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
@Entity(name = "OFFICES")
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "OFFICE_ID")
    private long id;

    @Column(name = "OFFICE_NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @ManyToOne
    @JoinColumn(name = "CITY_ID")
    private City city;
}
