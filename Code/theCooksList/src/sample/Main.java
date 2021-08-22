package sample;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Classes.Inventory;

import java.io.FileInputStream;
import java.util.Scanner;

import static sample.Controllers.CreateRecipe.jsonfile;
import static sample.Controllers.CreateRecipe.inv;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //Loads gson file into inventory  before program starts
        FileInputStream input = new FileInputStream(jsonfile);
        Scanner scn = new Scanner(input);
        String invText = scn.nextLine();
        Gson gson = new Gson();
        inv = gson.fromJson(invText, Inventory.class);

        //Starts program
        Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/mainPage.fxml"));
        primaryStage.setTitle("Grocery List App");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
