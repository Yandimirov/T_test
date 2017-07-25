package com.yandimirov.navi.model.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
@DiscriminatorValue("room")
public class RoomCoord extends Coord{
    @OneToOne
    @JoinColumn(name = "room_id")
    @Where(clause = "-room_id = id")
    private Room room;
}
