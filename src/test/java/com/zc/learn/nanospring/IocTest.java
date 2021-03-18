package com.zc.learn.nanospring;

import com.zc.learn.nanospring.core.factory.XmlBeanFactory;
import org.junit.Test;

/**
 * @author heimen.zc
 * @version $Id: IocTest.java, v 0.1 2021Äê03ÔÂ17ÈÕ 00:20 heimen.zc Exp $
 **/
public class IocTest {

    @Test
    public void test() throws Exception {
        XmlBeanFactory factory = new XmlBeanFactory("src/main/resources/application.xml");
        factory.getBean("classA");
        System.out.println();
    }
}
