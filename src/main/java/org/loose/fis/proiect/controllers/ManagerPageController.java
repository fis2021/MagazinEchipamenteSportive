package org.loose.fis.proiect.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManagerPageController

{
    public void handleProductsListAction()
    {

    }


    public void handleAddProductsAction()
    {

    }


    public void handleDeleteProductsAction()
    {

    }


    public void handleEditProductsAction()
    {

    }


    public void handleSeeAllOrdersAction()
    {

    }


    public void handleClientDetailsAction()
    {

    }


    public void handleLogoutManagerAction() throws Exception
    {
        Stage LogoutManager= new Stage();
        Parent logoutmanager = FXMLLoader.load(getClass().getClassLoader().getResource("StartPage.fxml"));
        LogoutManager.setTitle("StartPage");
        LogoutManager.setScene(new Scene(logoutmanager, 350, 400));
        LogoutManager.show();
    }

}
