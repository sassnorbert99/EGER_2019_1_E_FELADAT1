package window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));


        primaryStage.setTitle("Animal World");
        Scene scene = new Scene(root, 1500, 1000);
        primaryStage.setScene(scene);

        //Image horse = new Image("/resources/horse.jpg");
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
