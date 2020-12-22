package UIController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;


public class MainMenuController implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private Button productButton;
    @FXML private Button categoryButton;
    @FXML private Button transactionButton;
    @FXML private Button dueButton;
    @FXML private Button profitButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

    public void inventoryButtonEventHandle(ActionEvent event) {

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
