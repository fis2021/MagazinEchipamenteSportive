package org.loose.fis.proiect;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.proiect.services.FileSystemService;
import org.loose.fis.proiect.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class MainTest
{
    @BeforeEach
    void setUp() throws Exception
    {
        FileSystemService.APPLICATION_FOLDER=".test-registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        //UserService.initDatabase();
    }
    @AfterEach
    void tearDown() {
        //UserService.CloseDatabase();
    }

    @Start
    public void start (Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("StartPage.fxml"));
        primaryStage.setTitle("Magazin de Echipamente Sportive");
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();
    }

    @Test
    void testmain(FxRobot robot)
    {
        assertThat(robot.window("Magazin de Echipamente Sportive")).isShowing();
        robot.clickOn("#registrationbutton");
        robot.clickOn("#backbutton");
        robot.clickOn("#signinbutton");
        robot.clickOn("#backbutton");
        assertThat(robot.window("StartPage")).isShowing();
    }
}