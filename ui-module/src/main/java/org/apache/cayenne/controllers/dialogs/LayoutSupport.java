package org.apache.cayenne.controllers.dialogs;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public interface LayoutSupport {

    static final Logger logger = LoggerFactory.getLogger(LayoutSupport.class);

    default FXMLLoader loadFXML(final String fxmlPath) throws IOException {

        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        fxmlLoader.load();

        initializeLayout();

        return fxmlLoader;
    }

    default void initializeLayout(){
        logger.info("init " + this.getClass().getCanonicalName());

        loadChildLayouts();
    }

    default void loadChildLayouts(){}

    default void displayView(final AnchorPane anchorPane, final Node view) {
        // Remove anything already there.
        anchorPane.getChildren().removeAll(anchorPane.getChildren());

        // Make the view fill the anchor pane.
        AnchorPane.setTopAnchor(view, 0.0);
        AnchorPane.setLeftAnchor(view, 0.0);
        AnchorPane.setRightAnchor(view, 0.0);
        AnchorPane.setBottomAnchor(view, 0.0);

        // Add the view into the anchor pane.
        anchorPane.getChildren().add(view);
    }

    default void disable(final Node node)
    {
        node.setDisable(true);
    }

    default void enable(final Node node)
    {
        node.setDisable(false);
    }
}
