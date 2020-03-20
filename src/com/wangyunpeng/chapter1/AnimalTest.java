package com.wangyunpeng.chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.junit.Assert.*;

/**
 * @author wangyunpeng
 * @date 2020/3/20
 */

public class AnimalTest {
    @Test
    public void test1() {
        Consumer<String> consumer = s->System.out.println(s);
        consumer.accept("Wang Yunpeng");
        System.out.println("");
    }

    @Test
    public void test2(){
        Supplier<String> supplier = ()-> "love";
        Assert.assertEquals(supplier.get(),"love");
        System.out.println(supplier.get());
    }

   @Test
   public void test3(){
       Predicate<String> predicate = t -> t.length() > 5;
       Assert.assertTrue(predicate.test("wangyunpeng"));
   }

   @Test
   public void test4() throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        List<String> strings = new ArrayList<>();
        strings.add("aaaaaa");
        strings.add("bbbbbb");
        strings.add("cccccc");
       String str = filterString(strings,t->
       t.charAt(0) == 'a');
       assertEquals(str,new String("aaaaaa"));
       System.out.println(str);
       Class clazz = Class.forName("java.lang.String");
       Field field = clazz.getField("value[]");
       field.set(str,"bbb");
       System.out.println(str);
   }

   @Test
   public void test5(){
       Appleimpl apple = new Appleimpl("apple");
       System.out.println(apple.getName());
       try {
           Class clazz = Class.forName("com.wangyunpeng.chapter1.Appleimpl");
           Field field = clazz.getDeclaredField("name");
           field.setAccessible(true);
           field.set(apple,"banana");
           System.out.println(apple.getName());

       } catch (Exception e) {
           e.printStackTrace();
       }
   }

   private String filterString(List<String> list, Predicate<String> pre){
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            if (pre.test(str)){
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
   }
}
