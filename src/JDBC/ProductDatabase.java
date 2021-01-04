package JDBC;

import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class ProductDatabase implements Database{

    public void updateProductByID(String field,Object newValue,int ID){
        String sql = "UPDATE product " +
                     "SET "+ field + " = '" + newValue +
                     "' WHERE id = " + ID;

        System.out.println(sql);

        try {
            Connection con = establishConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            con.close();
            statement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteProductByID(int ID){
        String sql = "DELETE FROM product " +
               // "SET "+ field + " = '" + newValue +
                " WHERE id = " + ID;

        System.out.println(sql);

        try {
            Connection con = establishConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            con.close();
            statement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertProduct(Product product)  {

        String sql = "INSERT INTO product(name,price,category,quantity,brand) values(?,?,?,?,?)";

        try {
            Connection con = establishConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getCategory());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setString(5,product.getBrand());

            boolean res = preparedStatement.execute();
            if(res){
                System.out.println("row inserted");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Product> selectAllProducts(){
        ObservableList<Product> productList = FXCollections.observableArrayList();
        final String sql = "SELECT * FROM PRODUCT ORDER BY ID";

        try {
            Connection con = establishConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                productList.add(getProducts(rs));
            }
            con.close();
            statement.close();
            rs.close();
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    private Product getProducts(ResultSet rs) {
        try {
            return new Product(
                    rs.getString("name"),
                    rs.getInt("ID"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getDate("stockedDate"),
                    rs.getInt("quantity"),
                    rs.getString("brand"));
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Connection establishConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection
                    (URL, USERNAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
