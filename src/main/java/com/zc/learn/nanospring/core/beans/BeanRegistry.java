package com.zc.learn.nanospring.core.beans;

/**
 * @author heimen.zc
 * @version $Id: BeanRegistry.java, v 0.1 2021��03��17�� 00:08 heimen.zc Exp $
 **/
public interface BeanRegistry {
    void registerBean(String beanName, Object bean);
}
