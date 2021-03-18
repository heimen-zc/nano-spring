package com.zc.learn.nanospring.core.beans;

/**
 * @author heimen.zc
 * @version $Id: XmlParseContext.java, v 0.1 2021Äê03ÔÂ16ÈÕ 23:17 heimen.zc Exp $
 **/
public class XmlParseContext {

    public XmlParseContext(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    private BeanDefinitionRegistry registry;

    public void setRegistry(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }
}
