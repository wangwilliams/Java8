package com.wangyunpeng.chapter1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

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
        Comparator<Integer> integerComparator = (o1,o2)-> (o1 > o2) ? o1 : o2;


        Comparator<Integer> integerComparator1 = Integer::compare;

        System.out.println(comparable.compare(1,2));
        System.out.println(integerComparator.compare(1,2));
        System.out.println(integerComparator1.compare(3,1));
        Consumer<String> con = (String s) ->System.out.printf(s);
        con.accept("love or not");
        Consumer<String> con1 = s ->System.out.println(s);
        con1.accept("love");

        List<? super Animal> animals = new ArrayList<>();
        Dog<String,Integer> dog = new Dog<>("doudou",1);
        animals.add(dog);
        //System.out.println((Dog<String,Integer>)animals.get(0).getName());
        Object obj = animals.get(0);
        if (obj instanceof Dog){
            dog = (Dog) obj;
        }else {
            dog = null;
            dog = null;
        }
    }
}
