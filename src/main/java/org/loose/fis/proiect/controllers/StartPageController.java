package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.dizitart.no2.exceptions.NitriteException;
import org.loose.fis.proiect.services.FileSystemService;
import org.loose.fis.proiect.services.UserService;
import javafx.scene.control.Button;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StartPageController
{
    @FXML
    private Button registrationbutton;
    @FXML
    private Button signinbutton;

    @FXML
    public void handleRegistrationAction() throws Exception
    {
        Stage Registration = new Stage();
        initDirectory();
        UserService.initDatabase();
        Parent registration = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Registration.setTitle("Registration");
        Registration.setScene(new Scene(registration, 350, 400));
        Registration.show();
        CancelStartPage();

    }

    @FXML
    public void handleSignInAction() throws Exception , NitriteException
    {
       Stage SignIn= new Stage();
       Parent signin = FXMLLoader.load(getClass().getClassLoader().getResource("SignIn.fxml"));
       SignIn.setTitle("Sign In");
       SignIn.setScene(new Scene(signin, 350, 400));
       SignIn.show();
       CancelStartPage();
    }

    private void initDirectory()
    {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }
    public void CancelStartPage()
    {
        registrationbutton.getScene().getWindow().hide();
    }


}
