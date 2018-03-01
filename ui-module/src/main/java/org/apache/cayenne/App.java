package org.apache.cayenne;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.cayenne.controllers.dialogs.welcome.WelcomeController;

public class App extends BQApplication {

    private WelcomeController welcomeController;

    public void start(Stage primaryStage) throws Exception {

        welcomeController = new WelcomeController(primaryStage);

        welcomeController.show();
    }
}
