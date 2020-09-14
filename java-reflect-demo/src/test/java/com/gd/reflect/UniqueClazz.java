package com.gd.reflect;

import org.junit.Test;

/**
 * 一个类在内存中至多存在一个Class对象
 */
public class UniqueClazz {

    @Test
    public void unique() throws ClassNotFoundException {
        Class clazz1 = Class.forName("com.gd.reflect.Person");
        Class clazz2 = Person.class;
        Person person = new Person();
        Class clazz3 = person.getClass();

        System.out.println("Class.forName() == Person.class: " + (clazz1 == clazz2));
        System.out.println("Person.class == instance.getClass: " + (clazz2 == clazz3));
    }

}
