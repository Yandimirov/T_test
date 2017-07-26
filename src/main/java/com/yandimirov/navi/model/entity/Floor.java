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
@Entity(name = "FLOORS")
public class Floor {

    @Id
    @GeneratedValue
    @Column(name = "FLOOR_ID")
    private long id;

    @Column(name = "FLOOR_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "OFFICE_ID")
    private Office office;
}
