package com.zc.learn.nanospring.core.beans;

import org.w3c.dom.Element;

/**
 * @author heimen.zc
 * @version $Id: BeanDefinitionParser.java, v 0.1 2021��03��16�� 22:52 heimen.zc Exp $
 **/
public interface BeanDefinitionParser {
    void parseElement(Element root, BeanDefinition beanDefinition, XmlParseContext context);
}
