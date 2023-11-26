package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author liu
 * @date 2023/11/17 9:19
 */
public class DBUtil {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "a12345";
    private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "a12345");
    }
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException var1) {
            var1.printStackTrace();
        }

    }
}
