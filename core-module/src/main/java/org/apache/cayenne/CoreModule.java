package org.apache.cayenne;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.apache.cayenne.service.HelloService;
import org.apache.cayenne.service.HelloServiceImpl;

public class CoreModule implements Module {

    public void configure(Binder binder) {
        binder.bind(HelloService.class).to(HelloServiceImpl.class);
    }

}
