package sample.Controllers;

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
import sample.Classes.Recipe;

import java.io.IOException;

import static sample.Controllers.CreateRecipe.inv;

public class RecipeListing {

    //Members
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public ComboBox combo = new ComboBox();
    private int index; // index of unit combo list
    public TextField numPpl = new TextField();
    public Label groceryList = new Label();
    public Label error =  new Label();

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
     * Initializes the combox list
     */
    public void initialize(){
        for (Recipe r : inv.getAllRecipe()){
            combo.getItems().add(r.getName() + " (" + r.getNumPpl() + ")");
        }
    }

    public void select(ActionEvent event){
        index = combo.getSelectionModel().getSelectedIndex();
    }

    /**
     * Adds recipe to list of recipes for the  grocery  lsit
     * @param event
     */
    public void addToList(ActionEvent event){
        //Error checking
        if(numPpl.getText().isEmpty()){
            error.setText("This cannot be empty");
        }
        else{
            error.setText("");
            Recipe currRecipe = inv.getRecipe(index);
            currRecipe = inv.getRecipe(index);
            int currNumPpl = Integer.parseInt(numPpl.getText());
            inv.addRecipeToList(currRecipe, currNumPpl);

            groceryList.setText(groceryList.getText() + "\n" + currRecipe.getName() + " -- " + currNumPpl);
        }

    }

    /**
     * Processes grocery  list and prints it
     * @param event
     */
    public void finishGroceryList(ActionEvent event){
        inv.fillList();
        inv.sortList();
        groceryList.setText(groceryList.getText() + "\n \n ------ \nGrocery List: \n" + inv.getList());
    }
}
