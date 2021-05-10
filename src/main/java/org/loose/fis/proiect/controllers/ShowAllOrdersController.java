package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.loose.fis.proiect.model.Order;

import java.util.Objects;

public class ShowAllOrdersController
{
    @FXML
    private Button BackButton;

    public void handleBackAction() throws Exception
    {
        cancelShowAllOrders();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("SeeAllOrders.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        SeeAllOrdersController controller = loader.getController();
        controller.set();
        Stage stage = (Stage) (BackButton.getScene().getWindow());
        stage.setTitle("See All Orders");
        stage.setScene(scene);
        stage.show();

    }
    public void set(String s)
    {

    }
    public void cancelShowAllOrders()
    {
        BackButton.getScene().getWindow().hide();
    }

}
