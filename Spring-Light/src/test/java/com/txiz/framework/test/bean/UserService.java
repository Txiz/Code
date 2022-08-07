package com.txiz.framework.test.bean;

/**
 * The type User service.
 *
 * @author Txiz
 * @since 2022 08/05
 */
public class UserService {

    private UserDao userDao;

    private String uId;

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(uId));
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getUId() {
        return uId;
    }

    public void setUId(String uId) {
        this.uId = uId;
    }
}
