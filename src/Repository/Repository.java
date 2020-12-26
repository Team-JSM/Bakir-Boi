package Repository;

import JDBC.ProductDatabase;
import Model.Product;
import javafx.collections.ObservableList;

import java.util.List;

public class Repository {

    final private ProductDatabase productDB = new ProductDatabase();

    public void createProduct(Product product)  {
        productDB.insertProduct(product);
    }

    public ObservableList<Product> getAllProduct()
    {
        return productDB.selectAllProducts();
    }


}
