package com.osleague.osf.tcp.spring;

import com.osleague.osf.tcp.spring.parser.ApplicationBeanDefinitionParser;
import com.osleague.osf.tcp.spring.parser.ReferenceBeanDefinitionParser;
import com.osleague.osf.tcp.spring.parser.RegistryBeanDefinitionParser;
import com.osleague.osf.tcp.spring.parser.ServiceBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by Yif Zhan on 2015/9/21.
 */
public class TcpNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("application", new ApplicationBeanDefinitionParser());
        registerBeanDefinitionParser("registry", new RegistryBeanDefinitionParser());
        registerBeanDefinitionParser("service", new ServiceBeanDefinitionParser());
        registerBeanDefinitionParser("reference", new ReferenceBeanDefinitionParser());
    }
}
