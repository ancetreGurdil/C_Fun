package appFx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoixSportController implements Initializable {

    @FXML
    private ImageView altereImageView;
    @FXML
    private ImageView fitnessImageView;
    @FXML
    private Button retour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File altereFile = new File("src/main/resources/app/altere.png");
        Image altereImage = new Image(altereFile.toURI().toString());
        altereImageView.setImage(altereImage);

        File fitnessFile = new File("src/main/resources/app/fitness.png");
        Image fitnessImage = new Image(fitnessFile.toURI().toString());
        fitnessImageView.setImage(fitnessImage);
    }

    public void retourLogin(){
        try {
            Stage stage = (Stage) retour.getScene().getWindow();
            stage.close();
            URL url = new File("src/main/resources/app/accueil.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root,600,400));
            registerStage.show();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
