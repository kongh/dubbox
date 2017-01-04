package com.alibaba.dubbo.container.guice;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.container.Container;
import org.junit.Test;

/**
 * Created by konghang on 2017/1/4.
 */
public class GuiceContainerTest {

    @Test
    public void testContainer() {
        GuiceContainer container = (GuiceContainer) ExtensionLoader.getExtensionLoader(Container.class).getExtension("guice");
        container.start();
        container.stop();
    }
}
