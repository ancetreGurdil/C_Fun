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

public class EntreeSortieController implements Initializable {
    @FXML
    private ImageView entreeImageView;
    @FXML
    private ImageView sortieImageView;
    @FXML
    private Button retour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File entreeFile = new File("src/main/resources/app/entree.png");
        Image entreeImage = new Image(entreeFile.toURI().toString());
        entreeImageView.setImage(entreeImage);

        File sortieFile = new File("src/main/resources/app/sortie.png");
        Image sortieImage = new Image(sortieFile.toURI().toString());
        sortieImageView.setImage(sortieImage);
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

    public void choixSport(){
        try{
            Stage stage = (Stage) retour.getScene().getWindow();
            stage.close();
            URL url = new File("src/main/resources/app/choixSport.fxml").toURI().toURL();
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
