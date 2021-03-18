package com.zc.learn.nanospring.core.factory;

/**
 * @author heimen.zc
 * @version $Id: BeanFactory.java, v 0.1 2021��03��16�� 20:58 heimen.zc Exp $
 **/
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
