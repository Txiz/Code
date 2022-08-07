package com.txiz.framework.beans.factory.config;

/**
 * The interface Bean reference.
 *
 * @author Txiz
 * @since 2022 08/07
 */
public class BeanReference {

    /**
     * The constant beanName.
     */
    private final String beanName;

    /**
     * Instantiates a new Bean reference.
     *
     * @param beanName the bean name
     */
    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    /**
     * Gets bean name.
     *
     * @return the bean name
     */
    public String getBeanName() {
        return beanName;
    }
}
