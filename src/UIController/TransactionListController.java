package UIController;

import javafx.event.ActionEvent;
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


public class TransactionListController implements Initializable {

    @FXML private Button backButton;
    @FXML private AnchorPane rootPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FileInputStream input = new FileInputStream(System.getProperty("user.dir")
                    .concat("\\src\\Assets\\icons\\arrow_sm_black.png"));
            ImageView img = new ImageView(new Image(input));
            backButton.setGraphic(img);
        }catch (FileNotFoundException e){
            System.out.println(e);
        }
    }



    public void backButtonEventHandle(ActionEvent event) {

        try {
            FileInputStream f = new FileInputStream(
                    new File(System
                            .getProperty("user.dir")
                            .concat("\\src\\UI\\" +
                                    "MainMenu.fxml")));

            FXMLLoader loader = new FXMLLoader();
            AnchorPane newPane = loader.load(f);

            rootPane.getChildren().setAll(newPane);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
