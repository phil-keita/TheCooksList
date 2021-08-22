package sample.Controllers;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Classes.Ingredient;

import java.io.*;

import static javafx.fxml.FXMLLoader.load;
import static sample.Controllers.CreateRecipe.*;

public class AddIngredient {

    //MEMBERS

    //Scenes members
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML

    // Ingredient name & quantity
    public TextField ingName = new TextField();
    public TextField quantity = new TextField();

    //Units management members
    public ComboBox<String> comboUnits = new ComboBox<String>();
    private String[] units = {" ", "tsp", "tbsp", "oz", "cup", "gill", "g", "kg", "L", "mL"};
    private int index; //stores index of the unit chosen in the list

    //text area
    public Label textArea = new Label();

    //error  labels
    public Label error1 = new Label();
    public Label error2 = new Label();

    /**
     * initializes the combo box
     */
    public void initialize(){
        for (String s : units){
            comboUnits.getItems().add(s);
        }
    }

    /**
     * gets index of the unit chosen
     * @param event
     */
    public void SelectUnit(ActionEvent event){
        index = comboUnits.getSelectionModel().getSelectedIndex();
    }

    /**
     * Adds  ingredient to recipe
     * @param event
     */
    public void addIngredient(ActionEvent event){
        //Checks for erros
        if(ingName.getText().isEmpty()){
            error1.setText("This cannot be empty");
        }

        if(quantity.getText().isEmpty()){
            error2.setText("This cannot be empty");
        }

        if (textArea.getText().equals("")){
            textArea.setText(currRecipe.getName() + "(" + currRecipe.getNumPpl() + " people) -- \n");
        }

        //Creates the Ingredient object and adds it to the recipe
        String name = ingName.getText();
        int q = Integer.parseInt(quantity.getText());
        String u = units[index];

        Ingredient i = new Ingredient(name, q, u);
        currRecipe.addIngredient(i);
        textArea.setText(textArea.getText() + "\n" + name + ": " + q + " " + u);
        ingName.setText("");
        quantity.setText("");
    }

    /**
     * Adds recipe to the inventory
     * @param event
     * @throws IOException
     */
    public void finish(ActionEvent event)throws IOException{

        inv.addRecipeToInv(currRecipe);

        //Gson management
        Gson gson = new Gson();
        String invText = gson.toJson(inv);
        System.out.println(invText);

        //File IO
        FileOutputStream output = new FileOutputStream(jsonfile);
        PrintWriter pen = new PrintWriter(output);
        pen.print(invText);
        pen.close();
    }

    /**
     * Switches scene to MainPage
     * @param event
     * @throws IOException
     */
    public void switchToMain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/sample/Views/mainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Switches scene to RecipeListing scene
     * @param event
     * @throws IOException
     */
    public void switchToRecipeListing(ActionEvent event) throws IOException{
        Parent root = load(getClass().getResource("/sample/Views/recipeListing.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
