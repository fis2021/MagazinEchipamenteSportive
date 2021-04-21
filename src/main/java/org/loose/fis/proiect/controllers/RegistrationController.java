package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.proiect.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.proiect.services.UserService;

public class RegistrationController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private TextField emailField;
    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Manager");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            if(firstnameField.getText().trim().isEmpty())
            {
                registrationMessage.setText("Firstname missing!");
            }
            else
            if(lastnameField.getText().trim().isEmpty())
            {
                registrationMessage.setText("Lastname missing!");
            }
            else
            if(usernameField.getText().trim().isEmpty())
            {
                registrationMessage.setText("Username missing!");
            }
            else
            if(passwordField.getText().trim().isEmpty())
            {
                registrationMessage.setText("Password missing!");
            }
            else
            if((String)role.getValue()==null)
            {
                registrationMessage.setText("Select role!");
            }
            else
            if(emailField.getText().trim().isEmpty())
            {
                registrationMessage.setText("E-mail missing!");
            }
            else {
                UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue(),firstnameField.getText(),lastnameField.getText(),emailField.getText());
                registrationMessage.setText("Account created successfully!");
            }
        } catch (UsernameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
