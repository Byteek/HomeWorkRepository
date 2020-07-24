package by.it.academy.mysql;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        String dbURL = "jbdc:mysql://localhost:3306/mydb";


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties properties = new Properties();
            properties.put("user", "root");
            properties.put("password", "root");
            properties.put("useSSL", "false");
            properties.put("serverTimezone", "UTC");

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",properties);
            System.out.println("Is connected: " + !myConnection.isClosed());

            Statement statement = myConnection.createStatement();

            String query = "select paydate, value, name from mydb.expenses, mydb.receivers where receiver=receivers.num";

            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println(
                        resultSet.getString(1) + " " +
                                resultSet.getString(2) + " " +
                                resultSet.getString(3) + " "
                );

            }
            myConnection.close();
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error loading driver: " + e);
        }finally {

            System.out.println("Finally line");
        }




    }
}
