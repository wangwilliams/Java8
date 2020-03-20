package com.wangyunpeng.chapter1;

/**
 * @author wangyunpeng
 * @date 2020/3/19
 */
public class Animal<T,E> {
    protected T name;
    protected E count;

    public E getCount() {
        return count;
    }

    public void setCount(E count) {
        this.count = count;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }
}
