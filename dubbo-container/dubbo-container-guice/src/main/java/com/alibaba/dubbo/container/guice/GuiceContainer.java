package com.alibaba.dubbo.container.guice;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.ConfigUtils;
import com.alibaba.dubbo.config.guice.DefaultDubboAnnotationService;
import com.alibaba.dubbo.container.Container;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by konghang on 2017/1/4.
 */
public class GuiceContainer implements Container {

    private static final Logger logger = LoggerFactory.getLogger(GuiceContainer.class);

    public static final String GUICE_CONFIG = "dubbo.guice.config";

    public static final String DEFAULT_GUICE_CONFIG = "classpath*:META-INF/spring/*.xml";

    public static final String GUICE_MODULE = "dubbo.guice.module";

    public static final String DEFAULT_GUICE_MODULE = "conf.Module";

    private Injector injector;

    @Override
    public void start() {
        String configPath = ConfigUtils.getProperty(GUICE_CONFIG);
        if (configPath == null || configPath.length() == 0) {
            configPath = DEFAULT_GUICE_CONFIG;
        }

        String guiceModule = ConfigUtils.getProperty(GUICE_MODULE);
        if (guiceModule == null || guiceModule.length() == 0) {
            guiceModule = DEFAULT_GUICE_MODULE;
        }

        Class<?> guiceModuleClass = null;
        try {
            guiceModuleClass = Class.forName(guiceModule);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(String.format("cannot find guice module class : %s", guiceModule));
        }

        AbstractModule guiceModuleInstance = null;
        try {
            guiceModuleInstance = (AbstractModule)guiceModuleClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(String.format("Instance class : %s failed.", guiceModule));
        }

        List<Module> modulesToload = new ArrayList<Module>();
        modulesToload.add(guiceModuleInstance);

        this.injector = Guice.createInjector(modulesToload);
        DefaultDubboAnnotationService instance = injector.getInstance(DefaultDubboAnnotationService.class);
        instance.start();
    }

    @Override
    public void stop() {
        DefaultDubboAnnotationService instance = injector.getInstance(DefaultDubboAnnotationService.class);
        instance.stop();
    }
}
