package com.zc.learn.nanospring.core.beans;

import java.util.List;

public interface BeanDefinition {
    String getId();

    void setId(String id);

    String getClazz();

    void setClazz(String clazz);

    List<Property> getProperties();

    void addProperties(Property property);
}
