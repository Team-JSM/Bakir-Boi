package JDBC;

import java.sql.Connection;
import java.sql.SQLException;

public interface Database {
    String USERNAME = "c##kaid";
    String PASSWORD = "kaidmain";
    String URL = "jdbc:oracle:thin:@localhost:1521/XE";
    String DRIVER = "oracle.jdbc.driver.OracleDriver";

    Connection establishConnection() throws SQLException;
}
