package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.proiect.services.FileSystemService;
import org.loose.fis.proiect.services.UserService;
import javafx.scene.control.Button;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StartPageController
{

    @FXML
    public void handleRegistrationAction() throws Exception
    {
        Stage Secondary = new Stage();
        initDirectory();
        UserService.initDatabase();
        Parent registration = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Secondary.setTitle("Registration");
        Secondary.setScene(new Scene(registration, 350, 400));
        Secondary.show();

    }

    @FXML
    public void handleSignInAction()
    {

    }

    private void initDirectory() {
        Path applicationHomePath = FileSystemService.APPLICATION_HOME_PATH;
        if (!Files.exists(applicationHomePath))
            applicationHomePath.toFile().mkdirs();
    }


}
