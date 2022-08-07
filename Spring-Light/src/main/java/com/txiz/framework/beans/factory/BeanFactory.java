package com.txiz.framework.beans.factory;

import com.txiz.framework.beans.BeansException;

/**
 * 代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取
 *
 * @author Txiz
 * @since 2022 08/05
 */
public interface BeanFactory {

    /**
     * Gets bean.
     *
     * @param name the name
     * @return the bean
     * @throws BeansException the beans exception
     */
    Object getBean(String name) throws BeansException;

    /**
     * Gets bean.
     *
     * @param name the name
     * @param args the args
     * @return the bean
     * @throws BeansException the beans exception
     */
    Object getBean(String name, Object... args) throws BeansException;


    /**
     * Gets bean.
     *
     * @param <T>          the type parameter
     * @param name         the name
     * @param requiredType the required type
     * @return the bean
     * @throws BeansException the beans exception
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
