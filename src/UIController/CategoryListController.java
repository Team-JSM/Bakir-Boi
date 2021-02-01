package UIController;

import Model.Category;
import Model.Product;
import Repository.Repository;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CategoryListController implements Initializable {

    @FXML private TextField nameTextField;
    @FXML private TextArea descriptionTextArea;
    @FXML private TableView<Category> categoryTable;
    @FXML private TableColumn<Category, String> name;
    @FXML private TableColumn<Category, String> description;

    private final Repository repository= new Repository();
    ObservableList<Category> categoryList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetchCategory();
        categoryTable.setItems(categoryList);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        categoryTable.setRowFactory(tableView -> setContextMenu());
    }

    private TableRow<Category> setContextMenu() {
        final TableRow<Category> row = new TableRow<>();
        final ContextMenu contextMenu = new ContextMenu();
        final MenuItem removeMenuItem = new MenuItem("Remove");
        removeMenuItem.setOnAction((event -> {
            String res = showAlert(Alert.AlertType.WARNING,"All the product under this category will also be deleted!");
            if(res.equals("OK")) {
                categoryTable.getItems().remove(row.getItem());
                repository.deleteCategoryByName(row.getItem().getName());
            }
        }));
        contextMenu.getItems().add(removeMenuItem);
        // Set context menu on row, but use a binding to make it only show for non-empty rows:
        row.contextMenuProperty().bind(
                Bindings.when(row.emptyProperty())
                        .then((ContextMenu)null)
                        .otherwise(contextMenu)
        );
        return row ;
    }


    private void fetchCategory() {
        categoryList =  repository.getAllCategory();
    }

    public void addButtonEventHandle() {
        Category category = new Category(
                nameTextField.getText(),
                descriptionTextArea.getText());
        if(repository.findCategoryByName(nameTextField.getText())){
            showAlert(Alert.AlertType.ERROR,"Category name already exist");
        }else{
            repository.createCategory(category);
            categoryList.add(category);
            categoryTable.refresh();
        }


    }

    public void columnEditListener(TableColumn.CellEditEvent<Category, Object> e) {
        if(e.getNewValue().toString().isEmpty()){
            showAlert(Alert.AlertType.ERROR,"This field cant be empty!");
            categoryTable.refresh();
        }else {
            repository.updateCategoryByName(e.getTableColumn().getId(), e.getNewValue(), e.getRowValue().getName());
            showAlert(Alert.AlertType.CONFIRMATION,"updated");
        }
    }

    private String showAlert(Alert.AlertType alertType, String alertMessage){
        Alert alert = new Alert(alertType,alertMessage,ButtonType.OK,
                ButtonType.CANCEL);
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getText();
    }

}
