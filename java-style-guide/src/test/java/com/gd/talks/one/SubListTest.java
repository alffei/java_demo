package com.gd.talks.one;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * DEMO 4
 * <p>
 * 【强制】ArrayList 的 subList 结果不可强转成 ArrayList，否则会抛出 ClassCastException 异 常，
 * 即 java.util.RandomAccessSubList cannot be cast to java.util.ArrayList。
 * <p>
 * 【强制】在 SubList 场景中，高度注意对「原集合」元素的增加或删除，均会导致子列表的遍历、增加、删除产生
 * ConcurrentModificationException 异常。
 * <p>
 * Q: Java对象在什么情况下可以类型转换？
 * Upcasting AND Downcasting
 * <p>
 * Q: 如何生成'子'List，不影响'父'List？
 * <p>
 * Q
 */
public class SubListTest {

    List<String> list;

    @Before
    public void createList() {
        list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
    }

    /**
     * 类型转换
     */
    @Test
    public void caseTest() {
        List<String> subList = list.subList(1, 3);
        ArrayList<String> subArrList = (ArrayList<String>) subList;
        printList(subArrList, "SubList");
    }

    /**
     * 修改(set)：非结构性改变原List
     */
    @Test
    public void modifyTest() {
        List<String> subList = list.subList(1, 3);
        // 修改SubList
        subList.set(0, "xxx");
        // 打印SubList
        printList(subList, "SubList");
        // 打印原List(ArrayList)
        printList(list, "List");

        // 修改List
        list.set(2, "ooo");
        // 打印SubList
        printList(subList, "SubList");
        // 打印原List(ArrayList)
        printList(list, "List");
    }

    /**
     * 增(add)：结构性改变原List
     */
    @Test
    public void addTest() {
        List<String> subList = list.subList(1, 3);
        list.add("eight");
        printList(list, "List");
        printList(subList, "SubList");
    }

    /**
     * 增(add)::结构性改变SubList
     */
    @Test
    public void addSubTest() {
        List<String> subList = list.subList(1, 3);
        subList.add("eight");
        printList(list, "List");
        printList(subList, "SubList");
    }

    /**
     * 删(remove)：结构性改变原List
     */
    @Test
    public void removeTest() {
        List<String> subList = list.subList(1, 3);
        list.remove("three");
        printList(list, "List");
        printList(subList, "SubList");
    }

    /**
     * 删(remove):结构性改变SubList
     */
    @Test
    public void removeSubTest() {
        List<String> subList = list.subList(1, 3);
        subList.remove("three");
        printList(list, "List");
        printList(subList, "SubList");
    }

    /**
     * 打印列表(泛型对象toString)
     *
     * @param list 列表
     */
    private void printList(List<?> list, String key) {
        if (null == list || list.size() == 0) {
            System.out.println("empty list");
        } else {
            System.out.print((null == key ? "" : key) + " : ");
            list.forEach(sub -> System.out.print(sub.toString() + " "));
            System.out.println();
        }
    }

}
