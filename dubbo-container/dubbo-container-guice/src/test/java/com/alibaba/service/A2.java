package com.alibaba.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.inject.Singleton;

/**
 * Created by konghang on 2017/1/4.
 */
@Singleton
@Service(application = "konghang", version = "1.0.1")
public class A2 implements Ai {

    @Override
    public void say() {
        System.out.println("I am Ai versioned 1.0.1 ");
    }
}
