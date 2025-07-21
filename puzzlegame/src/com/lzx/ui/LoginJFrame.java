package com.lzx.ui;

import javax.swing.*;

// 登录界面
public class LoginJFrame extends JFrame {

    public LoginJFrame() {
        // 设置宽高
        this.setSize(488, 430);
        // 设置标题
        this.setTitle("拼图 登录");
        // 设置置顶
        this.setAlwaysOnTop(true);
        // 设置居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置显隐
        this.setVisible(true);
    }
}
