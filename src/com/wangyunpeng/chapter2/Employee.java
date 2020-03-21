package com.wangyunpeng.chapter2;

/**
 * @author wangyunpeng
 * @date 2020/3/21
 */
public class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final int salary;

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }
}
