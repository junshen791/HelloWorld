package pro2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author liu
 * @date 2023/11/24 15:38
 */
public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket s= new Socket("127.0.0.1",8888);
        OutputStream os = s.getOutputStream();
        DataOutputStream dos =new DataOutputStream(os);
        dos.writeUTF("朱燕南是常州人");
        s.close();
    }
}
