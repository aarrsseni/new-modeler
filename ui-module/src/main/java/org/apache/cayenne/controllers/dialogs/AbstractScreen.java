package org.apache.cayenne.controllers.dialogs;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class AbstractScreen extends AnchorPane implements LayoutSupport{

    private static final Logger logger = LoggerFactory.getLogger(AbstractScreen.class);

    private final Stage stage;

    public AbstractScreen(final Stage stage, final String fxmlPath) throws IOException {

        loadFXML(fxmlPath);

        this.stage = stage;

        stage.setScene(new Scene(this));
    }

    public Stage getStage()
    {
        return stage;
    }

    public void initializeStyle(final StageStyle stageStyle)
    {
        stage.initStyle(stageStyle);
    }

    public void setMinimumWindowSize(final int width, final int height)
    {
        stage.setMinWidth(900);
        stage.setMinHeight(700);
    }

    public void setResizable(final boolean resizable)
    {
        stage.setResizable(resizable);
    }

    public void setTitle(final String title)
    {
        stage.setTitle(title);
    }

    public void show()
    {
        stage.show();
    }

    public void hide()
    {
        stage.hide();
    }
}
