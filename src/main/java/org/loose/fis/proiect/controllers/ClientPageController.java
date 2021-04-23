package org.loose.fis.proiect.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClientPageController
{

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
    }
}
