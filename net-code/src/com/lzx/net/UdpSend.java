package com.lzx.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// 使用UDP协议发送数据
public class UdpSend {
    public static void main(String[] args) throws Exception {
        // 1. 创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        // 2. 准备数据，使用scanner接收键盘输入
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要发送的内容：");
            String str = scanner.nextLine();
            // 输入886之后停止发送
            if (str.equals("886")) {
                break;
            }
            byte[] data = str.getBytes();
            // 3. 创建DatagramPacket对象
            DatagramPacket packet = new DatagramPacket(data, data.length, InetAddress.getByName("localhost"), 10000);
            // 4. 发送数据
            socket.send(packet);
        }
        // 5. 关闭资源
        socket.close();
    }
}
