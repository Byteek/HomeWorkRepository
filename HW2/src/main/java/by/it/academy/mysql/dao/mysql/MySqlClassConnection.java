package by.it.academy.mysql.dao.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySqlClassConnection {
    static String url = "jdbc:mysql://localhost:3306/mydb";
    static Properties properties = new Properties();


    static {
        properties.put("user", "root");
        properties.put("password", "root");
        properties.put("useSSL", "false");
        properties.put("serverTimezone", "UTC");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Connection connection;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                url,
                properties);
    }

    private static String testUrl = "jdbc:mysql://localhost:3306/mydb_test";

    public static Connection getTestConnection() throws SQLException {
        return DriverManager.getConnection(
                testUrl,
                properties);
    }
}
