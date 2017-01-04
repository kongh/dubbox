package com.alibaba.dubbo.config.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.inject.Singleton;

/**
 * Created by konghang on 2016/12/15.
 */
@Singleton
@Service(application = "konghang")
public class A implements Ai{

    @Override
    public void say() {
        System.out.println(123);
    }
}
