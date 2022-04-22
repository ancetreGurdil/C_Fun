package appFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.stream.Location;
import java.io.File;
import java.net.URL;

public class RunTime extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        //Scene accueil
        URL url = new File("src/main/resources/app/accueil.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("My New Stage Title");
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }
}
