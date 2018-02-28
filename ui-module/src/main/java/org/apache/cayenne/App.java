package org.apache.cayenne;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends BQApplication {

    public void start(Stage primaryStage) throws Exception {
        Parent root = getLoader(org.apache.cayenne.RootController.class.getResource("Root.fxml")).load();

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("This is a test app");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
