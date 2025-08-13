package com.lzx.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test1 {
    public static void main(String[] args) throws UnknownHostException {
        method1();
    }

    public static void method1() throws UnknownHostException {
        System.out.println("---------------method1----------------");
        InetAddress address = InetAddress.getByName("localhost");
        System.out.println(address);
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}
