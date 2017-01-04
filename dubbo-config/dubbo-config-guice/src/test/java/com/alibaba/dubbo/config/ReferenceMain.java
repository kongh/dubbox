package com.alibaba.dubbo.config;

import com.alibaba.dubbo.config.guice.DefaultDubboAnnotationService;
import com.alibaba.dubbo.config.reference.B;
import com.alibaba.dubbo.config.reference.ReferenceModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by konghang on 2016/12/15.
 */
public class ReferenceMain {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ReferenceModule("com.alibaba.dubbo.config.reference"));
        DefaultDubboAnnotationService instance = injector.getInstance(DefaultDubboAnnotationService.class);
        instance.start();
        B b = injector.getInstance(B.class);
        b.say();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        instance.stop();
    }
}
