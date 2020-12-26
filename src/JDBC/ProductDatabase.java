package JDBC;

import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase implements Database{

    public void insertProduct(Product product)  {

        String sql = "INSERT INTO product(name,price,category,quantity,brand) values(?,?,?,?,?)";

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (URL, USERNAME, PASSWORD);
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,product.getName());
            pstmt.setDouble(2,product.getPrice());
            pstmt.setString(3,product.getCategory());
            pstmt.setInt(4,product.getQuantity());
            pstmt.setString(5,product.getBrand());

            boolean res = pstmt.execute();
            if(res){
                System.out.println("row inserted");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Product> selectAllProducts(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        final String sql = "SELECT * FROM PRODUCT ORDER BY ID";

        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (URL, USERNAME, PASSWORD);
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if(rs.next()){
                productList.add(getProducts(rs));
            }
            con.close();
            statement.close();
            rs.close();
            if(productList.isEmpty()){
                System.out.println("empty");
            }
            return productList;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Product getProducts(ResultSet rs) {
        try {
            Product product = new Product(
                    rs.getString("name"),
                    rs.getInt("ID"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getDate("stockedDate"),
                    rs.getInt("quantity"),
                    rs.getString("brand"));

            System.out.println("added");

            return product;
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}
