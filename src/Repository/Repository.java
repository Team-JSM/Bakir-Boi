package Repository;

import JDBC.ProductDatabase;
import Model.Product;

public class Repository {

    final private ProductDatabase productDB = new ProductDatabase();

    public void createProduct(Product product)  {
        productDB.insertProduct(product);
    }


}
