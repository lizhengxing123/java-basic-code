package com.lzx.extendsDemo;

public class Test {
    public static void main(String[] args) {
        // 1、狸花猫
        // createLiHua();

        // 2、布偶猫
        // createRagdoll();

        // 3、哈士奇
        // createHusky();

        // 4、泰迪
        // createTeddy();

        test4();
    }

    private static void createTeddy() {
        System.out.println("泰迪：");
        Teddy teddy = new Teddy();
        teddy.eat();
        teddy.drink();
        teddy.watchHouse();
        teddy.touch();
        System.out.println("-----------------------");
    }

    private static void createHusky() {
        System.out.println("哈士奇：");
        Husky husky = new Husky();
        husky.eat();
        husky.drink();
        husky.watchHouse();
        husky.breakHome();
        System.out.println("-----------------------");
    }

    private static void createRagdoll() {
        System.out.println("布偶猫：");
        Ragdoll ragdoll = new Ragdoll();
        ragdoll.eat();
        ragdoll.drink();
        ragdoll.catchMouse();
        System.out.println("-----------------------");
    }

    private static void createLiHua() {
        System.out.println("狸花猫：");
        LiHua liHua = new LiHua("lihua", 1);
        System.out.println(liHua);
        liHua.eat();
        liHua.drink();
        liHua.catchMouse();
        liHua.mi();
        System.out.println("-----------------------");
    }

    // 多态
    private static void test() {
        Husky husky = new Husky();
        Teddy teddy = new Teddy();

        test2(husky);
        test2(teddy);
    }

    private static void test2(Dog d) {
        d.shout();
    }

    private static void test3() {
        Dog d = new Husky();

        // 成员变量：编译和运行都看左边
        // 因为是 Dog 调用的
        System.out.println(d.name); // 狗

        // 成员方法：编译看左边，运行看右边
        // 因为 Dog 的虚方法被重写了
        d.shout(); // 汪汪汪

        // 非虚方法，如静态方法，调用时还是根据左边来的
        d.play(); // dog play
    }

    private static void test4() {
        Dog husky = new Husky();
        Dog teddy = new Teddy();

        // 多态的弊端，不能访问右边自己的方法
        // husky.breakHome(); // 报错

        // 解决方法：转换为自己的类型
        // Husky h = (Husky) husky;
        // h.breakHome();

        // 根据 instanceof 进行判断
        /*if (husky instanceof Husky) {
            Husky h = (Husky) husky;
            h.breakHome();
        } else if (husky instanceof Teddy) {
            Teddy t = (Teddy) husky;
            t.touch();
        } else {
            System.out.println("没有这个类型");
        }*/
        // 新写法
        if (husky instanceof Husky h) {
            h.breakHome();
        } else if (husky instanceof Teddy t) {
            t.touch();
        } else {
            System.out.println("没有这个类型");
        }
    }
}
