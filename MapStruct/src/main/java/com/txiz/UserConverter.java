package com.txiz;

import com.alibaba.fastjson.JSON;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * The interface User converter.
 *
 * @author Txiz
 * @since 2022 -07-11
 */
@Mapper
public interface UserConverter {

    /**
     * Do 2 vo user vo.
     *
     * @param var1 the var 1
     * @return the user vo
     */
    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVo do2Vo(User var1);

    /**
     * Vo 2 do user.
     *
     * @param var1 the var 1
     * @return the user
     */
    @Mapping(target = "sex", source = "gender")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    User vo2Do(UserVo var1);

    /**
     * Do 2 vo list.
     *
     * @param userList the user list
     * @return the list
     */
    List<UserVo> do2voList(List<User> userList);

    /**
     * Str config to list user config list.
     *
     * @param config the config
     * @return the list
     */
    default List<UserVo.UserConfig> strConfigToListUserConfig(String config) {
        return JSON.parseArray(config, UserVo.UserConfig.class);
    }

    /**
     * List user config to str config string.
     *
     * @param list the list
     * @return the string
     */
    default String listUserConfigToStrConfig(List<UserVo.UserConfig> list) {
        return JSON.toJSONString(list);
    }
}
