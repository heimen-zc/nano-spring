package com.zc.learn.nanospring.core.beans;

/**
 * @author heimen.zc
 * @version $Id: BeanDefinitionRegistryUtil.java, v 0.1 2021Äê03ÔÂ17ÈÕ 00:03 heimen.zc Exp $
 **/
public class BeanDefinitionRegistryUtil {

    public static void registryBeanDefinition(BeanDefinition beanDefinition, XmlParseContext context) {
        context.getRegistry().registerBeanDefinition(beanDefinition.getId(), beanDefinition);
    }
}
