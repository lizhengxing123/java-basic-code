package com.lzx.myreflect;

import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Computer getProxyInstance(Macbook macbook) {
        return (Computer) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Computer.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("start")) {
                        System.out.println("start方法被调用了");
                    } else if (method.getName().equals("shutdown")) {
                        System.out.println("shutdown方法被调用了");
                    }
                    return method.invoke(macbook, args);
                });
    }
}
