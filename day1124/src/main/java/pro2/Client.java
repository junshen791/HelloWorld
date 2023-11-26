package pro2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liu
 * @date 2023/11/24 15:56
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",8888);
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos =new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            dos.writeUTF(sc.nextLine());
            System.out.println("收到服务器端消息" + dis.readUTF());
        }
    }
}
