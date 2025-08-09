package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String jdbcURL = "jdbc:mysql://localhost:3306/student_db";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
