package com.yandimirov.navi.model.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.yandimirov.navi.config.RequestView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCoord extends Coord {

  @JsonView(RequestView.Coord.class)
  private Employee employee;

  protected abstract static class Init<T extends Init<T>> extends
      Coord.Init<T> {

    private Employee employee;

    public T employee(final Employee employee) {
      this.employee = employee;
      return self();
    }

    public EmployeeCoord build() {
      return new EmployeeCoord(this);
    }
  }

  public static class Builder extends Init<Builder> {

    @Override
    protected Builder self() {
      return this;
    }
  }

  protected EmployeeCoord(final Init<?> init) {
    super(init);
    this.employee = init.employee;
  }
}
