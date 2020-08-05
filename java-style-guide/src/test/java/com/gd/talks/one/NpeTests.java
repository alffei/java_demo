package com.gd.talks.one;

import com.gd.talks.one.dto.UserDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * DEMO 2:
 * 【强制】Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。
 * <p>
 * Q1:哪些用法可能造 NPE 相关的 BUG？
 * Q2:如何更有效地避免空指针呢
 */
public class NpeTests {

    /**
     * 逻辑FLAG
     * <p>
     * 测试值：1、 2、 null
     */
    public static final Integer FLAG = null;
    /**
     * 前总统名
     */
    private static final String Former_PRESIDENT_NAME = "Trump";

    /**
     * 寻找NPE
     *
     * <p>
     * ① (自动)拆箱有风险（NPE），装箱需谨慎（数值比较）
     * ② (增强)for循环的NPE
     * ③ 【强制】当 switch 括号内的变量类型为 String 并且此变量为外部参数时，必须先进行 null判断
     *
     * @site https://docs.oracle.com/javase/specs/jls/se8/html/jls-14.html#jls-14.11
     * @site https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html
     * @see NullPointerException
     */
    @Test
    public void iSeeNpe() {
        Integer flag = FLAG;
        List<UserDTO> users = mockUserService(flag);

        // 变量选举结果
        for (UserDTO user : users) {
            // 内部处理
            switch (user.getName()) {
                case "Chen":
                    user.setScore(10000);
                    break;
                case "null":
                    System.out.println("异常候选人");
                    break;
                default:
                    break;
            }
            // 前总统本次竞选信息
            findFormerPresident(user);
        }

        // 总票数
        int total = calcScore(users);
        // 当选（最高分）者
        UserDTO user = calcTopScore(users);
        System.out.println("本次大选总票数：" + total);
        System.out.println("最高票选获得者：" + user.getName() + "，票数：" + user.getScore());
    }

    /**
     * 模拟获取用户集合服务
     */
    public List<UserDTO> mockUserService(int flag) {
        if (1 == flag) {
            // 获取到参选人员集合
            List<UserDTO> users = new ArrayList<>();
            users.add(new UserDTO(0, "Tomas", 666));
            users.add(new UserDTO(1, "Chen", 999));
            users.add(new UserDTO(2, "Trump", null));
            users.add(new UserDTO(3, null, 12));
            return users;
        } else {
            // 没有获取到用户，返回null
            return null;
        }
    }

    /**
     * 根据名字配置用户
     * <p>
     * ① 逻辑判断表达式结果不能为null
     *
     * @param user
     */
    private void findFormerPresident(UserDTO user) {
        if (isPresident(user)) {
            System.out.println("find former president, his info:" + user.toString());
        }
    }

    /**
     * 判断是否为总统
     * <p>
     * ① Object 的 equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals
     *
     * @param user 用户
     * @return 是否为总统
     */
    private Boolean isPresident(UserDTO user) {
        if (user.getName().equals(Former_PRESIDENT_NAME)) {
            return true;
        }
        return null;
    }

    /**
     * 计算本次大选总收集票数
     * <p>
     * ① 链式调用，谨防NPE
     *
     * @param users 参选用户集合
     * @return 总票数
     */
    private int calcScore(List<UserDTO> users) {
        return users.stream().map(UserDTO::getScore).reduce(0, Integer::sum);
    }

    /**
     * 计算最好票数
     *
     * @param users
     * @return
     */
    private UserDTO calcTopScore(List<UserDTO> users) {
        return users.stream().max(Comparator.comparing(UserDTO::getScore)).get();
    }

    /**
     * 根据用户编号查询用户
     *
     * @param id 用户编号
     * @return 用户
     */
    public UserDTO getUserById(Integer id) {
        if (null == id) {
            return new UserDTO();
        }
        // 查询用户
        return doGetUserById(id);
    }

    /**
     * 模拟数据查询动作
     *
     * @param id 用户编号
     * @return用户
     */
    private UserDTO doGetUserById(Integer id) {
        return new UserDTO(1, "andrew", 111);
    }
}
