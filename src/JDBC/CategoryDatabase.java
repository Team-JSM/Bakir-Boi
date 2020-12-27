package JDBC;

import Model.Category;
import Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CategoryDatabase implements Database{


    @Override
    public Connection establishConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
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
}
