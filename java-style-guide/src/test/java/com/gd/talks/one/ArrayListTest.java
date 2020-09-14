package com.gd.talks.one;

import org.junit.Test;

import java.util.*;

/**
 * DEMO 3
 * <p>
 * 【强制】使用工具类 Arrays.asList () 把数组转换成集合时，不能使用其修改集合相关的方法，
 * 它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
 */
public class ArrayListTest {

    /**
     * 数组转换为List
     * <p>
     * Q:如何将数组转为"全功能"List
     */
    @Test
    public void arrayToList() {
        String[] arr = new String[]{"one", "two", "three", "four", "five"};
        List<String> list = Arrays.asList(arr);
        list.add("six");
        System.out.println(list.size());
    }

    /**
     * 数组转换为List
     * <p>
     * Q:如何将一个基本数据类型数组转换为List
     */
    @Test
    public void arrayToList2() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        List list = Arrays.asList(arr);
        System.out.println(list.size());
    }

    /**
     * 往数组中加不匹配的类型：ArrayStoreException
     * <p>
     *
     * @see ArrayStoreException
     * Thrown to indicate that an attempt has been made to store the
     * wrong type of object into an array of objects. For example, the
     * following code generates an <code>ArrayStoreException</code>:
     * <blockquote><pre>
     *     Object x[] = new String[3];
     *     x[0] = new Integer(0);
     * </pre></blockquote>
     */
    @Test
    public void listToArray() {
        Map<String, Object> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "1");
        map.put("postIds", list);
        // zxh
        ArrayList<Long> postIdsList = new ArrayList<>((ArrayList<Long>) map.get("postIds"));
        String[] postIds = postIdsList.toArray(new String[0]);
        System.out.println(postIds.length);

//        Object x[] = new String[3];
//        x[0] = new Integer(0);
    }
}
