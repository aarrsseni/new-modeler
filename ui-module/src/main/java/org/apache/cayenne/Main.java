package org.apache.cayenne;

import com.google.inject.Binder;
import com.google.inject.Module;
import io.bootique.BQCoreModule;
import io.bootique.Bootique;

public class Main implements Module {

    public static void main(String[] args) {
        Bootique.app(args).autoLoadModules()
                .module(Main.class)
                .module(UIModule.class)
                .module(CoreModule.class)
                .exec()
                .exit();
    }

    public void configure(Binder binder) {
        BQCoreModule.extend(binder).setDefaultCommand(UICommand.class);
        UIModule.setApplicationClass(binder, App.class);
    }


}
