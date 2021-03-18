package com.zc.learn.nanospring.core.beans;

/**
 * @author heimen.zc
 * @version $Id: BeanDefinitionRegistry.java, v 0.1 2021��03��17�� 00:05 heimen.zc Exp $
 **/
public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
