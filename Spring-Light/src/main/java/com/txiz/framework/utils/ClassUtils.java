package com.txiz.framework.utils;

/**
 * The type Class utils.
 *
 * @author Txiz
 * @since 2022 08/07
 */
public class ClassUtils {

    /**
     * Gets default class loader.
     *
     * @return the default class loader
     */
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (classLoader == null) {
            // No thread context class loader -> use class loader of this class.
            classLoader = ClassUtils.class.getClassLoader();
        }
        return classLoader;
    }
}
