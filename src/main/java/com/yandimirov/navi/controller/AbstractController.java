package com.yandimirov.navi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController<T, E> implements BaseController<T, E> {

  protected static final Logger LOGGER =
      LoggerFactory.getLogger(AbstractController.class);
}
