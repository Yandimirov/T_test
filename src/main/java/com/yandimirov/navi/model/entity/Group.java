package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID")
    @JsonView(RequestView.Base.class)
    private Long id;

    @Column(name = "GROUP_NAME")
    @JsonView(RequestView.Base.class)
    private String name;

    @Column(name = "PERMISSION")
    @JsonView(RequestView.Group.class)
    private Integer permission;
}
