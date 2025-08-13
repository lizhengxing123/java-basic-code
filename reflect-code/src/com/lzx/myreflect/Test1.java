package com.lzx.myreflect;

import java.lang.reflect.*;

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获取 class 对象
        // 方式1：类名.class
        /*Class<Macbook> macbookClass = Macbook.class;
        System.out.println(macbookClass);
        // 方式2：对象.getClass()
        Macbook macbook = new Macbook();
        Class<? extends Macbook> macbookClass1 = macbook.getClass();
        System.out.println(macbookClass1);*/
        // 方式3：Class.forName("全类名")
        Class<?> macbookClass2 = Class.forName("com.lzx.myreflect.Macbook");

        // method1(macbookClass2);
        // method2(macbookClass2);
        // method3(macbookClass2);
        method4();
    }

    private static void method4() {
        // 创建对象
        Macbook mac = new Macbook("macbook pro", 1000);
        System.out.println(mac);
        // 创建代理对象
        Computer proxyInstance = ProxyUtil.getProxyInstance(mac);
        proxyInstance.start();
        proxyInstance.shutdown();
    }

    private static void method3(Class<?> macbookClass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 获取所有方法
        Method[] methods = macbookClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 获取单个方法
        Method getName = macbookClass.getDeclaredMethod("getName");
        System.out.println(getName);
        // 权限修饰符
        int modifiers = getName.getModifiers();
        System.out.println(modifiers);
        // 权限修饰符对应的字符串
        System.out.println(Modifier.toString(modifiers));
        // 返回值类型
        System.out.println("返回值类型：" + getName.getReturnType());
        // 参数列表
        System.out.println("参数列表：" + getName.getParameterTypes());
        // 异常列表
        System.out.println("异常列表：" + getName.getExceptionTypes());
        // 调用
        // 1. 创建对象
        Object macbook = macbookClass.newInstance();
        // 2. 调用方法
        // 2.1 暴力反射
        getName.setAccessible(true);
        // 2.2 调用方法
        Object result = getName.invoke(macbook);
        System.out.println(result);
        // 3. 调用有参数的方法
        Method setName = macbookClass.getDeclaredMethod("setName", String.class);
        setName.invoke(macbook, "macbook pro");
        System.out.println(macbook);
    }

    private static void method2(Class<?> macbookClass) throws NoSuchFieldException, IllegalAccessException {
        // 获取所有字段
        Field[] fields = macbookClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
            // 权限修饰符
            int modifiers = field.getModifiers();
            System.out.println(modifiers);
            // 权限修饰符对应的字符串
            System.out.println(Modifier.toString(modifiers));
        }
        // 获取单个
        Field nameField = macbookClass.getDeclaredField("name");
        System.out.println(nameField);
        // 权限修饰符
        int modifiers = nameField.getModifiers();
        System.out.println(modifiers);
        // 权限修饰符对应的字符串
        System.out.println(Modifier.toString(modifiers));
        // 类型
        System.out.println("类型：" + nameField.getType());
        // 名称
        System.out.println("名称：" + nameField.getName());
        // 获取值
        Macbook macbook = new Macbook("macbook", 1000);
        // 暴力反射
        nameField.setAccessible(true);
        // 获取值
        Object value = nameField.get(macbook);
        System.out.println("值：" + value);
        // 设置值
        nameField.set(macbook, "macbook pro");
        System.out.println(macbook);
    }

    private static void method1(Class<?> macbookClass) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 获取所有构造方法
        Constructor<?>[] constructors = macbookClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        // 获取单个构造方法
        Constructor<?> constructor = macbookClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor);
        // 权限修饰符
        int modifiers = constructor.getModifiers();
        System.out.println(modifiers);
        // 权限修饰符对应的字符串
        System.out.println(Modifier.toString(modifiers));
        // 参数列表
        Parameter[] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println("参数类型：" + parameter.getType());
            System.out.println("参数名称：" + parameter.getName());
        }

        // 暴力反射
        constructor.setAccessible(true);
        // 创建对象
        Macbook macbook = (Macbook) constructor.newInstance("macbook", 1000);
        System.out.println(macbook);
    }
}
