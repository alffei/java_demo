package com.gd.lambda;

import com.gd.lambda.fi.Converter;
import org.junit.Test;

public class FiTest {

    @Test
    public void testFi() {
        // 函数式接口 -> Lambda表达式
        // Converter<String, Integer> converter = form -> Integer.valueOf(form);
        // 方法和构造函数引用: “Java 8 允许你通过::关键字获取方法或者构造函数的的引用”
        Converter<String, Integer> converter = Integer::valueOf;
        String s = "1234";
        Integer convert = converter.convert(s);
        System.out.println(convert);
    }
}
