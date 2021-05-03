package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.proiect.model.Product;

import static org.loose.fis.proiect.services.FileSystemService.getPathToFile;

public class AddToCartController
{
    @FXML
    private Button backbutton;
    @FXML
    private Button addtoshoppingcartbutton;
    @FXML
    private TextField namefield=new TextField();
    @FXML
    private TextField pricefield=new TextField();
    @FXML
    private TextField stockfield=new TextField();
    @FXML
    private TextField categoryfield=new TextField();
    @FXML
    private TextField companyfield=new TextField();

    private static ObjectRepository<Product> productRepository;
    private static Nitrite database;

    public static void initDatabase()
    {

        database = Nitrite.builder()
                .filePath(getPathToFile("products.db").toFile())
                .openOrCreate("test", "test");

        productRepository = database.getRepository(Product.class);

    }

    public void handleBackAction() throws Exception
    {

    }

    public void handleAddToShoppingCartAction() throws Exception
    {

    }
}
