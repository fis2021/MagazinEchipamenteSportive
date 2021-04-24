package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class ManagerPageController
{
    @FXML
    private Button productslistbutton;
    @FXML
    private Button addproductsbutton;
    @FXML
    private Button deleteproductsbutton;
    @FXML
    private Button editproductsbutton;
    @FXML
    private Button seeallordersbutton;
    @FXML
    private Button clientdetailsbutton;
    @FXML
    private Button logoutbutton;

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
        cancelManagerPage();
    }
    public void cancelManagerPage()
    {
        logoutbutton.getScene().getWindow().hide();
    }

}
