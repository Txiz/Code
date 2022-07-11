package com.txiz.dao;

import com.txiz.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * The type User dao.
 *
 * @author Txiz
 * @since 2022 -07-09
 */
@Repository
public class UserDaoImpl {

    /**
     * Find user list.
     *
     * @return the list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("txiz", 18));
    }
}
