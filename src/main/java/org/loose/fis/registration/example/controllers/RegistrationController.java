package org.loose.fis.registration.example.controllers;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.registration.example.exceptions.UserAlreadyExistsException;
import org.loose.fis.registration.example.services.UserService;

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
    public void initialize() {
        role.getItems().addAll("Client", "Manager");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            if(usernameField.getText()!=null && passwordField.getText()!=null && (String) role.getValue()!=null)
            {
                UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
                registrationMessage.setText("Account created successfully!");
            }
            if(usernameField.getText()==null){
                registrationMessage.setText("Username missing!");
            }
            if(passwordField.getText()==null){
                registrationMessage.setText("Password missing!");
            }
            if((String) role.getValue()==null){
                registrationMessage.setText("Select role!");
            }
        } catch (UserAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
