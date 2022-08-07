package com.txiz.framework.beans.factory.config;

/**
 * The interface Singleton bean registry.
 *
 * @author Txiz
 * @since 2022 08/05
 */
public interface SingletonBeanRegistry {

    /**
     * Gets singleton.
     *
     * @param beanName the bean name
     * @return the singleton
     */
    Object getSingleton(String beanName);
}
