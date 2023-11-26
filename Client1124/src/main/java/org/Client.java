package org;

import java.net.Socket;
import java.util.Scanner;

/**
 * @author liu
 * @date 2023/11/24 19:01
 */
public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("输入聊天室ip地址：");
            String ip = new Scanner(System.in).nextLine();
            Socket socket = new Socket(ip,8888);
            new SendThread(socket).start();
            new ReceiveThread(socket).start();
        }catch (Exception e){
        }
    }
}
