package org.loose.fis.proiect.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private static ObjectRepository<Product> productRepository;

    public static void initDatabase()
    {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("products.db").toFile())
                .openOrCreate("test", "test");

        productRepository = database.getRepository(Product.class);
    }

    public void seeproductslist()
    {
        initDatabase();


    }


}
