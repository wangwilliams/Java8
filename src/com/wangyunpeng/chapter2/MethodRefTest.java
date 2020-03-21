package com.wangyunpeng.chapter2;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author wangyunpeng
 * @date 2020/3/21
 *
 * 方法引用试用场景，当要传递个Lambda体的操作已经有了实现方法，可以使用方法
 *
 * 方法引用的使用条件，要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同
 *
 */
public class MethodRefTest {
    /**
     * 情况1  对象：：实例方法
     * Comsumer的void accept(T t)
     * PrintStream 的 void println（T t)
     */
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京");
        System.out.println("*****************************");
        Consumer<String> con2 = System.out::println;
        con2.accept("上海");
    }


    /**
     * Supplier 中的T get()
     * Suppler></>
     */
    @Test
    public void test2(){
        Employee employee = new Employee(1001,"Tom",23,5600);
        Supplier<String> sup1 = ()->employee.getName();
        System.out.println(sup1.get());
        Supplier<String> sup2 = employee::getName;
        System.out.println(sup2.get());
    }

    /**
     * 情况2 类：：静态方法
     * Comparator中的 int compare(T t1,T t2)
     * Integer中的 int compare(T t1,T t2)
     */
    @Test
    public void test3(){
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(com1.compare(1,2));
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(1,2));
    }

    /**
     * Function 中的R apply(T t)
     * Math中的long round(Double d)
     */
    @Test
    public void test4(){
        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(1.49));
        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(1.50));

    }
    /**
     * 情况3   类：：非静态方法
     */
    @Test
    public void test5(){
        Comparator<String> com1 = (s1,s2) -> s1.compareTo(s2);

    }
}
