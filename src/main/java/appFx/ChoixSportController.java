package appFx;

import app.Arrivee;
import app.Complexe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoixSportController implements Initializable {

    @FXML
    private Button muscu;
    @FXML
    private Button fitness;
    @FXML
    private Button retour;
    @FXML
    private ImageView altereImageView;
    @FXML
    private ImageView fitnessImageView;
    @FXML
    private Label musculationState;
    @FXML
    private Label fitnessState;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        if(RunTime.getCurrentComplexe().getNbPlacesRestantesFit() == 0){
            fitness.setDisable(true);
        }
        if(RunTime.getCurrentComplexe().getNbPlacesRestantesMuscu() == 0){
            muscu.setDisable(true);
        }

        musculationState.setText(String.format("Place disponible : %d/%d (%.0f%%)",RunTime.getCurrentComplexe().getNbPlacesRestantesMuscu(),
                RunTime.getCurrentComplexe().getNbTotalPlacesMuscu(),
                RunTime.getCurrentComplexe().etatMuscu()*100));
        fitnessState.setText(String.format("Place disponible : %d/%d (%.0f%%)",RunTime.getCurrentComplexe().getNbPlacesRestantesFit(),
                RunTime.getCurrentComplexe().getNbTotalPlacesFit(),
                RunTime.getCurrentComplexe().etatFit()*100));
    }
    
    public void MusculationController(){
        try{
            Parent root = FXMLLoader.load(ChoixSportController.class.getResource("/resources/app/musculation.fxml"));
            Stage window = (Stage) retour.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void retourEntreeSortie(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/resources/app/entreeSortie.fxml"));
            Stage window = (Stage) fitness.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    public void goOnFitness(){
        try{
            Parent root = FXMLLoader.load(ChoixSportController.class.getResource("/resources/app/fitness.fxml"));
            Stage window = (Stage) retour.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}
