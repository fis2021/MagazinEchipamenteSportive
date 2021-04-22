package org.loose.fis.proiect.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.proiect.services.UserService;
import org.loose.fis.proiect.model.User;

import java.util.Objects;

import static org.loose.fis.proiect.services.FileSystemService.getPathToFile;

public class SignInController
{

    @FXML
    private Text SignInMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;

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
                if (Objects.equals(usernameField, user.getUsername()))
                {
                    if (Objects.equals(passwordField,user.getPassword()))
                    {
                        if(user.getRole().equals("Client"))
                        {
                            FXMLLoader.load(getClass().getClassLoader().getResource("PagClient.fxml"));
                        }
                        if(user.getRole().equals("Manager"))
                        {
                            FXMLLoader.load(getClass().getClassLoader().getResource("PagManager.fxml"));
                        }
                    }
                    else
                    {
                        SignInMessage.setText("Incorrect Password!");
                    }

                }
                else
                    {
                        SignInMessage.setText("Incorrect Username!");
                    }
            }
        }
    }

}
