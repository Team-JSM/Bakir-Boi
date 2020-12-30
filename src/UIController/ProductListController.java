package UIController;

import Model.Product;
import Repository.Repository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductListController implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private TableView<Product> productTable;
    @FXML private TableColumn<Product, Integer> idColumn;
    @FXML private TableColumn<Product, String> name;
    @FXML private TableColumn<Product, Double> price;
    @FXML private TableColumn<Product, String> categoryColumn;
    @FXML private TableColumn<Product, String> brand;
    @FXML private TableColumn<Product, Integer> quantity;
    @FXML private TableColumn<Product, String> stockedDateColumn;

    private final Repository repository= new Repository();
    ObservableList<Product> productList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetchProduct();
        productTable.setItems(productList);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        quantity.setCellFactory(TextFieldTableCell.<Product, Integer>forTableColumn(new IntegerStringConverter()));
        brand.setCellFactory(TextFieldTableCell.forTableColumn());
        price.setCellFactory(TextFieldTableCell.<Product, Double>forTableColumn(new DoubleStringConverter()));
    }

    public void addProductButtonEventHandle(ActionEvent event) {

        try {
            FileInputStream f = new FileInputStream(
                    new File(System
                            .getProperty("user.dir")
                            .concat("\\src\\UI\\" +
                                    "AddProduct.fxml")));

            FXMLLoader loader = new FXMLLoader();
            AnchorPane newPane = loader.load(f);


            AnchorPane pane =  (AnchorPane) rootPane.getParent().getParent().getParent().getParent();
            if(pane == null){
                System.out.println("null found");
            }else{
                pane.getChildren().setAll(newPane);
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void fetchProduct(){
        productList =  repository.getAllProduct();
    }

    public void columnEditListener(TableColumn.CellEditEvent<Product, Object> e) {
        repository.updateProductByID(e.getTableColumn().getId(),e.getNewValue(),e.getRowValue().getID());
    }
}
