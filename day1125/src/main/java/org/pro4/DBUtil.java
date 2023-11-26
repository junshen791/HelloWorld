package org.pro4;

import org.Test2.Product;

import javax.print.attribute.standard.JobOriginatingUserName;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author liu
 * @date 2023/11/25 11:22
 */
public class DBUtil {
    private static DataSource dataSource;
    static {

        try {
            //读取配置文件
            Properties properties = new Properties();
            properties.load(new FileInputStream("E:\\idea_work\\homework11-16\\day1125\\src\\main\\java\\org\\pro4\\DataSource.java"));
            //利用反射完成datasource类的实例化
            Class dClass = DataSource.class;
            Constructor<DataSource> c1 = dClass.getConstructor();
            dataSource = c1.newInstance();
            Method m =dClass.getMethod("setConn",Connection.class);
            Connection c = DriverManager.getConnection((String) properties.getProperty("url"),(String) properties.getProperty("username"), (String) properties.getProperty("password"));
            m.invoke(dataSource,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public DataSource getDataSource(){
        return dataSource;
    }

}
