package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditButtonFromEditProductsController {
    @FXML
    private Button backbutton;

    public void handleEditAction() throws Exception
    {

    }
    public void handleBackAction() throws Exception
    {
        cancelEditButtonPage();
    }

    public void cancelEditButtonPage()
    {
        backbutton.getScene().getWindow().hide();
    }
}
