package com.lzx.net;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

// tcp 发送端
public class TcpSend {
    public static void main(String[] args) throws Exception {
        // 1. 创建Socket对象
        Socket socket = new Socket("localhost", 20000);
        // 2. 准备数据
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的内容：");
        String str = scanner.nextLine();
        byte[] data = str.getBytes();
        // 3. 发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(data);
        // 4. 关闭资源
        socket.close();
    }
}
