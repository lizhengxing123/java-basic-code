package com.lzx.net;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// tcp 接收端
public class TcpReceive {
    public static void main(String[] args) throws Exception {
        // 1. 创建Socket对象
        ServerSocket serverSocket = new ServerSocket(20000);
        Socket socket = serverSocket.accept();
        // 2. 接收数据
        InputStream inputStream = socket.getInputStream();
        byte[] data = new byte[1024];
        int len = inputStream.read(data);
        System.out.println(new String(data, 0, len));
        // 3. 关闭资源
        socket.close();
    }
}
