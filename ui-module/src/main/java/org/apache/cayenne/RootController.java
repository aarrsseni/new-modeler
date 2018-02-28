package org.apache.cayenne;

import com.google.inject.Inject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.cayenne.service.HelloService;

public class RootController {

    private HelloService helloService;

    @FXML
    private Text actionTarget;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @Inject
    public RootController(HelloService helloService) {
        this.helloService = helloService;
    }

    public void handleSubmitButtonAction(ActionEvent actionEvent) {
        actionTarget.setText(helloService.sayIt());
    }

}
