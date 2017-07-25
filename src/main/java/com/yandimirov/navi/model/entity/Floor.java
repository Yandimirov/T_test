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
@Entity(name = "floors")
public class Floor {

    @Id
    @GeneratedValue
    @Column(name = "floor_id")
    private long id;

    @Column(name = "floor_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;
}
