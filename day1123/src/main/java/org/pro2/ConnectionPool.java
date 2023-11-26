package org.pro2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @date 2023/11/23 16:36
 */
public class ConnectionPool {
    List<Connection> cs =new ArrayList<>();
    int size;
    public ConnectionPool(int size){
        this.size = size;
        try {
            init();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void init() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        for (int i = 0; i < size; i++) {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8","root","a12345");
            cs.add(c);
        }
    }
    public synchronized Connection getConnection(){
        while (cs.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Connection c = cs.remove(0);
        return c;
    }
    public synchronized void returnConnection(Connection c){
        cs.add(c);
        this.notifyAll();
    }
}

