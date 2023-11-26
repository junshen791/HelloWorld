package org.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author liu
 * @date 2023/11/24 18:20
 */
public class Server {
    public volatile static ArrayList<Socket> list = new ArrayList<Socket>();
    public static void main(String[] args) {
        //创建服务器端 指定监听端口
        try {
            ServerSocket ss = new ServerSocket(8888);
            //服务器端需要不断接收来自客户端的请求
            //并且将客户端发来发请求
            //socket对象存放在list容器中
            while (true){
                Socket socket = ss.accept();
                list.add(socket);
                System.out.println("成功连接，连接数:"+list.size());
                new ServerThread(socket,list).start();
            }
        } catch (IOException e) {

        }

    }
}
