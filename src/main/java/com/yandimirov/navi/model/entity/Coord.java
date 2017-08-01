package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "COORDS")
public class Coord {

  @Id
  @GeneratedValue
  @Column(name = "COORD_ID")
  @JsonView(RequestView.Base.class)
  private long id;

  @Column(name = "COORD_ADDR")
  @JsonView(RequestView.Base.class)
  private String address;

  @ManyToOne
  @JoinColumn(name = "LOCATION_ID")
  @JsonView(RequestView.Coord.class)
  private Location location;

  @ManyToOne
  @JoinColumn(name = "FLOOR_ID")
  @JsonView(RequestView.Coord.class)
  private Floor floor;

  @Column(name = "ENTITY_ID")
  @JsonIgnore
  private long entityId;

  protected abstract static class Init<T extends Init<T>> {

    private long id;

    private String address;

    private Location location;

    private Floor floor;

    private long entityId;

    protected abstract T self();

    public T id(final Long id) {
      this.id = id;
      return self();
    }

    public T address(final String address) {
      this.address = address;
      return self();
    }

    public T location(final Location location) {
      this.location = location;
      return self();
    }

    public T floor(final Floor floor) {
      this.floor = floor;
      return self();
    }

    public T entityId(final Long entityId) {
      this.entityId = entityId;
      return self();
    }

    public Coord build() {
      return new Coord(this);
    }
  }

  public static class Builder extends Init<Builder> {

    @Override
    protected Builder self() {
      return this;
    }
  }

  protected Coord(final Init<?> init) {
    this.address = init.address;
    this.id = init.id;
    this.entityId = init.entityId;
    this.floor = init.floor;
    this.location = init.location;
  }
}
