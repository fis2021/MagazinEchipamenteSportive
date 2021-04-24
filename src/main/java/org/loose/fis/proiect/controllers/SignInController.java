package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.proiect.services.UserService;
import org.loose.fis.proiect.model.User;
import javafx.scene.control.*;

import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.proiect.services.FileSystemService.getPathToFile;

import org.loose.fis.proiect.services.UserService;
public class SignInController
{

    @FXML
    private Text SignInMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button backbutton;
    @FXML
    private Button signinbutton;

    private static ObjectRepository<User> userRepository;

    public static void initDatabase()
    {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }



    public void handleSignInAction() throws Exception
    {
      initDatabase();
        if(usernameField.getText().trim().isEmpty())
        {
            SignInMessage.setText("Username missing!");
        }
        else
        if(passwordField.getText().trim().isEmpty())
        {
            SignInMessage.setText("Password missing!");
        }
        else
        {
            for (User user : userRepository.find())
            {
                if (Objects.equals(usernameField.getText(),user.getUsername()))
                {
                    if (Objects.equals(encodePassword(usernameField.getText(),passwordField.getText()),user.getPassword()))
                    {
                        if(user.getRole().equals("Client"))
                        {
                            Stage Client= new Stage();
                            Parent client = FXMLLoader.load(getClass().getClassLoader().getResource("ClientPage.fxml"));
                            Client.setTitle("ClientPage");
                            Client.setScene(new Scene(client, 350, 400));
                            Client.show();
                            cancelSignIn();
                        }
                        if(user.getRole().equals("Manager"))
                        {
                            Stage Manager= new Stage();
                            Parent manager = FXMLLoader.load(getClass().getClassLoader().getResource("ManagerPage.fxml"));
                            Manager.setTitle("ManagerPage");
                            Manager.setScene(new Scene(manager, 350, 400));
                            Manager.show();
                            cancelSignIn();
                        }

                    }

                    else
                    {
                        SignInMessage.setText("Incorrect Password!");
                    }
                  break;
                }
                else
                    {
                        SignInMessage.setText("Incorrect Username!");
                    }
            }
        }
    }
    public void cancelSignIn()
    {
        signinbutton.getScene().getWindow().hide();
    }
    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public void handleBackAction() throws Exception
    {
        Stage Back= new Stage();
        Parent back = FXMLLoader.load(getClass().getClassLoader().getResource("StartPage.fxml"));
        Back.setTitle("StartPage");
        Back.setScene(new Scene(back, 350, 400));
        Back.show();
        cancelSignIn();
    }

}
