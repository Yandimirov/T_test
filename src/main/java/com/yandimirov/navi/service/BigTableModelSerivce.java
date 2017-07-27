package com.yandimirov.navi.service;

import com.yandimirov.navi.model.entity.BigTableModel;

import java.util.List;

public interface BigTableModelSerivce extends BaseService<BigTableModel, BigTableModel> {
    List<BigTableModel> findAllByQuery();

    BigTableModel findOneByQuery(Long id);
}
