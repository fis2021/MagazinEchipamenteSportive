package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class ClientPageController
{
    @FXML
    private Button buyproductsbutton;
    @FXML
    private Button seeallyourordersbutton;
    @FXML
    private Button seeproductslistbutton;
    @FXML
    private Button logoutbutton;

    public void handleBuyProductsAction()
    {

    }


    public void handleSeeAllYourOrdersAction()
    {

    }


    public void handleSeeProductsListAction()
    {

    }

    public void handleLogoutClientAction() throws Exception
    {
        Stage LogoutClient= new Stage();
        Parent logoutclient = FXMLLoader.load(getClass().getClassLoader().getResource("StartPage.fxml"));
        LogoutClient.setTitle("StartPage");
        LogoutClient.setScene(new Scene(logoutclient, 350, 400));
        LogoutClient.show();
        cancelClientPage();
    }
    public void cancelClientPage()
    {
        logoutbutton.getScene().getWindow().hide();
    }
}
