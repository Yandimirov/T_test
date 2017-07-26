package com.yandimirov.navi.controller;

import java.util.List;

public interface BaseController<T, E> {

    T findOne(long id);

    List<T> findAll();

    T create(E e);

    T update(long id, E e);

    void delete(long id);
}
