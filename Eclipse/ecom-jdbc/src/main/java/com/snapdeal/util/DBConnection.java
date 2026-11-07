/*
 * package com.snapdeal.util;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.SQLException;
 * 
 * public class DBConnection {
 * 
 * private static Connection connection;
 * 
 * private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_db";
 * 
 * private static final String USERNAME = "daksh";
 * 
 * private static final String PASSWORD = "Daksh@7764";
 * 
 * private DBConnection() { }
 * 
 * 
 * public static Connection getConnection() {
 * 
 * try {
 * 
 * if (connection == null || connection.isClosed()) {
 * 
 * connection = DriverManager.getConnection( URL, USERNAME, PASSWORD); }
 * 
 * } catch (SQLException ex) { ex.printStackTrace(); }
 * 
 * return connection; }
 * 
 * 
 * public static Connection getConnection() throws SQLException { return
 * DriverManager.getConnection(URL, USERNAME, PASSWORD); } }
 */


package com.snapdeal.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private DBConnection() {
    }

    public static Connection getConnection() {

        try {

            Class.forName(
                    DBConfig.getProperty(
                            "db.driver"));

            return DriverManager.getConnection(
                    DBConfig.getProperty(
                            "db.url"),

                    DBConfig.getProperty(
                            "db.username"),

                    DBConfig.getProperty(
                            "db.password"));

        } catch(Exception e) {

            throw new RuntimeException(
                    "Database Connection Failed",
                    e);
        }
    }
}