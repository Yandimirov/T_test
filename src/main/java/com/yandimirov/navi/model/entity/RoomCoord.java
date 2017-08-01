package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomCoord extends Coord {

  @JsonView(RequestView.Coord.class)
  private Room room;

  protected abstract static class Init<T extends Init<T>> extends
      Coord.Init<T> {

    private Room room;

    public T room(final Room room) {
      this.room = room;
      return self();
    }

    public RoomCoord build() {
      return new RoomCoord(this);
    }
  }

  public static class Builder extends Init<Builder> {

    @Override
    protected Builder self() {
      return this;
    }
  }

  private RoomCoord(final Init<?> init) {
    super(init);
    this.room = init.room;
  }
}
