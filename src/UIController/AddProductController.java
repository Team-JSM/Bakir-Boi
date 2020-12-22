package UIController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FileInputStream input = new FileInputStream(System.getProperty("user.dir")
                    .concat("\\src\\Assets\\icons\\arrow.png"));
            ImageView img = new ImageView(new Image(input));
            backButton.setGraphic(img);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }




    public void backButtonEventHandle() {
        try {
            FileInputStream f = new FileInputStream(
                    new File(System
                            .getProperty("user.dir")
                            .concat("\\src\\UI\\" +
                                    "Inventory.fxml")));

            FXMLLoader loader = new FXMLLoader();
            AnchorPane newPane = loader.load(f);

            rootPane.getChildren().setAll(newPane);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
