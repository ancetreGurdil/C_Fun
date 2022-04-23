package appFx;

import app.Arrivee;
import app.Complexe;
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
import java.time.LocalDateTime;
import java.util.Date;
import java.util.ResourceBundle;

public class FitnessController implements Initializable {

    @FXML
    private ImageView fitnessImageView;
    @FXML
    private ImageView fitnessImageView1;
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
    private Button retour;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File fitnessFile = new File("src/main/resources/app/fitness.png");
        Image fitnessImage = new Image(fitnessFile.toURI().toString());
        fitnessImageView.setImage(fitnessImage);

        File fitnessFile1 = new File("src/main/resources/app/fitness.png");
        Image fitnessImage1 = new Image(fitnessFile1.toURI().toString());
        fitnessImageView1.setImage(fitnessImage1);

        getNUM_BILLET();
        getDATE();
        getHEURE();
        getNbPlacesRestantesFit();
        getPLACE_OCCUPE();
        getTAUX_OCCUPE();

    }


    Arrivee arrivee = new Arrivee(null,'F');
    Complexe complexe = new Complexe(5,4,"Cfun");



    public TextField getNUM_BILLET() {

        arrivee.getNumeroArrivee();
        int total = arrivee.getNumeroArrivee()+1;
        NUM_BILLET.setText(""+total+"");
        return NUM_BILLET;
    }

    public TextField getDATE() {
        LocalDate date = LocalDate.now();
        DATE.setText(""+date+"");
        return DATE ;
    }

    public TextField getHEURE() {
        Format f = new SimpleDateFormat("HH.mm.ss");
        String strResult = f.format(new Date());
        HEURE.setText(""+strResult+"");
        return HEURE;
    }
    public TextField getNbPlacesRestantesFit(){
        int nombrePlaceDispo = complexe.getNbPlacesRestantesFit();
        PLACE_LIBRE.setText(""+nombrePlaceDispo+"");
        return PLACE_LIBRE;
    }

    public TextField getPLACE_OCCUPE(){
        int nombrePlaceOccupe = complexe.getNbPlacesOccupeesFit();
        PLACE_OCCUPE.setText(""+nombrePlaceOccupe+"");
        return PLACE_OCCUPE;
    }

    public void retourLogin(){
        try {
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
    public TextField getTAUX_OCCUPE(){
        double TauxOccupe = complexe.etatMuscu();
        TAUX_OCCUPE.setText(""+TauxOccupe+"");
        return TAUX_OCCUPE;
    }


}