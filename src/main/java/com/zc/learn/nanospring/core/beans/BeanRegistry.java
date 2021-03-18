package com.zc.learn.nanospring.core.beans;

/**
 * @author heimen.zc
 * @version $Id: BeanRegistry.java, v 0.1 2021Äê03ÔÂ17ÈÕ 00:08 heimen.zc Exp $
 **/
public interface BeanRegistry {
    void registerBean(String beanName, Object bean);
}
