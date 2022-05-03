package appFx;

import javafx.event.ActionEvent;
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
    public static String choixEntreeSortie;
    @FXML
    private ImageView entreeImageView;
    @FXML
    private ImageView sortieImageView;
    @FXML
    private Button entree,sortie,retour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File entreeFile = new File("src/main/resources/app/entree.png");
        Image entreeImage = new Image(entreeFile.toURI().toString());
        entreeImageView.setImage(entreeImage);

        File sortieFile = new File("src/main/resources/app/sortie.png");
        Image sortieImage = new Image(sortieFile.toURI().toString());
        sortieImageView.setImage(sortieImage);

    }
    public void annulation(){
        try {
            Stage stage = (Stage) retour.getScene().getWindow();
            stage.close();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML public void choixSport(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/app/choixSport.fxml"));
            Parent root = loader.load();
            ChoixSportController controller = loader.getController();
            Stage window = (Stage) entree.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML public void sortie(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/app/sortie.fxml"));
            Parent root = loader.load();
            ExitController controller = loader.getController();
            Stage window = (Stage) entree.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
