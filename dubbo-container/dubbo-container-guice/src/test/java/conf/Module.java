package conf;

import com.alibaba.service.ServiceModule;
import com.google.inject.AbstractModule;

/**
 * Created by konghang on 2017/1/4.
 */
public class Module extends AbstractModule {

    @Override
    protected void configure() {
        install(new ServiceModule("com"));
    }
}
