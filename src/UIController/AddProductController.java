package UIController;

import Model.Category;
import Model.Product;
import Repository.Repository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private Button backButton;
    @FXML private TextField nameTextField;
    @FXML private ChoiceBox<String> categoryChoiceBox;
    @FXML private TextField priceTextField;
    @FXML private TextField quantityTextField;
    @FXML private TextField brandTextField;


    private final Repository repository = new Repository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FileInputStream input = new FileInputStream(System.getProperty("user.dir")
                    .concat("\\src\\Assets\\icons\\arrow.png"));
            ImageView img = new ImageView(new Image(input));
            backButton.setGraphic(img);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        setCategoryOptions();
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

    private void setCategoryOptions() {
        List<String> categoryOptionList = repository.getAllCategoryByName();
        categoryOptionList.add("Null");
        categoryChoiceBox.getItems().addAll(categoryOptionList);
        categoryChoiceBox.setValue("Null");
    }

    public void addButtonEventHandle() {

        Product product = new Product(nameTextField.getText(),
                Double.parseDouble(priceTextField.getText()),
                categoryChoiceBox.getValue(),
                Integer.parseInt(quantityTextField.getText()),
                brandTextField.getText());

        repository.createProduct(product);
    }
}
