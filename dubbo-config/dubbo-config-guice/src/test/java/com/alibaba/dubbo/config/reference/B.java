package com.alibaba.dubbo.config.reference;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.service.Ai;
import com.google.inject.Singleton;

/**
 * Created by konghang on 2016/12/27.
 */
@Singleton
public class B {

    @Reference
    private Ai ai;

    public void say(){
        System.out.print("B:");
        ai.say();
    }
}
