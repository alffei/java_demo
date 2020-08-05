package com.gd.talks.one.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 用户传输实体类
 */
@Data
@ToString
public class UserDTO {

    /**
     * 编号
     */
    private int id;
    /**
     * 姓名
     */
    private String name;

    /**
     * 票数
     */
    private Integer score;

    /**
     * 默认构造器
     */
    public UserDTO() {
    }

    /**
     * 构造函数
     *
     * @param id   用户编号
     * @param name 用户名
     */
    public UserDTO(int id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
