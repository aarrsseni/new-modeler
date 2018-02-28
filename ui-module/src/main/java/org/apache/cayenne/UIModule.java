package org.apache.cayenne;

import com.google.inject.*;
import com.google.inject.multibindings.Multibinder;
import io.bootique.BQCoreModule;
import javafx.fxml.FXMLLoader;

import java.net.URL;
import java.util.Set;

public class UIModule implements Module {

    private static Multibinder<Class<? extends BQApplication>> contributeApplicationClass(Binder binder) {
        TypeLiteral<Class<? extends BQApplication>> type = new TypeLiteral<Class<? extends BQApplication>>() {
        };
        return Multibinder.newSetBinder(binder, type);
    }

    public static void setApplicationClass(Binder binder, Class<? extends BQApplication> appClass) {
        contributeApplicationClass(binder).addBinding().toInstance(appClass);
    }

    public void configure(Binder binder) {
        BQCoreModule.contributeCommands(binder).addBinding().to(UICommand.class);

        contributeApplicationClass(binder);
    }
    @Provides
    @Singleton
    UICommand provideUICommand(Provider<Injector> injectorProvider,
                               Provider<Class<? extends BQApplication>> appClassProvider) {
        return new UICommand(injectorProvider, appClassProvider);
    }

    @Provides
    @Singleton
    Class<? extends BQApplication> provideAppClass(Set<Class<? extends BQApplication>> appClasses) {
        if (appClasses.isEmpty()) {
            throw new RuntimeException("No application class specified. Use JavaFXModule.setApplicationClass(..)");
        }

        if (appClasses.size() > 1) {
            throw new RuntimeException("Multiple application classes specified: " + appClasses);
        }

        return appClasses.iterator().next();
    }

    @Provides
    @Singleton
    FXMLLoaderFactory provideFXMLLoaderFactory(Injector injector) {

        return new FXMLLoaderFactory() {
            @Override
            public FXMLLoader getLoader(URL u) {
                FXMLLoader loader = new FXMLLoader(u);

                // this makes injection into JavaFX controllers possible
                loader.setControllerFactory(aClass -> injector.getInstance(aClass));

                return loader;
            }
        };
    }
}
