package com.zc.learn.nanospring.core.beans;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author heimen.zc
 * @version $Id: BeanDefinitionParserImpl.java, v 0.1 2021Äê03ÔÂ16ÈÕ 22:54 heimen.zc Exp $
 **/
public class DefaultBeanDefinitionParser implements BeanDefinitionParser {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CLASS = "class";
    public static final String PROPERTY = "property";
    public static final String REF = "ref";
    public static final String VALUE = "value";


    @Override
    public void parseElement(Element element, BeanDefinition beanDefinition, XmlParseContext context) {
        if (element.hasAttribute(ID))
            beanDefinition.setId(element.getAttribute(ID));
        if (element.hasAttribute(CLASS))
            beanDefinition.setClazz(element.getAttribute(CLASS));
        parseProperty(beanDefinition, element);
        BeanDefinitionRegistryUtil.registryBeanDefinition(beanDefinition, context);
    }

    protected void parseProperty(BeanDefinition beanDefinition, Element element) {
        NodeList list = element.getChildNodes();
        for (int i=0;i<list.getLength();i++) {
            Node node = list.item(i);
            if (node instanceof Element) {
                Property property = new Property();
                if (node instanceof Element && node.getNodeName().equals(PROPERTY)) {
                    Element nodeElement = (Element)node;
                    if (nodeElement.hasAttribute(NAME)) {
                        property.setName(nodeElement.getAttribute(NAME));
                    }
                    if (nodeElement.hasAttribute(VALUE)) {
                        property.setValue(nodeElement.getAttribute(VALUE));
                    }
                    if (nodeElement.hasAttribute(REF)) {
                        property.setRef(nodeElement.getAttribute(REF));
                    }
                }
                beanDefinition.addProperties(property);
            }
        }
    }
}
