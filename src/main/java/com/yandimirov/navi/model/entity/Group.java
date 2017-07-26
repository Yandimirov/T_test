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
@Entity(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID")
    private long id;

    @Column(name = "GROUP_NAME")
    private String name;

    @Column(name = "PERMISSION")
    private int permission;
}
