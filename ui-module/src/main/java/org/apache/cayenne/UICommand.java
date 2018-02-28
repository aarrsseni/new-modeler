package org.apache.cayenne;

import com.google.inject.Injector;
import com.google.inject.Provider;
import io.bootique.cli.Cli;
import io.bootique.command.Command;
import io.bootique.command.CommandOutcome;
import javafx.application.Application;

public class UICommand implements Command {

    private Provider<Class<? extends BQApplication>> appProvider;
    private Provider<Injector> injectorProvider;

    public UICommand(Provider<Injector> injectorProvider, Provider<Class<? extends BQApplication>> appProvider) {
        this.appProvider = appProvider;
        this.injectorProvider = injectorProvider;
    }

    public CommandOutcome run(Cli cli) {

        BQApplication.INJECTOR = injectorProvider.get();

        Application.launch(appProvider.get());
        return CommandOutcome.succeeded();
    }
}
