package com.gd.reflect;

import java.beans.Transient;

/**
 * @author chenpengfei
 */
public class Person extends Animal {

    public String name;

    public int age;

    private double weight;

    public Person() {
    }

    /**
     * Constructor
     *
     * @param name
     * @param age
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    @Transient
    public void printInfo() {
        System.out.println("My name is" + name + ", I am" + age + "years old!");
    }
}
