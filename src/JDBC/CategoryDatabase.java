package JDBC;

import Model.Category;
import Model.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDatabase implements Database{


    @Override
    public Connection establishConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection
                    (URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ObservableList<Category> selectAllCategory(){
        ObservableList<Category> categoryList = FXCollections.observableArrayList();
        final String sql = "SELECT * FROM CATEGORY";

        try {
            Connection con = establishConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                categoryList.add(getCategory(rs));
            }
            con.close();
            statement.close();
            rs.close();
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Category getCategory(ResultSet rs) {
        try {
            return new Category(
                    rs.getString("name"),
                    rs.getString("description"));
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insertCategory(Category category) {
        String sql = "INSERT INTO CATEGORY(name,description) values(?,?)";

        try {
            Connection con = establishConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getDescription());
            boolean res = preparedStatement.execute();
            if(res){
                System.out.println("row inserted");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategoryByName(String field,Object newValue,String name){
        String sql = "UPDATE category " +
                "SET "+ field + " = '" + newValue +
                "' WHERE name = '" + name + "'";

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

    public void deleteCategoryByName(String name){
        String sql = "DELETE FROM category " +
                     "WHERE name = '" + name + "'";

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

    public List<String> selectAllCategoryByName() {
        List<String> categoryList = new ArrayList<>();
        final String sql = "SELECT name FROM CATEGORY";

        try {
            Connection con = establishConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                categoryList.add(rs.getString("name"));
            }
            con.close();
            statement.close();
            rs.close();
            return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
