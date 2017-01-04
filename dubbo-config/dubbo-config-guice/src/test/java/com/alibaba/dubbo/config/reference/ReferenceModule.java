package com.alibaba.dubbo.config.reference;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.guice.DubboModule;
import com.google.inject.Provides;

/**
 * Created by konghang on 2017/1/3.
 */
public class ReferenceModule extends DubboModule {

    public static final String REGISTRY_ADDRESS = "zookeeper://127.0.0.1:2181";

    public ReferenceModule(String scanPackages) {
        super(scanPackages);
    }

    @Provides
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-konghang-reference-test-app");
        return applicationConfig;
    }

    @Provides
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        return registryConfig;
    }

    @Provides
    public ProtocolConfig protocolConfig() {
        ProtocolConfig registryConfig = new ProtocolConfig();
        registryConfig.setName("dubbo");
        registryConfig.setPort(20880);
        return registryConfig;
    }
}
