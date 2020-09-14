package com.gd.talks.one;

import com.gd.talks.one.dto.UserDTO;
import lombok.extern.java.Log;
import org.apache.commons.lang3.time.StopWatch;
import org.jeasy.random.randomizers.collection.ListRandomizer;
import org.jeasy.random.randomizers.text.StringRandomizer;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * 21.【参考】利用 Set 元素唯一的特性，可以快速对一个集合进行去重操作，避免使用 List 的
 * contains()进行遍历去重或者判断包含操作。
 */
@Log
public class RemoveDuplicateTest {

    List<UserDTO> list = new ArrayList<>();

    @Before
    public void init() {
        list.add(new UserDTO(1, "Andrew", 100));
        list.add(new UserDTO(1, "Andrew", 100));
        list.add(new UserDTO(2, "John", 100));
        list.add(new UserDTO(3, "John", 200));
    }

    /**
     * 通过List.contains去重
     * <p>
     * 时间复杂度O(n^2)
     */
    @Test
    public void removeDuplicateByList() {
        List<UserDTO> newList = new ArrayList<>();
        for (UserDTO userDTO : list) {
            if (!newList.contains(userDTO)) {
                newList.add(userDTO);
            }
        }
        System.out.println(newList.size());
        newList.forEach(user -> System.out.println(user.toString()));
    }

    /**
     * 通过Set去重
     * HashSet 元素唯一性是通过 HashMap 的 key 唯一性来实现的
     * <p>
     * 时间复杂度接近于O(n)
     */
    @Test
    public void removeDuplicateBySet() {
        Set<UserDTO> userDTOSet = new HashSet<>(list);
        System.out.println(userDTOSet.size());
        userDTOSet.forEach(userDTO -> System.out.println(userDTO.toString()));
    }


    /**
     * 性能的差距是元素查找函数的时间复杂度不同导致的
     * 元素较少时两者耗时差距很小，随着元素的增多耗时差距越来越大
     */
    @Test
    public void compare() {
        List<Integer> lengthList = new LinkedList<>();
        int base = 1;
        for (int i = 1; i <= 6; i++) {
            base *= 10;
            lengthList.add(base);
        }

        StringRandomizer stringRandomizer = new StringRandomizer(10, 100, 1000);

        for (Integer length : lengthList) {
            log.info("------------长度为 " + length + " 时-------");
            ListRandomizer<String> listRandomizer = new ListRandomizer<>(stringRandomizer, length);
            List<String> data = listRandomizer.getRandomValue();

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            Set<String> resultBySet = removeBySet(data);
            log.info("set去重耗时：" + stopWatch.getTime() + " ms");

            stopWatch = new StopWatch();
            stopWatch.start();
            List<String> resultByList = removeByList(data);
            log.info("list去重耗时：" + stopWatch.getTime() + " ms");
        }
    }

    /**
     * 使用Set去重
     *
     * @param list
     * @return
     */
    public Set removeBySet(List<String> list) {
        return new HashSet<>(list);
    }

    /**
     * 使用List contains遍历-对比-去重
     *
     * @param list
     * @return
     */
    public List removeByList(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String obj : list) {
            if (!newList.contains(obj)) {
                newList.add(obj);
            }
        }
        return newList;
    }

}
