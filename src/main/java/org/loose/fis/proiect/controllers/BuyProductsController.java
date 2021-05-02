package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.proiect.model.Product;

import static org.loose.fis.proiect.services.FileSystemService.getPathToFile;

public class BuyProductsController
{
    @FXML
    private ListView<String> list = new ListView <String> ();
    @FXML
    private Button BackButton;
    @FXML
    private Button ShoppingCart;
    @FXML
    private Button AddToCart;
    @FXML
    private Text EditMessage;

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

    public void handleAddToCartAction() throws Exception
    {

    }

    public void handleShoppingCartAction() throws Exception
    {

    }

    public void set()
    {
        initDatabase();
        for(Product p : productRepository.find())
        {
            list.getItems().add("Name: "+ p.getName() + "         Price: "  + p.getPrice() +"         Stock: " + p.getStock() + "         Category: " + p.getCategory() +"         Company: "+ p.getCompany());

        }
        database.close();
    }
}