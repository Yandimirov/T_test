package com.yandimirov.navi.model.entity;

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
@Entity(name = "groups")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "group_id")
    private long id;

    @Column(name = "group_name", unique = true)
    private String name;

    @Column(name = "permission")
    private int permission;
}
