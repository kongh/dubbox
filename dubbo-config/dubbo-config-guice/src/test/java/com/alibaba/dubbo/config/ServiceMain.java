package com.alibaba.dubbo.config;

import com.alibaba.dubbo.config.guice.DefaultDubboAnnotationService;
import com.alibaba.dubbo.config.service.ServiceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by konghang on 2016/12/15.
 */
public class ServiceMain {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ServiceModule("com"));
        DefaultDubboAnnotationService instance = injector.getInstance(DefaultDubboAnnotationService.class);
        instance.start();
        try {
            Thread.sleep(17000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        instance.stop();
    }
}
