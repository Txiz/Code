package com.txiz.framework.beans;

/**
 * The type Beans exception.
 *
 * @author Txiz
 * @since 2022 08/05
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
