package com.txiz;

import com.txiz.entity.User;
import com.txiz.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Txiz
 * @since 2022-07-09
 */
public class App {

    public static void main(String[] args) {
        // create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // retrieve configured instance
        UserServiceImpl service = context.getBean("userServiceImpl", UserServiceImpl.class);
        // use configured instance
        List<User> userList = service.findUserList();
        // print info from beans
        userList.forEach(a -> System.out.println(a.getName() + "," + a.getAge()));
    }
}
