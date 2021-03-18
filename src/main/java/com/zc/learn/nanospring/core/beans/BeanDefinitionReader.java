package com.zc.learn.nanospring.core.beans;

import java.io.File;

/**
 * @author heimen.zc
 * @version $Id: XmlBeanDefinitionReader.java, v 0.1 2021��03��16�� 20:56 heimen.zc Exp $
 **/
public interface BeanDefinitionReader {
    void loadBeanDefinition(File file) throws Exception;
}
