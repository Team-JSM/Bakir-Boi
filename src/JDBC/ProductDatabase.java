package JDBC;

import Model.Product;

import java.sql.*;

public class ProductDatabase implements Database{

    public void insertProduct(Product product) throws SQLException {

       /* Product product = new Product(rs.getString("name"),
                rs.getString("ID"),
                rs.getDouble("price"),
                rs.getString("category"),
                rs.getDate("stockedDate"),
                rs.getInt("quantity"),
                rs.getString("brand"));*/


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


}
