package com.yandimirov.navi.service;

import java.util.List;

public interface BaseService<T, E> {
    List<T> findAll();

    T findOne(long id);

    T save(E e);

    void delete(long id);

}
