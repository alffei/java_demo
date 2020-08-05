package com.gd.talks.one;

import org.junit.Test;

/**
 * ## Demo1
 * 【强制】所有整型包装类对象之间值的比较，全部使用equals方法比较。
 */
public class IntegerTests {

    /**
     * 整数比较
     * <p>
     * 设置JVM参数：java.lang.Integer.IntegerCache.high
     * <a href='https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html#jls-5.1.7>JLS5.1</a>
     */
    @Test
    public void compareInteger() {
        // 基本类型(primitive type)
        int num1 = 127, num2 = 127, num3 = 128, num4 = 128;
        // 包装器(Wrapper class)
        Integer num11 = 127, num22 = 127, num33 = 128, num44 = 128;

        // 基本类型 == 比较
        System.out.println(" num1 == num2 : " + (num1 == num2));
        System.out.println(" num3 == num4 : " + (num3 == num4));

        // 包装器类型 == 比较
        System.out.println(" num11 == num22 : " + (num11 == num22));
        System.out.println(" num33 == num44 : " + (num33 == num44));
    }

}
