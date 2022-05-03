package appFx;

import app.Arrivee;
import com.keepautomation.barcode.BarCode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class MontantController implements Initializable {
    private Arrivee arrivee;
    @FXML
    private TextField billet;
    @FXML
    private TextField duree;
    @FXML
    private TextField montant;
    @FXML
    private Button confirmer;

    public MontantController(Arrivee arrivee){
        this.arrivee = arrivee;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        billet.setText(""+arrivee.getNumeroArrivee());
        duree.setText(String.format("%d:%02d",arrivee.getDureeEnMinute()/60,arrivee.getDureeEnMinute()%60));
        montant.setText(""+arrivee.getMontant()+" €");

    }


    public void sortieClient(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/resources/app/entreeSortie.fxml"));
            Stage window = (Stage) confirmer.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}
