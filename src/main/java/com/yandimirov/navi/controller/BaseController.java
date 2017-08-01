package com.yandimirov.navi.controller;

import java.util.List;

public interface BaseController<T, E> {

  T findOne(Long id);

  List<T> findAll();

  T create(E e);

  T update(Long id, E e);

  void delete(Long id);
}
