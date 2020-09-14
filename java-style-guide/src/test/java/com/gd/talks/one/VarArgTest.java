package com.gd.talks.one;

import org.apache.commons.lang3.RandomUtils;

public class VarArgTest {

    /**
     * Demo5 可变参数
     * <p>
     * 【强制】相同参数类型，相同业务含义，才可以使用 Java 的可变参数，避免使用 Object。
     * 说明：可变参数必须放置在参数列表的最后。（建议开发者尽量不用可变参数编程）
     * <p>
     * Q:为什么要有变长参数？
     * Q:为什么建议开发者尽量不用可变参数编程？
     *
     * @See https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.12.2
     */
    public void test() {
        System.out.println("All service is available");
//        BooleanUtils.and(mockServiceA(), mockServiceB(), mockServiceC());
    }

    /**
     * 测试【模拟服务A】是否可用
     *
     * @return 服务是否可用
     */
    private boolean mockServiceA() {
        return RandomUtils.nextBoolean();
    }

    /**
     * 测试【模拟服务B】是否可用
     *
     * @return 服务是否可用
     */
    private boolean mockServiceB() {
        return RandomUtils.nextBoolean();
    }

    /**
     * 测试【模拟服务C】是否可用
     *
     * @return 服务是否可用
     */
    private boolean mockServiceC() {
        return RandomUtils.nextBoolean();
    }

}
