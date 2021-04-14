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
    private TextField lastname;
    @FXML
    private TextField firstname;
    @FXML
    private TextField email;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Manager");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            if(firstname.getText().trim().isEmpty())
                registrationMessage.setText("Complete firstname field!");
            if(lastname.getText().trim().isEmpty())
                registrationMessage.setText("Complete lastname field!");
            if(usernameField.getText().trim().isEmpty())
                registrationMessage.setText("Complete username field!");
            if(passwordField.getText().trim().isEmpty())
                registrationMessage.setText("Complete password field!");
            if((String) role.getValue()==null)
                registrationMessage.setText("Select role!");
            if(email.getText().trim().isEmpty())
                registrationMessage.setText("Complete e-mail field!");
            if(!usernameField.getText().trim().isEmpty()
              && !passwordField.getText().trim().isEmpty()
              && (String) role.getValue()!=null
              && !firstname.getText().trim().isEmpty()
              && !lastname.getText().trim().isEmpty()
              && !email.getText().trim().isEmpty())
            {
                UserService.addUser(firstname.getText(),lastname.getText(),usernameField.getText(), passwordField.getText(), (String) role.getValue(),email.getText());
                registrationMessage.setText("Account created successfully!");
            }
        } catch (UserAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
