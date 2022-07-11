package com.txiz;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Txiz
 * @since 2022-07-11
 */
@Data
@Accessors(chain = true)
public class User {

    private Long id;
    private String username;
    private String password;
    private Integer sex;
    private LocalDate birthday;
    private LocalDateTime createTime;

    /**
     * 假设这是一个字符串格式的 json 数据
     */
    private String config;
}
