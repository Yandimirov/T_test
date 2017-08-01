package com.yandimirov.navi.service;

import java.util.List;

public interface BaseService<T, E> {

  List<T> findAll();

  T findOne(Long id);

  T save(E e);

  void delete(Long id);

}
