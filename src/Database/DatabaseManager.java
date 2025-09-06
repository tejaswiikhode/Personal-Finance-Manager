package Database;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/pfmsdemo";
    private static final String USER = "root";  
    private static final String PASSWORD = "07nilesh_2006";  

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            if (connection == null) {
                System.out.println("Error: No database connection.");
                return null;
            }
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
