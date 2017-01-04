package com.alibaba.dubbo.config.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * Created by konghang on 2016/12/15.
 */
public abstract class DubboModule extends AbstractModule{

    private String scanPackages = "";

    public DubboModule(String scanPackages) {
        this.scanPackages = scanPackages;
    }

    @Override
    protected void configure() {
        bindConstant().annotatedWith(Names.named("dubbo.scan.packages")).to(scanPackages);
        bind(DubboExportService.class).in(Scopes.SINGLETON);
        DubboReferenceService referenceService = new DubboReferenceService();
        bind(DubboReferenceService.class).toInstance(referenceService);
        bind(DubboAnnotationService.class).to(DefaultDubboAnnotationService.class);
        bindListener(Matchers.any(), referenceService);
    }

//    @Provides
//    @Named(value = "konghang")
//    public ApplicationConfig applicationConfig() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName(APPLICATION_NAME);
//        return applicationConfig;
//    }
//
//    @Provides
//    @Named(value = "konghang2")
//    public ApplicationConfig applicationConfig2() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName("konghang2");
//        return applicationConfig;
//    }

//    @Provides
//    public RegistryConfig registryConfig() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress(REGISTRY_ADDRESS);
//        return registryConfig;
//    }
//
//    @Provides
//    public ProtocolConfig protocolConfig() {
//        ProtocolConfig registryConfig = new ProtocolConfig();
//        registryConfig.setName("dubbo");
//        registryConfig.setPort(20880);
//        return registryConfig;
//    }
}
