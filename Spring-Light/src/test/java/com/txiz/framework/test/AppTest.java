package com.txiz.framework.test;

import com.txiz.framework.beans.PropertyValue;
import com.txiz.framework.beans.PropertyValues;
import com.txiz.framework.beans.factory.config.BeanDefinition;
import com.txiz.framework.beans.factory.config.BeanReference;
import com.txiz.framework.beans.factory.support.DefaultListableBeanFactory;
import com.txiz.framework.test.bean.UserDao;
import com.txiz.framework.test.bean.UserService;
import org.junit.Test;

/**
 * @author Txiz
 * @since 2022-08-05
 */
public class AppTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2. UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
        // 3. UserService 设置属性[uId、userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
        // 4. UserService 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);
        // 5. UserService 获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
