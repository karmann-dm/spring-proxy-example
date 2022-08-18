package com.example.springproxyexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClassBasedAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final Logger logger = LoggerFactory.getLogger("LOGS FROM PROXY");

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(ClassBasedAnnotation.class)) {
            ProxyFactory proxyFactory = new ProxyFactory(bean);
            proxyFactory.addAdvice((MethodBeforeAdvice) (method, args, target) -> logger.info("Before proxy!"));
            proxyFactory.addAdvice((AfterReturningAdvice) (returnValue, method, args, target) -> logger.info("After proxy!"));
            return proxyFactory.getProxy();
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
