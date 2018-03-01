package org.apache.cayenne.controllers.dialogs.mainScreen;


import java.io.IOException;
import java.util.Optional;

import org.apache.cayenne.controllers.dialogs.AbstractScreen;
import org.apache.cayenne.controllers.dialogs.AbstractWindowLayout;
import org.apache.cayenne.controllers.dialogs.MainWindowSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainScreenController extends AbstractScreen implements MainWindowSupport
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MainScreenController.class);

    @FXML
    private TreeView<String> treeView;
//    private TreeView<CayenneTreeItem<String>> treeView;

    @FXML
    private AnchorPane detailAnchorPane, mainToolBarAnchorPane;

//    private DatabaseEntityLayout databaseEntityDetail; // TabPane
//    private DataDomainLayout dataDomainDetail;
//    private DataMapLayout dataMapDetail;
//    private DataNodeLayout dataNodeDetail;
//    private ObjectEntityLayout objectEntityDetail; // TabPane
//
//    private MainToolBarLayout mainToolBarLayout;


    //    private final TreeItem<CayenneTreeItem<String>> treeRoot = new CayenneTreeItem<>(); // = new TreeItem<>();
//    private final TreeItem<CayenneTreeItem<String>> treeRoot = new TreeItem<CayenneTreeItem<String>>(); // = new TreeItem<>();
    private final TreeItem<String> treeRoot = new TreeItem<>(); // = new TreeItem<>();

//    private CayenneProject cayenneProject;

    private final StringProperty titleProperty = new SimpleStringProperty();

    public MainScreenController() throws IOException
    {
        super(new Stage(), "MainWindowLayout.fxml");

        setMinimumWindowSize(900, 700);

        getStage().setOnCloseRequest(event ->
        {
            LOGGER.debug("Window is closing!");
            // ideas for checking if window should save before closing or cancel, etc:
            // event.consume();  <- Prevents window from closing
            // http://stackoverflow.com/questions/31540500/alert-box-for-when-user-attempts-to-close-application-using-setoncloserequest-in
            // http://stackoverflow.com/questions/23160573/javafx-stage-setoncloserequest-without-function

        });
    }

    @Override
    public void initializeLayout()
    {
        super.initializeLayout();
    }



    @Override
    public MainScreenController getMainWindow()
    {
        return this;
    }
}
