package UIController;

import Model.Product;
import Repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductListController implements Initializable {

    @FXML private AnchorPane rootPane;
    @FXML private TableView productTable;
    @FXML private TableColumn idColumn;
    @FXML private TableColumn nameColumn;
    @FXML private TableColumn priceColumn;
    @FXML private TableColumn categoryColumn;
    @FXML private TableColumn brandColumn;
    @FXML private TableColumn quantityColumn;
    @FXML private TableColumn stockedDateColumn;

    private Repository repository= new Repository();
    ObservableList<Product> productList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetchProduct();
        setColumns();
    }

    private void setColumns() {
        idColumn.setCellValueFactory(
                new PropertyValueFactory<Product, Integer>("ID")
        );
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<Product,String>("name")
        );
        categoryColumn.setCellValueFactory(
                new PropertyValueFactory<Product,String>("category")
        );
        priceColumn.setCellValueFactory(
                new PropertyValueFactory<Product,Double>("price")
        );
        brandColumn.setCellValueFactory(
                new PropertyValueFactory<Product,String>("brand")
        );
        quantityColumn.setCellValueFactory(
                new PropertyValueFactory<Product,String>("quantity")
        );
        stockedDateColumn.setCellValueFactory(
                new PropertyValueFactory<Product,String>("stockedDate")
        );

        productTable.setItems(productList);


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
        if(productList == null)
        {
            System.out.println("lol");
        }
    }


}
