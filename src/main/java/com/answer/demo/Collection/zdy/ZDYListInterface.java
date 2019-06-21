package com.answer.demo.Collection.zdy;

import java.util.Collection;

/**
 * created by liufeng
 * 2019/6/21
 */
public interface ZDYListInterface<E> extends Collection<E> {

    E get(int i);

    int indexOf(Object o);
}
