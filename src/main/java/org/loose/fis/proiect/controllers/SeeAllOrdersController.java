package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class SeeAllOrdersController
{

    @FXML
    private Button BackButton;
    @FXML
    private Button ShowOrder;

    public void handleBackAction () throws Exception
    {

        Stage Back= new Stage();
        Parent back = FXMLLoader.load(getClass().getClassLoader().getResource("ManagerPage.fxml"));
        Back.setTitle("Manager Page");
        Back.setScene(new Scene(back, 350, 400));
        Back.show();
        cancelSeeAllOrders();
    }

    public void handleShowOrderAction()
    {

    }

    public void set ()
    {

    }


    public void cancelSeeAllOrders()
    {
        BackButton.getScene().getWindow().hide();
    }
}
