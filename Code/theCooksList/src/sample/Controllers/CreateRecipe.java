package sample.Controllers;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Classes.Inventory;
import sample.Classes.Recipe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CreateRecipe {

    //MEMBERS

    public static Inventory inv = new Inventory();

    public static Recipe currRecipe;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static File jsonfile = new File("inventory.json");

    //FXML MEMBERS
    public TextField recipeName = new TextField();
    public TextField numPpl = new TextField();
    public Label error = new Label();
    public Label error2 = new Label();


    /**
     * Switched scene to the add ingredient scene
     * @param event
     * @throws IOException
     */
    public void switchToAdd(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/sample/Views/addIngredient.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches scene to the recipe creation scene
     * @param event
     * @throws IOException
     */
    public void createRecipe(ActionEvent event) throws IOException {
        //Input stream
        FileInputStream input = new FileInputStream(jsonfile);

        Scanner scn = new Scanner(input);
        String invText = scn.nextLine();

        //Gson
        Gson gson = new Gson();
        inv = gson.fromJson(invText, Inventory.class);

        //Check input for emptiness
        if(!inputIsCorrect()){
            return;
        }

        //exception handling and processing
        try{
            currRecipe = new Recipe (recipeName.getText(), Integer.parseInt(numPpl.getText()));
        }
        catch(Exception e){
            error.setText(e.getMessage());
            return;
        }
        switchToAdd(event);
    }

    /**
     * Checks input correctness before validation the recipe creation
     * @return
     */
    public boolean inputIsCorrect(){
        //Initialize the error messages
        error.setText("");
        error2.setText("");
        //checking if fields are empty
        if (recipeName.getText().isEmpty() || numPpl.getText().isEmpty()){
            if (recipeName.getText().isEmpty()) {
                error.setText("This cannot be empty");
            }
            if (numPpl.getText().isEmpty()) {
                error2.setText("This cannot be empty");
            }
            return false;
        }
        //Integer input validation
        try{
            int ppl = Integer.parseInt(numPpl.getText());
        }
        catch(NumberFormatException i){
            error2.setText("Type in an integer");
            return false;
        }
        return true;
    }
}
