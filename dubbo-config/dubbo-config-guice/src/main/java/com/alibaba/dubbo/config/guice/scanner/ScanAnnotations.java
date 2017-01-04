package com.alibaba.dubbo.config.guice.scanner;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by konghang on 2016/12/15.
 */
public class ScanAnnotations {

    //服务类
    private Set<Class<?>> serviceClasses;

    //引用类
    private Set<Method> referenceMethods;

    public Set<Class<?>> getServiceClasses() {
        return serviceClasses;
    }

    public void setServiceClasses(Set<Class<?>> serviceClasses) {
        this.serviceClasses = serviceClasses;
    }

    public Set<Method> getReferenceMethods() {
        return referenceMethods;
    }

    public void setReferenceMethods(Set<Method> referenceMethods) {
        this.referenceMethods = referenceMethods;
    }
}
