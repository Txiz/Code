package com.txiz.framework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * The type User dao.
 *
 * @author Txiz
 * @since 2022 08/07
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "name1");
        hashMap.put("10002", "name2");
        hashMap.put("10003", "name3");
    }

    /**
     * Query user name string.
     *
     * @param uId the u id
     * @return the string
     */
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
