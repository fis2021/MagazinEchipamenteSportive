package org.loose.fis.proiect.controllers;

import com.sun.glass.ui.Menu;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.proiect.model.Product;
import org.loose.fis.proiect.model.User;
import org.loose.fis.proiect.services.ProductService;
import org.loose.fis.proiect.services.UserService;
import java.io.IOException;
import java.util.Objects;

import static org.loose.fis.proiect.services.FileSystemService.getPathToFile;

public class ProductsListController
{
    @FXML
    private static ListView<String> namelist = new ListView <String>();
    @FXML
    private static ListView<String> pricelist = new ListView <String>();
    @FXML
    private static ListView<String> stocklist = new ListView <String>();
    @FXML
    private static ListView<String> categorylist = new ListView <String>();
    @FXML
    private static ListView<String> companylist = new ListView <String>();

    private static ObjectRepository<Product> productRepository;




    public static void initDatabase()
    {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("products.db").toFile())
                .openOrCreate("test", "test");

        productRepository = database.getRepository(Product.class);
    }




    public static void seeproduct()
     {

         initDatabase();

         for (Product product : productRepository.find())
         {
             namelist.getItems().add(product.getName());
             pricelist.getItems().add(product.getPrice());
             stocklist.getItems().add(product.getStock());
             categorylist.getItems().add(product.getCategory());
             companylist.getItems().add(product.getCompany());

         }


     }


}
