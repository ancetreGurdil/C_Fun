package appFx;

import app.Arrivee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ExitController implements Initializable {
    @FXML
    private Button retour;
    @FXML
    private TextField billet;
    @FXML
    private Button confirmer;
    @FXML
    private Label sortieLabel;

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void retourEntreeSortie(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/resources/app/entreeSortie.fxml"));
            Stage window = (Stage) retour.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void confirmationSortieClient(ActionEvent event){
        Arrivee arrivee = RunTime.getCurrentComplexe().sortieUsager(Integer.parseInt(billet.getText()));
        if (arrivee == null){
            sortieLabel.setTextFill(Color.rgb(255,255,255));
        }else{
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/app/montant.fxml"));
                loader.setControllerFactory(ControllerClass -> new MontantController(arrivee));
                Parent root = loader.load();
                MontantController controller = loader.getController();
                Stage window = (Stage) confirmer.getScene().getWindow();
                window.setScene(new Scene(root,600,400));
            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }
        }
    }
}
