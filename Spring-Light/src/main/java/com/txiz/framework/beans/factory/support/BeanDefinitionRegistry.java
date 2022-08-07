package com.txiz.framework.beans.factory.support;

import com.txiz.framework.beans.factory.config.BeanDefinition;

/**
 * The interface Bean definition registry.
 *
 * @author Txiz
 * @since 2022 08/05
 */
public interface BeanDefinitionRegistry {

    /**
     * Register bean definition.
     *
     * @param beanName       the bean name
     * @param beanDefinition the bean definition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
