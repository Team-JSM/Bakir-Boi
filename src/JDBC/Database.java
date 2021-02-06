package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Database {

/*    public Connection databaseLink = null;

    public static Connection getDatabaseLink() {
        String databaseName = "jisan";
        String databaseUser = "root";
        String databasePassword = "122897";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
            //databaseLink= DriverManager.getConnection(url,databaseUser,databasePassword);
            System.out.println("bal");
            return databaseLink;

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            System.out.println(e);
        }
        return databaseLink;

    }*/


    String databaseName = "jisan";
    String USERNAME = "root";
    String PASSWORD = "122897";
    String URL = "jdbc:mysql://localhost:3306/" + databaseName;
    String DRIVER = "com.mysql.cj.jdbc.Driver";


    Connection establishConnection() throws SQLException;

}
