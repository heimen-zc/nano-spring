package com.zc.learn.nanospring.core.factory;

import com.zc.learn.nanospring.core.beans.*;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heimen.zc
 * @version $Id: XmlBeanFactory.java, v 0.1 2021年03月16日 20:59 heimen.zc Exp $
 **/
public class XmlBeanFactory implements BeanFactory, BeanDefinitionRegistry, BeanRegistry {

    private Map<String, BeanDefinition> beanDefinitions = new HashMap<String, BeanDefinition>();

    private Map<String, Object> beans = new HashMap<String, Object>();

    private Class reader = XmlBeanDefinitionReader.class;

    private String location;

    public XmlBeanFactory(String location) throws Exception {
        this.location = location;
        XmlBeanDefinitionReader beanDefinitionReader = (XmlBeanDefinitionReader) reader.newInstance();
        beanDefinitionReader.setBeanDefinitionRegistry(this);
        beanDefinitionReader.loadBeanDefinition(new File(location));
    }

    @Override
    public Object getBean(String name) throws Exception {
        Object bean = beans.get(name);
        if (bean!= null) {
            return bean;
        }
        //从map中获取BeanDefinition信息，然后实例化
        BeanDefinition bd = beanDefinitions.get(name);
        if (bd == null) {
            return null;
        }
        Class clazz = Class.forName(bd.getClazz());
        bean = clazz.newInstance();
        encapsulateFields(bean, bd);
        //装入缓存
        this.beans.put(name, bean);
        return bean;
    }

    protected void encapsulateFields(Object bean, BeanDefinition bd) throws Exception {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field:fields) {
            field.setAccessible(true);
            for (Property property:bd.getProperties()) {
                if (property.getName().equals(field.getName())) {
                    Object dependOn = getBean(property.getName());
                    Map<String, PropertyDescriptor> map = getBeanInfo(bean.getClass());
                    if (map.containsKey(field.getName())) {
                        map.get(field.getName()).getWriteMethod().invoke(bean, dependOn);
                    } else {
                        throw new Exception("can not find setter method!");
                    }
                }

            }
        }
    }

    private Map<String, PropertyDescriptor> getBeanInfo(Class clazz) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        Map<String, PropertyDescriptor> map = new HashMap<>();
        for (PropertyDescriptor descriptor:beanInfo.getPropertyDescriptors()) {
            map.put(descriptor.getName(), descriptor);
        }
        return map;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitions.put(beanName, beanDefinition);
    }

    @Override
    public void registerBean(String beanName, Object bean) {
        beans.put(beanName, bean);
    }
}
