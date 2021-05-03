package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.proiect.model.Product;

import static org.loose.fis.proiect.services.FileSystemService.getPathToFile;

public class ShoppingCartController
{
    @FXML
    private ListView<String> list = new ListView <String> ();
    @FXML
    private Button BackButton;
    @FXML
    private Button RemoveProduct;
    @FXML
    private Button FinishCommand;

    private static ObjectRepository<Product> productRepository;

    private static Nitrite database;

    private static ObjectRepository<Product> shoppingRepository;
    private static Nitrite shopping;


    public static void initDatabase()
    {

        database = Nitrite.builder()
                .filePath(getPathToFile("products.db").toFile())
                .openOrCreate("test", "test");

        productRepository = database.getRepository(Product.class);

    }

    public static void initShopping()
    {

        shopping = Nitrite.builder()
                .filePath(getPathToFile("shoppingcart.db").toFile())
                .openOrCreate("test", "test");

        shoppingRepository = shopping.getRepository(Product.class);

    }

    public void handleBackAction() throws Exception
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("BuyProducts.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        BuyProductsController controller = loader.getController();
        controller.set();
        Stage stage = (Stage) (BackButton.getScene().getWindow());
        stage.setTitle("Buy Products");
        stage.setScene(scene);
        stage.show();
    }

    public void handleRemoveProductAction() throws Exception
    {

    }

    public void handleFinishCommandAction() throws Exception
    {

    }
    public void cancelShoppingCartPage()
    {
        BackButton.getScene().getWindow().hide();
    }
    public void set()
    {
        initShopping();
        for(Product p : shoppingRepository.find())
        {
            list.getItems().add("Name: "+ p.getName() + "         Price: "  + p.getPrice() +"         Stock: " + p.getStock() + "         Category: " + p.getCategory() +"         Company: "+ p.getCompany());
        }
        shopping.close();
    }
}
