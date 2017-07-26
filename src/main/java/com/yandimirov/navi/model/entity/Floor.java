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
@Entity(name = "FLOORS")
public class Floor {

    @Id
    @GeneratedValue
    @Column(name = "FLOOR_ID")
    @JsonView(RequestView.Base.class)
    private Long id;

    @Column(name = "FLOOR_NAME")
    @JsonView(RequestView.Base.class)
    private String name;

    @ManyToOne
    @JoinColumn(name = "OFFICE_ID")
    @JsonView(RequestView.Floor.class)
    private Office office;
}
