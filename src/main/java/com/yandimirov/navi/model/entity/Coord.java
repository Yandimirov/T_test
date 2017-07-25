package com.yandimirov.navi.model.entity;



import lombok.Data;


import javax.persistence.*;
@Data
@Inheritance
@Entity(name = "coords")
@DiscriminatorColumn(name = "coord_discriminator", discriminatorType = DiscriminatorType.STRING)
public abstract class Coord {

    @Id
    @GeneratedValue
    @Column(name = "coord_id")
    private long id;

    @Column(name = "coord_addr")
    private String addr;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;
}
