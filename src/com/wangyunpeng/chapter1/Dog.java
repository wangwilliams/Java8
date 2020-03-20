package com.wangyunpeng.chapter1;

/**
 * @author wangyunpeng
 * @date 2020/3/19
 */
public class Dog<T,E> extends Animal<T,E> {
    public Dog(T name,E count) {
        this.name=name;
        this.count = count;
    }

}
