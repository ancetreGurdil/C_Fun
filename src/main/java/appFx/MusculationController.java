package appFx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import app.Arrivee;
import app.Complexe;

public class MusculationController implements Initializable {

    private Arrivee arrivee;
	
	@FXML
    private ImageView altereImageView;
	@FXML
    private TextField NUM_BILLET;
	@FXML
    private TextField DATE;
	@FXML
    private TextField HEURE;
	@FXML
    private TextField PLACE_LIBRE;
	@FXML
    private TextField PLACE_OCCUPE;
	@FXML
    private TextField TAUX_OCCUPE;
    @FXML
    private Button confirmer;
    @FXML
    private Button retour;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File altereFile = new File("src/main/resources/app/altere.png");
        Image altereImage = new Image(altereFile.toURI().toString());

        arrivee = RunTime.getCurrentComplexe().entreeUsager('M');

        Date date = new Date(arrivee.getHoraireArrivee());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat heureFormat = new SimpleDateFormat("HH:mm");



        PLACE_LIBRE.setText(String.format("%d",RunTime.getCurrentComplexe().getNbPlacesRestantesMuscu()));
        PLACE_OCCUPE.setText(String.format("%d",RunTime.getCurrentComplexe().getNbPlacesOccupeesMuscu()));
        TAUX_OCCUPE.setText(String.format("%.0f%%",RunTime.getCurrentComplexe().etatMuscu()*100));
        NUM_BILLET.setText(String.format("%d",arrivee.getNumeroArrivee()));
        DATE.setText(dateFormat.format(date));
        HEURE.setText(heureFormat.format(date));
    }
    

    public void confirmation(){
        System.out.println(NUM_BILLET.getText()+" Musculation");
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/resources/app/choixSport.fxml"));
            Stage window = (Stage) confirmer.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void retour(){
            RunTime.getCurrentComplexe().sortieUsager(arrivee);
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/resources/app/choixSport.fxml"));
            Stage window = (Stage) retour.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
