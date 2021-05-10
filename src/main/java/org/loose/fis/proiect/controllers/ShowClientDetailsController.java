package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ShowClientDetailsController
{
    @FXML
    private ListView<String> list = new ListView <String> ();
    @FXML
    private Button BackButton;

    public void handleBackAction() throws  Exception
    {
        cancelShowClientDetails();
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("SeeClientDetails.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        SeeClientDetailsController controller = loader.getController();
        controller.set();
        Stage stage = (Stage) (BackButton.getScene().getWindow());
        stage.setTitle("See Clients Details");
        stage.setScene(scene);
        stage.show();
    }

    public void set(String s)
    {

    }

    public void cancelShowClientDetails()
    {
        BackButton.getScene().getWindow().hide();
    }
}
