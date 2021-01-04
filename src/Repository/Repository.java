package Repository;

import JDBC.CategoryDatabase;
import JDBC.ProductDatabase;
import Model.Category;
import Model.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class Repository {

    final private ProductDatabase productDB = new ProductDatabase();
    final private CategoryDatabase categoryDB = new CategoryDatabase();



    public void createProduct(Product product)  {
        productDB.insertProduct(product);
    }

    public ObservableList<Product> getAllProduct()
    {
        return productDB.selectAllProducts();
    }
    public List<String> getAllCategoryByName() {
        return categoryDB.selectAllCategoryByName();
    }
    public void updateProductByID(String field,Object newValue,int ID){
        productDB.updateProductByID(field,newValue,ID);
    }
    public void deleteProductByID(int productID){
        productDB.deleteProductByID(productID);
    }


    public ObservableList<Category> getAllCategory()
    {
        return categoryDB.selectAllCategory();
    }
    public void createCategory(Category category) {
        categoryDB.insertCategory(category);
    }
    public void deleteCategoryByName(String name){
        categoryDB.deleteCategoryByName(name);
    }
    public void updateCategoryByName(String field,Object newValue,String name){
        categoryDB.updateCategoryByName(field,newValue,name);
    }
}
