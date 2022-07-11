package com.txiz.service;

import com.txiz.dao.UserDaoImpl;
import com.txiz.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Txiz
 * @since 2022-07-09
 */
@Service
public class UserServiceImpl {

    @Resource
    private UserDaoImpl userDao;

    public List<User> findUserList() {
        return userDao.findUserList();
    }
}
