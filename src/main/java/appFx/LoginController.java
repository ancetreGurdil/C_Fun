package appFx;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button annuler;
    @FXML
    private Label messageLabel;
    @FXML
    private ImageView boxeImageView;
    @FXML
    private ImageView muscuImageView;
    @FXML
    private ImageView veloImageView;
    @FXML
    private TextField identifiant;
    @FXML
    private PasswordField motdepasse;

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){
        File boxeFile = new File("src/main/resources/app/boxe.png");
        Image boxeImage = new Image(boxeFile.toURI().toString());
        boxeImageView.setImage(boxeImage);

        File muscuFile = new File("src/main/resources/app/muscu.png");
        Image muscuImage = new Image(muscuFile.toURI().toString());
        muscuImageView.setImage(muscuImage);

        File veloFile = new File("src/main/resources/app/velo.png");
        Image veloImage = new Image(veloFile.toURI().toString());
        veloImageView.setImage(veloImage);
    }

    public void labelLoginMessage(ActionEvent event){
        if(identifiant.getText().isBlank() == false && motdepasse.getText().isBlank() == false){
            validateLogin();
        }else {
            messageLabel.setText("entrez identifiant et mot de passe s'il vous plait");
        }
    }

    public void cancelButtonOnAction() {
        Stage stage = (Stage) annuler.getScene().getWindow();
        stage.close();
    }

    public void validateLogin(){
        Connection_bd connectNow = new Connection_bd();
        Connection connectDb = connectNow.getConnection();

        String verifyLogin = "SELECT COUNT(1) FROM compte WHERE pseudonyme = '" + identifiant.getText() + "' AND motDePasse ='" + motdepasse.getText() +"'";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if (queryResult.getInt(1)==1){
                    messageLabel.setText("felicitation");
                    choixSport();
                }else{
                    messageLabel.setText("erreur impossible de se connecter,essaye encore");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void createAccountForm(){
        try{
            Stage stage = (Stage) annuler.getScene().getWindow();
            stage.close();
            URL url = new File("src/main/resources/app/enregistrement.fxml").toURI().toURL();
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
            Stage stage = (Stage) annuler.getScene().getWindow();
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

