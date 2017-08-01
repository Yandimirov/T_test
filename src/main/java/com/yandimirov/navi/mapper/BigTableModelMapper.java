package com.yandimirov.navi.mapper;

import com.yandimirov.navi.model.entity.BigTableModel;
import com.yandimirov.navi.model.entity.Coord;

public interface BigTableModelMapper {

  BigTableModel mapCoordToBigTable(Coord coord);
}
