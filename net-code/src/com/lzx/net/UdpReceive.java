package com.lzx.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

// 使用UDP协议接收数据
public class UdpReceive {
    public static void main(String[] args) throws Exception {
        // 1. 创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket(10000);
        // 2. 准备数据
        byte[] data = new byte[1024];
        // 3. 创建DatagramPacket对象
        DatagramPacket packet = new DatagramPacket(data, data.length);
        // 4. 接收数据
        while (true) {
            socket.receive(packet);
            // 打印信息
            System.out.println("------------------");
            System.out.println("数据长度：" + packet.getLength());
            System.out.println("数据内容：" + new String(data, 0, packet.getLength()));
            System.out.println("数据来源：" + packet.getAddress().getHostName());
            // 结束
            if (new String(data, 0, packet.getLength()).equals("886")) {
                break;
            }
            System.out.println("------------------");
        }
        // 5. 关闭资源
        socket.close();
    }
}
