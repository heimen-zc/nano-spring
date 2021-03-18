package com.zc.learn.nanospring.core.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heimen.zc
 * @version $Id: AbstractBeanDefinition.java, v 0.1 2021Äê03ÔÂ16ÈÕ 20:51 heimen.zc Exp $
 **/
public class DefaultBeanDefinition implements BeanDefinition {

    private String id;

    private String clazz;

    private List<Property> properties;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperties(Property property) {
        if (properties == null) {
            properties = new ArrayList<Property>(2);
        }
        properties.add(property);
    }
}
