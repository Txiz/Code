package com.txiz.framework.beans.factory.support;

import com.txiz.framework.beans.BeansException;
import com.txiz.framework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * The type Instantiation strategy.
 *
 * @author Txiz
 * @since 2022 08/07
 */
public interface InstantiationStrategy {

    /**
     * Instantiate object.
     *
     * @param beanDefinition the bean definition
     * @param beanName       the bean name
     * @param constructor    the constructor
     * @param args           the args
     * @return the object
     * @throws BeansException the beans exception
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> constructor, Object[] args) throws BeansException;
}
