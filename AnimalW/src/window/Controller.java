package window;

import com.sun.javafx.scene.web.Debugger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import jdk.nashorn.internal.runtime.logging.DebugLogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    @FXML private Label test;
    @FXML private RadioButton ans1;
    @FXML private RadioButton ans2;
    @FXML private RadioButton ans3;
    @FXML private ImageView animalImageView;
    @FXML private Button nehez;
    @FXML private Button kozepes;
    @FXML private Button konnyu;
    @FXML private GridPane game;
    @FXML private GridPane difficulty;

    @FXML
    protected void valaszEll(ActionEvent event) {
        check(index);
        index++;

        String path = imagePath + "/animal" + Integer.toString(index+1) + ".jpg" ;
        Image animalImage = new Image(path);
        animalImageView.setImage(animalImage);
    }

    @FXML
    protected void gameStart(ActionEvent event) {
        if (event.getSource() == nehez)
        {
            imagePath += "/nehéz";
            test.setText("Nehezet választottál");
        }

        if (event.getSource() == kozepes)
            {
                test.setText("közepest választottál");
                imagePath += "/közepes";
            }
        if (event.getSource() == konnyu)
            {
                test.setText("könnyűt választottál");
                imagePath += "/könnyű";
            }
        String path = imagePath + "/animal" + Integer.toString(index+1) + ".jpg" ;

        Image animalImage = new Image(path);
        animalImageView.setImage(animalImage);
        difficulty.setVisible(false);
        game.setVisible(true);
    }

    private static String imagePath = "/resources";
    private static int index = 0;
    private static int[] answers = {0, 1, 3, 2, 0, 1, 3, 2, 0, 1, 3};
    private static int correct = 0;

    private void check(int sorszam) {
        int givenAnswer = ans1.isSelected() ? 1 : ans2.isSelected() ? 2 : ans3.isSelected() ? 3 : 0;
        if (givenAnswer == answers[sorszam])
            test.setText("Helyes Válasz!");
        else
            test.setText("Helytelen Válasz!");
    }

}
