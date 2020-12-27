package UIController;

import Model.Category;
import Model.Product;
import Repository.Repository;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryListController implements Initializable {

    @FXML private TextField nameTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private TableView<Category> categoryTable;
    @FXML private TableColumn<Category, String> nameColumn;
    @FXML private TableColumn<Category, String> descriptionColumn;
    @FXML private Button addButton;

    private final Repository repository= new Repository();
    ObservableList<Category> categoryList;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setColumns();
    }

    private void setColumns() {
        fetchCategory();
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Category,String>("name")
        );
        descriptionColumn.setCellValueFactory(
                new PropertyValueFactory<Category,String>("description")
        );

        categoryTable.setItems(categoryList);

    }

    private void fetchCategory() {
        categoryList =  repository.getAllCategory();
    }

    public void addButtonEventHandle() {
        Category category = new Category(
                nameTextField.getText(),
                descriptionTextArea.getText());

        repository.createCategory(category);
        setColumns();
    }
}
