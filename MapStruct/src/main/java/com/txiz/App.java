package com.txiz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

/**
 * @author Txiz
 * @since 2022-07-11
 */
public class App {

    public static void main(String[] args) {

        UserVo.UserConfig userConfig = new UserVo.UserConfig();
        userConfig.setField1("Test Field1");
        userConfig.setField2(500);

        UserVo userVo = new UserVo()
                .setId(1L)
                .setUsername("zhangSan")
                .setGender(2)
                .setCreateTime("2020-01-18 15:32:54")
                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig(Collections.singletonList(userConfig));

        User user = new User()
                .setId(1L)
                .setUsername("zhangSan")
                .setSex(1)
                .setPassword("abc123")
                .setCreateTime(LocalDateTime.now())
                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig("[{\"field1\":\"Test Field1\",\"field2\":500}]");

        System.out.println(ConverterUtils.USER_CONVERTER.vo2Do(userVo));
        System.out.println(ConverterUtils.USER_CONVERTER.do2Vo(user));
    }
}
