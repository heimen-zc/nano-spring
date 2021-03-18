package com.zc.learn.nanospring.ioc;

import java.lang.reflect.Field;

/**
 * @author heimen.zc
 * @version $Id: ClassA.java, v 0.1 2021Äê03ÔÂ17ÈÕ 00:21 heimen.zc Exp $
 **/
public class ClassA {

    private ClassB classB;

    public void print() {
        classB.print();
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}
