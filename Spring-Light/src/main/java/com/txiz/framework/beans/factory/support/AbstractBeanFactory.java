package com.txiz.framework.beans.factory.support;

import com.txiz.framework.beans.BeansException;
import com.txiz.framework.beans.factory.BeanFactory;
import com.txiz.framework.beans.factory.config.BeanDefinition;

/**
 * The type Abstract bean factory.
 *
 * @author Txiz
 * @since 2022 08/05
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    /**
     * Do get bean t.
     *
     * @param <T>  the type parameter
     * @param name the name
     * @param args the args
     * @return the t
     */
    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * Gets bean definition.
     *
     * @param beanName the bean name
     * @return the bean definition
     * @throws BeansException the beans exception
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * Create bean object.
     *
     * @param beanName       the bean name
     * @param beanDefinition the bean definition
     * @param args           the args
     * @return the object
     * @throws BeansException the beans exception
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
