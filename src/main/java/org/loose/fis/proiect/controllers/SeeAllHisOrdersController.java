package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class SeeAllHisOrdersController {

    @FXML
    private Button BackButton;

    public void handleBackAction() throws Exception
    {
        Stage Client= new Stage();
        Parent client = FXMLLoader.load(getClass().getClassLoader().getResource("ClientPage.fxml"));
        Client.setTitle("ClientPage");
        Client.setScene(new Scene(client, 350, 400));
        Client.show();
        cancelSeeAllHisOrders();

    }


    public void handleShowOrderAction() throws Exception
    {

    }

    public void set()
    {

    }
    public void cancelSeeAllHisOrders()
    {
        BackButton.getScene().getWindow().hide();
    }

}
