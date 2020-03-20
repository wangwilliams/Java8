package com.wangyunpeng.chapter1;

/**
 * @author wangyunpeng
 * @date 2020/3/19
 */
public class Volit {
    public static void main(String[] args) {
        Plate<? extends Fruit> plate = new Plate<>(new Apple());

    }
}
