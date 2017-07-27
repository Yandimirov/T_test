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
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "CITIES")
public class City {

    @Id
    @GeneratedValue
    @Column(name = "CITY_ID")
    @JsonView(RequestView.Base.class)
    private long id;

    @Column(name = "CITY_NAME")
    @JsonView(RequestView.Base.class)
    private String name;
}
