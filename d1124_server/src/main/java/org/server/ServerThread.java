package org.server;
import com.sun.deploy.net.proxy.ProxyUnavailableException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
/**服务器端开启的线程 给客户端通信提供服务的
 * @author liu
 * @date 2023/11/24 18:29
 */
public class ServerThread extends Thread {
    Socket socket;
    ArrayList<Socket> list;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    public ServerThread(Socket socket, ArrayList<Socket> list) {
        this.socket = socket;
        this.list = list;
    }
    @Override
    public void run(){
        try {
            while (true){
                is=socket.getInputStream();
                dis=new DataInputStream(is);
                String str = dis.readUTF();
                System.out.println(socket.getInetAddress()+":"+str);
                Iterator<Socket> it=list.iterator();
                while (it.hasNext()){
                    //去除当前遍历的socket
                    Socket st = it.next();
                    if (st.isConnected()){
                        //如果处于连接状态 则借助输出流写入信息
                        os = st.getOutputStream();
                        dos = new DataOutputStream(os);
                        dos.writeUTF(this.socket.getInetAddress()+":"+str);
                    }else {
                        //如果遍历的socket不可用 应该从list集合中移除
                        synchronized (list){
                            it.remove();
                            System.out.println(st.getInetAddress()+"已经退出聊天室,当前人数："+list.size());
                            dos.writeUTF(st.getInetAddress()+"已经退出聊天室,当前人数："+list.size());
                        }
                    }
                }
            }
        }catch (Exception e){
        }finally {
            //如果连接当前连接的客户端出现其他问题，也该退出聊天室
            try {
                synchronized (list){
                    socket.close();
                    list.remove(socket);
                    dos.writeUTF(socket.getInetAddress()+"已经退出聊天室,当前人数："+list.size());
                }
            }catch (Exception e){
            }
        }
    }
}