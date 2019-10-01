package window;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;


public class Controller {
    @FXML
    private Label test;
    @FXML
    private RadioButton ans1;
    @FXML
    private RadioButton ans2;
    @FXML
    private RadioButton ans3;
    @FXML
    private ImageView animalImageView;
    @FXML
    private Button nehez;
    @FXML
    private Button kozepes;
    @FXML
    private Button konnyu;
    @FXML
    private GridPane game;
    @FXML
    private GridPane difficulty;
    @FXML
    private Label score;

    @FXML
    private Button ok;
    @FXML
    private Label finalScore;
    @FXML
    private GridPane gameOver;

    @FXML
    protected void ansCheck(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
            check();
    }
    @FXML
    protected void valaszEll(ActionEvent event) {
        check();

    }

    @FXML
    protected void gameStart(ActionEvent event) {

        if (event.getSource() == nehez) {
            imagePath += "/nehéz";
            test.setText("Nehezet választottál");
            diff = 3;
        }

        if (event.getSource() == kozepes) {
            test.setText("közepest választottál");
            imagePath += "/közepes";
            diff = 2;
        }
        if (event.getSource() == konnyu) {
            test.setText("könnyűt választottál");
            imagePath += "/könnyű";
            diff = 1;
        }
        String path = imagePath + "/animal" + Integer.toString(index + 1) + ".jpg";

        Image animalImage = new Image(path);
        animalImageView.setImage(animalImage);

        setAnswerTexts();

        difficulty.setVisible(false);
        game.setVisible(true);
    }

    private void setAnswerTexts() {
        ans1.setText(easyAnswers[index]);
        ans2.setText(mediumAnswers[index]);
        ans3.setText(hardAnswers[index]);
        if(diff != answers[index]) {
            String temp;
            switch (diff) {
                case 1:
                    temp = ans1.getText();
                    if (answers[index] == 2) {
                        ans1.setText(ans2.getText());
                        ans2.setText(temp);
                    } else {
                        ans1.setText(ans3.getText());
                        ans3.setText(temp);
                    }
                    break;
                case 2:
                    temp = ans2.getText();
                    if (answers[index] == 1) {
                        ans2.setText(ans1.getText());
                        ans1.setText(temp);
                    } else {
                        ans2.setText(ans3.getText());
                        ans3.setText(temp);
                    }
                    break;
                case 3:
                    temp = ans3.getText();
                    if (answers[index] == 2) {
                        ans3.setText(ans2.getText());
                        ans2.setText(temp);
                    } else {
                        ans3.setText(ans1.getText());
                        ans1.setText(temp);
                    }
                    break;
            }
        }
    }

    private static int diff = 0;
    private static String imagePath = "/resources";
    private static int index = 0;
    private static int[] answers = {2, 1, 3, 2, 1, 1, 3, 2, 3, 1, 3};
    private static int correct = 0;
    private static String[] easyAnswers = {"béka", "egér", "gólya", "katica", "kecske", "majom",
            "medve", "pók", "róka", "sertés", "tehén"};
    private static String[] mediumAnswers = {"bagoly", "darázs", "elefánt", "farkas", "gepárd",
            "kígyó", "oroszlán", "orrszarvú", "tigris", "zebra", "zsiráf"};
    private static String[] hardAnswers = {"borz", "bálna", "cápa", "delfin", "gekkó", "teve", "krokodil",
            "pingvin", "rozmár", "tatu", "viziló"};


    private void check() {
        int givenAnswer = ans1.isSelected() ? 1 : ans2.isSelected() ? 2 : ans3.isSelected() ? 3 : 0;
        if (givenAnswer == 0) {
            index--;
            return;
        }
        if (givenAnswer == answers[index]) {
            test.setText("Helyes Válasz!");
            correct++;
            score.setText(Integer.toString(correct));
        } else
            test.setText("Helytelen Válasz!");

        index++;
        if (index < 11) {
            String path = imagePath + "/animal" + Integer.toString(index + 1) + ".jpg";
            Image animalImage = new Image(path);
            animalImageView.setImage(animalImage);
            ans1.setSelected(false);
            ans2.setSelected(false);
            ans3.setSelected(false);

            setAnswerTexts();

        } else {
            ok.setDisable(true);
            game.setVisible(false);
            gameOver.setVisible(true);
            finalScore.setText("Helyes válaszok száma:\n" + Integer.toString(correct));
            javafx.scene.text.Font font = new Font(100);
            finalScore.setFont(font);
        }
    }

}
