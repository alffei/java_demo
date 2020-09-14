package com.gd.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过Class对象构造类的实例
 * <p>
 * 通过Class对象获得类的属性、方法、构造器、注解
 * <p>
 * 父类中受保护的(protected)的属性是无法通过反射获得的
 */
public class ConstructClazz {

    /**
     * 通过默认无参构造器实例化对象
     *
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void defaultConstruct() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.gd.reflect.Person");
        Person person = (Person) clazz.newInstance();
        person.printInfo();
    }

    @Test
    public void customConstruct() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("com.gd.reflect.Person");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("Andrew", 21);
        person.printInfo();
    }

    @Test
    public void fieldTest() throws ClassNotFoundException, NoSuchFieldException {
        Class clazz = Class.forName("com.gd.reflect.Person");

        Field name = clazz.getDeclaredField("name");
        System.out.println(name.getType());

        // 无法获取继承下来的属性
        // Field isBeet = clazz.getDeclaredField("isBeet");
        // System.out.println(isBeet.getType());

        // getField的变量必须是public的，可获得继承下来的public属性
        // Field weight = clazz.getField("weight");
        // System.out.println(weight.getType());

        System.out.println("--------------------------------");

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

        System.out.println("--------------------------------");

        Field[] fields1 = clazz.getFields();
        for (Field field : fields1) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }
    }

    @Test
    public void methodTest() throws ClassNotFoundException {
        Class clazz = Class.forName("com.gd.reflect.Person");
        clazz.getMethods();
        clazz.getDeclaredMethods();
    }

    /**
     * 只有注解的@Retension标注为RetentionPolicy.RUNTIME是，通过反射才能获得
     * <p>
     * RetentionPolicy
     * ① SOURCE：只在源文件(.java)中保存，编译时编译器会忽略该注解，如@Override
     * ② CLASS：保存在字节码文件(.class)中，运行时不会对改注解进行解析
     * ③ RUNTIME：一直保存到运行时，在运行时可以获得该注解的所有信息
     */
    @Test
    public void annotationTest() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.gd.reflect.Person");
        Method clazzMethod = clazz.getMethod("printInfo");
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Person person = (Person) constructor.newInstance("Andrew", 21);
        Annotation[] annotations = clazzMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // 通过Method.invoke(Instance, args)调用实例的方法
        clazzMethod.invoke(person, null);
    }
}
