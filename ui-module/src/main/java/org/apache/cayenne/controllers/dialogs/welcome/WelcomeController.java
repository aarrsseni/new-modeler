package org.apache.cayenne.controllers.dialogs.welcome;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.cayenne.controllers.dialogs.AbstractScreen;
import org.apache.cayenne.controllers.dialogs.mainScreen.MainScreenController;
import org.apache.cayenne.preferences.ModelerPreferences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class WelcomeController extends AbstractScreen{

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @FXML
    private ListView<String> projectListView;

    @FXML
    private Button newProjectButton;

    @FXML
    private Button openProjectButton;



    public WelcomeController(final Stage stage) throws IOException {
        super(stage, "WelcomeScreen.fxml");

        initializeStyle(StageStyle.DECORATED);
        setResizable(false);
    }

    public void initialize() {
        final ObservableList<String> projects =
                FXCollections.observableArrayList(ModelerPreferences.getLastProjFiles());

        projectListView.setItems(projects);
        projectListView.getSelectionModel().select(0);

    }

    public void onNewClicked(ActionEvent actionEvent) {
        try {
            MainScreenController mainScreenController = new MainScreenController();
            mainScreenController.show();
            this.hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
