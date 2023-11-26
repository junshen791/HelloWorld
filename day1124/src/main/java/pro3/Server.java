package pro3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author liu
 * @date 2023/11/24 16:43
 */
public class Server {
    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听端口号8888");
        Socket s= ss.accept();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos =new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("收到客户端消息");
            System.out.println("正在处理");
            TaobaoDAOlimp taobaoDAOlimp = new TaobaoDAOlimp();
            System.out.println(taobaoDAOlimp.list(dis.readUTF()));
        }
    }
}
