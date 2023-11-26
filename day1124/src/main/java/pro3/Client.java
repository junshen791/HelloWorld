package pro3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liu
 * @date 2023/11/24 16:44
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
        }
    }
}
