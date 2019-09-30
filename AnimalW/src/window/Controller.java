package window;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class Controller {
    @FXML private Label test;
    @FXML private RadioButton ans1;
    @FXML private RadioButton ans2;
    @FXML private RadioButton ans3;

    @FXML
    protected void valaszEll(ActionEvent event) {
        if(ans1.isSelected())
            test.setText("Success!!");
    }
}
