package org.pro5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author liu
 * @date 2023/11/25 14:16
 */
@SuppressWarnings("all")
@JDBCConfig(url="jdbc:mysql://localhost:3306/test?charactorEncoding=utf8",username ="root",password = "a12345")
public class DBUtil {
    static {
        try {
            Class.forName("org.pro5.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        String url = config.url();
        String username = config.username();
        String password = config.password();
        return DriverManager.getConnection(url,username,password);
    }

}
