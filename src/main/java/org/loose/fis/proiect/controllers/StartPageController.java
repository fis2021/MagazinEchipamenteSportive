package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import org.dizitart.no2.exceptions.NitriteException;
import org.loose.fis.proiect.services.FileSystemService;
import org.loose.fis.proiect.services.UserService;
import javafx.scene.control.Button;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

public class StartPageController
{




    @FXML
    private Button registrationbutton;
    @FXML
    private Button signinbutton;

    @FXML
    public void handleRegistrationAction() throws Exception, IOException
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
    public void handleSignInAction() throws Exception
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

    public void handleEXITAction()
    {
        CancelStartPage();
    }

    public void CancelStartPage()
    {
        registrationbutton.getScene().getWindow().hide();
    }


}
