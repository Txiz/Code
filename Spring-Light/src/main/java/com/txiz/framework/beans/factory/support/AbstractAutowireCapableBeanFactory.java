package com.txiz.framework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.txiz.framework.beans.BeansException;
import com.txiz.framework.beans.PropertyValue;
import com.txiz.framework.beans.PropertyValues;
import com.txiz.framework.beans.factory.config.BeanDefinition;
import com.txiz.framework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * The type Abstract autowire capable bean factory.
 *
 * @author Txiz
 * @since 2022 08/05
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object args[]) throws BeansException {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            // 给 Bean 填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    /**
     * Create bean instance object.
     *
     * @param beanDefinition the bean definition
     * @param beanName       the bean name
     * @param args           the args
     * @return the object
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor<?> constructorInUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            if (args != null && constructor.getParameterTypes().length == args.length) {
                constructorInUse = constructor;
                break;
            }
        }
        return this.instantiationStrategy.instantiate(beanDefinition, beanName, constructorInUse, args);
    }

    /**
     * Apply property values.
     *
     * @param beanName       the bean name
     * @param bean           the bean
     * @param beanDefinition the bean definition
     */
    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    // A 依赖 B，获取 B 的实例化
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    /**
     * Gets instantiation strategy.
     *
     * @return the instantiation strategy
     */
    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    /**
     * Sets instantiation strategy.
     *
     * @param instantiationStrategy the instantiation strategy
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
