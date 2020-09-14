package com.gd.lambda.constant;

/**
 * 商品类型
 *
 * @author chenpengfei
 */
public enum SkuCategoryEnum {
    CLOTHING(10, "服饰类"), SPORTS(20, "运动类"),
    BOOKS(30, "书籍类"), ELECTRONICS(40, "数码类");

    /**
     * 商品类型编号
     */
    private Integer code;

    /**
     * 商品类型名称
     */
    private String name;

    SkuCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
