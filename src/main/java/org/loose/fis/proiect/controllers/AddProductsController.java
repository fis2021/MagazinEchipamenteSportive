package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddProductsController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField stockField;
    @FXML
    private TextField categoryField;
    @FXML
    private TextField companyField;
    @FXML
    private Button addproductbutton;
    @FXML
    private Button backbutton;

    public void handleAddProductAction()
    {

    }
    public void handleBackAction() throws Exception
    {
        Stage Back= new Stage();
        Parent back = FXMLLoader.load(getClass().getClassLoader().getResource("ManagerPage.fxml"));
        Back.setTitle("ManagerPage");
        Back.setScene(new Scene(back, 350, 400));
        Back.show();
        cancelAddProducts();
    }
    public void cancelAddProducts()
    {
        addproductbutton.getScene().getWindow().hide();
    }
}
