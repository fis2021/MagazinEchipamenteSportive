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
    private Button BackButton;


    @FXML
    private ListView<String> list = new ListView <String> ();




    private static ObjectRepository <Product> productRepository;




    public static void initDatabase()
    {

        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("products.db").toFile())
                .openOrCreate("test", "test");

        productRepository = database.getRepository(Product.class);

    }




    public void set()
    {
        initDatabase();
        for(Product p : productRepository.find())
        {
            list.getItems().add("               "+ p.getName() + "                     "  + p.getPrice() +"                           " + p.getStock() + "                                " + p.getCategory() +"                          "+ p.getCompany());

        }
    }


    public void handleBackAction() throws Exception
    {
        Stage Back= new Stage();
        Parent back = FXMLLoader.load(getClass().getClassLoader().getResource("ManagerPage.fxml"));
        Back.setTitle("Manager Page");
        Back.setScene(new Scene(back, 350, 400));
        Back.show();
        cancelProductListPage();
    }



    public void cancelProductListPage()
    {
        BackButton.getScene().getWindow().hide();
    }


    public void handleAddAction() throws Exception
    {

    }

    public void handleEditAction() throws Exception
    {

    }

    public void handleDeleteAction() throws Exception
    {

    }

}
