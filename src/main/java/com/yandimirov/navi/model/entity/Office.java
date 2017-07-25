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
@Entity(name = "offices")
public class Office {

    @Id
    @GeneratedValue
    @Column(name = "office_id")
    private long id;

    @Column(name = "office_name")
    private String name;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
