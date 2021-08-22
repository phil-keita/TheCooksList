package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class MainPage {

    //MEMBERS
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Switches scene to CreateRecipe scene
     * @param event
     * @throws IOException
     */
    public void switchToCreateRecipe(ActionEvent event) throws IOException {
        root = load(getClass().getResource("/sample/Views/createRecipe.fxml"));
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
