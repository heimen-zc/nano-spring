package com.zc.learn.nanospring.core.beans;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * @author heimen.zc
 * @version $Id: BeanDefinitionReaderImpl.java, v 0.1 2021Äê03ÔÂ16ÈÕ 21:02 heimen.zc Exp $
 **/
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    public static final String DEFAULT_NAMESPACE_URI = "http://ldouer.gitee.io/schema/beans";

    public static final String DEFAULT_BEANS = "beans";

    public static final String DEFAULT_BEAN = "bean";

    private BeanDefinitionParser parser = new DefaultBeanDefinitionParser();

    private BeanDefinitionRegistry beanDefinitionRegistry;

    @Override
    public void loadBeanDefinition(File file) throws Exception {
        Document doc = loadDocument(file);
        Element root = doc.getDocumentElement();
        doLoadBeanDefinition(root, createContext());
    }

    protected Document loadDocument(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(file);
    }

    protected void doLoadBeanDefinition(Element root, XmlParseContext context) throws Exception{
//        if (root.getNamespaceURI() != null && !root.getNamespaceURI().equals(DEFAULT_NAMESPACE_URI)) {
//            throw new Exception("do not support custom namespace uri!");
//        }
        if (root.getNodeName().equals(DEFAULT_BEANS)) {
            NodeList nodeList = root.getChildNodes();
            for (int i=0;i<nodeList.getLength();i++) {
                if (nodeList.item(i) instanceof Element)
                    doLoadBeanDefinition((Element) nodeList.item(i), context);
            }
        }
        if (root.getNodeName().equals(DEFAULT_BEAN)) {
            DefaultBeanDefinition beanDefinition = new DefaultBeanDefinition();
            parser.parseElement(root, beanDefinition, context);
        }
    }

    protected XmlParseContext createContext() {
        return new XmlParseContext(beanDefinitionRegistry);
    }

    public void setBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }
}
