package appFx;

import app.Arrivee;
import app.Complexe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.stream.Location;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RunTime extends Application {
    private static int nbMuscu = 4;
    private static int nbFit = 5;
    private static final String nomComplexe = "C Fun";
    private Complexe complexe;


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Scene entree Sortie
        Parent root = FXMLLoader.load(getClass().getResource("/resources/app/entreeSortie.fxml"));
        primaryStage.setTitle("Cfun Complexe");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        Image image = new Image(getClass().getResource("/resources/app/icon.png").toURI().toString());
        primaryStage.getIcons().add(image);
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.show();

        complexe = new Complexe(nbMuscu,nbFit,nomComplexe);
        currentComplexe = complexe;

    }

    public static void main(String[] args) {
        launch(args);
    }

    private static Complexe currentComplexe = null;

    public static Complexe getCurrentComplexe(){
        return currentComplexe;
    }


}

