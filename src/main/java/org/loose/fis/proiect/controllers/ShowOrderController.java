package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class ShowOrderController
{
    @FXML
    private Button BackButton;

    private static String username;

    public void handleBackAction () throws Exception
    {
        cancelSeeAllHisOrders();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("SeeAllHisOrders.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        SeeAllHisOrdersController controller = loader.getController();
        controller.set(username);
        Stage stage = (Stage) (BackButton.getScene().getWindow());
        stage.setTitle("See All Your Orders");
        stage.setScene(scene);
        stage.show();

    }

    public void set (String username)
    {
         this.username = username;
    }

    public void cancelSeeAllHisOrders()
    {
        BackButton.getScene().getWindow().hide();
    }

}
