package appFx;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private Button retour;
    @FXML
    private ImageView formulaireImageView;
    @FXML
    private ImageView formulaireImageView1;
    @FXML
    private Label MessageEnregistrement;
    @FXML
    private PasswordField motDePasseLabel;
    @FXML
    private PasswordField confirmLabel;
    @FXML
    private Label MessageEnregistrement1;
    @FXML
    private TextField prenomLabel;
    @FXML
    private TextField nomLabel;
    @FXML
    private TextField pseudonymeLabel;


    public void initialize(URL url, ResourceBundle resourceBundle){
        File formulaireFile = new File("src/main/resources/app/formulaire.png");
        Image formulaireImage = new Image(formulaireFile.toURI().toString());
        formulaireImageView.setImage(formulaireImage);

        File formulaireFile1 = new File("src/main/resources/app/formulaire.png");
        Image formulaireImage1 = new Image(formulaireFile1.toURI().toString());
        formulaireImageView1.setImage(formulaireImage1);
    }
    public void registerButtonOnAction(){
        if (motDePasseLabel.getText().equals(confirmLabel.getText())) {
            registerUser();
            MessageEnregistrement1.setText("you are set");
        }else{
            MessageEnregistrement1.setText("non ca marche pas");
        }
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

    public void registerUser() {
        Connection_bd connectNow = new Connection_bd();
        Connection connectDB = connectNow.getConnection();

        String prenom = prenomLabel.getText();
        String nom = nomLabel.getText();
        String pseudonyme = pseudonymeLabel.getText();
        String motDePasse = motDePasseLabel.getText();

        String insertFields="INSERT INTO compte(prenom,nom,pseudonyme,motDePasse) VALUES ('";
        String insertValues = prenom+"','"+nom+"','"+pseudonyme+"','"+motDePasse+"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            MessageEnregistrement.setText("Inscription effectuée  !");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}
