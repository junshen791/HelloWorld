package pro2;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/** Socket 编程
 * Socket 代表客户端
 * ServerSocket 代表服务器端
 * ip地址 端口
 * @author liu
 * @date 2023/11/24 15:32
 */
public class TestServer {
    public static void main(String[] args)throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("正在监听端口号8888");
        Socket s= ss.accept();
        System.out.println("有客户接入"+s);
        s.close();
        ss.close();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        System.out.println(dis.readUTF());
    }

}
