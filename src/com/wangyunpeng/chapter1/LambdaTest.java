package com.wangyunpeng.chapter1;

import java.util.Comparator;

/**
 * Lambda 表达式的使用例子
 */
public class LambdaTest {
    public static void main(String[] args) {
        Comparator<Integer> comparable = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 > o2) ? o1 : o2;
            }
        };
        Comparator<Integer> integerComparator = (o1,o2)->{
            return (o1 > o2) ? o1 : o2;
        };

        Comparator<Integer> integerComparator1 = Integer::compare;

        System.out.println(comparable.compare(1,2));
        System.out.println(integerComparator.compare(1,2));
        System.out.println(integerComparator1.compare(3,1));
    }
}
