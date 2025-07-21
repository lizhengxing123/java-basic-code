package com.lzx.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 游戏主界面
public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 图片大小
    final int IMAGE_SIZE = 105;
    // 图片偏移量
    final int IMAGE_OFFSET_X = 83;
    final int IMAGE_OFFSET_Y = 134;
    // 图片地址
    String imagePath = "puzzlegame\\image\\animal\\animal3\\";
    // 二维数据
    final int[][] imageArray = new int[4][4];
    // 正确的二维数组 1-16
    final int[][] correctArray = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    // 0：空白所在的位置
    int blankX = 0;
    int blankY = 0;

    // 胜利标识
    boolean winFlag = false;

    // 步数
    int step = 0;

    // 菜单项：重新游戏、重新登录、退出游戏、公众号、美女、运动、动物
    JMenuItem reGameItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem exitGameItem = new JMenuItem("退出游戏");

    JMenuItem publicItem = new JMenuItem("公众号");

    JMenuItem beautyItem = new JMenuItem("美女");
    JMenuItem sportItem = new JMenuItem("运动");
    JMenuItem animalItem = new JMenuItem("动物");

    public GameJFrame() {
        // 初始化界面
        initJFrame();
        // 初始化菜单
        initJMenuBar();
        // 初始化数据
        initData();
        // 初始化图片
        initImage();
        // 设置显隐
        this.setVisible(true);
    }

    private void initData() {
        // 生成 0-15 一维数组
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        // 随机打乱数组
        for (int i = 0; i < arr.length; i++) {
            // 随机获取数组下标
            int random = (int) (Math.random() * arr.length);
            // 交换元素
            int temp = arr[i];
            arr[i] = arr[random];
            arr[random] = temp;
        }
        // 一维数组赋值给二维数组
        for (int i = 0; i < arr.length; i++) {
            int x = i / 4;
            int y = i % 4;
            imageArray[x][y] = arr[i];
            if (imageArray[x][y] == 0) {
                blankX = x;
                blankY = y;
            }
        }
    }

    private void initImage() {
        // 移除所有图片
        this.getContentPane().removeAll();

        if (isWin()) {
            setWinImage();
        }

        setStepText();

        for (int i = 0; i < 4; i++) { // 行
            for (int j = 0; j < 4; j++) { // 列
                // 添加图片
                ImageIcon imageIcon = new ImageIcon(imagePath + imageArray[i][j] + ".jpg");
                // 图片标签
                JLabel imageLabel = new JLabel(imageIcon);
                // 设置边框
                imageLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                // 设置位置和大小
                imageLabel.setBounds(j * IMAGE_SIZE + IMAGE_OFFSET_X, i * IMAGE_SIZE + IMAGE_OFFSET_Y, IMAGE_SIZE, IMAGE_SIZE);
                // 图片标签加入到隐藏容器中
                this.getContentPane().add(imageLabel);
            }
        }

        setBgImage();

        // 刷新界面
        this.getContentPane().repaint();
    }

    private void setWinImage() {
        // 设置胜利图片
        ImageIcon imageIcon = new ImageIcon("puzzlegame\\image\\win.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(203, 283, 197, 73);
        this.getContentPane().add(imageLabel);
    }

    private void setBgImage() {
        // 设置背景图片，先加载的图片在上面
        ImageIcon imageIcon = new ImageIcon("puzzlegame\\image\\background.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(40, 40, 508, 560);
        this.getContentPane().add(imageLabel);
    }

    private void setStepText() {
        // 设置步数
        JLabel stepLabel = new JLabel("步数：" + step);
        stepLabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepLabel);
    }

    // 判断是否胜利
    private boolean isWin() {
        for (int i = 0; i < imageArray.length; i++) {
            for (int j = 0; j < imageArray[i].length; j++) {
                if (imageArray[i][j] != correctArray[i][j]) {
                    return winFlag = false;
                }
            }
        }
        return winFlag = true;
    }

    private void initJMenuBar() {
        // 菜单栏
        JMenuBar menuBar = new JMenuBar();

        // 菜单：功能、关于我们
        JMenu funcMenu = new JMenu("功能");
        JMenu aboutMenu = new JMenu("关于我们");

        // 菜单项：重新游戏、重新登录、退出游戏、公众号
        // JMenuItem reGameItem = new JMenuItem("重新游戏");
        // JMenuItem reLoginItem = new JMenuItem("重新登录");
        // JMenuItem exitGameItem = new JMenuItem("退出游戏");

        // JMenuItem publicItem = new JMenuItem("公众号");

        // 菜单：更换图片
        JMenu changeMenu = new JMenu("更换图片");
        changeMenu.add(beautyItem);
        changeMenu.add(sportItem);
        changeMenu.add(animalItem);


        // 菜单项加入到菜单
        funcMenu.add(changeMenu);
        funcMenu.add(reGameItem);
        funcMenu.add(reLoginItem);
        funcMenu.add(exitGameItem);

        aboutMenu.add(publicItem);

        // 为菜单项绑定事件
        reGameItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        exitGameItem.addActionListener(this);
        publicItem.addActionListener(this);
        beautyItem.addActionListener(this);
        sportItem.addActionListener(this);
        animalItem.addActionListener(this);

        // 菜单加入到菜单栏
        menuBar.add(funcMenu);
        menuBar.add(aboutMenu);

        // 菜单栏加入到游戏主界面
        this.setJMenuBar(menuBar);
    }

    private void initJFrame() {
        // 设置宽高
        this.setSize(603, 680);
        // 设置标题
        this.setTitle("拼图单机版");
        // 设置置顶
        this.setAlwaysOnTop(true);
        // 设置居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 取消默认的居中布局
        this.setLayout(null);
        // 注册键盘事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 游戏胜利，不能在进行按键
        if (winFlag) {
            return;
        }

        // 获取键盘按键
        int key = e.getKeyCode();
        // 按下 A：65 的时候，查看完整图片
        if (key == 65) {
            showAllImage();
        }
    }

    private void showAllImage() {
        // 按下 A 的时候，查看完整图片
        this.getContentPane().removeAll();
        // 加载完整图片
        ImageIcon all = new ImageIcon(imagePath + "all.jpg");
        // 图片标签
        JLabel imageLabel = new JLabel(all);
        // 设置位置和大小
        imageLabel.setBounds(IMAGE_OFFSET_X, IMAGE_OFFSET_Y, IMAGE_SIZE * 4, IMAGE_SIZE * 4);
        // 图片标签加入到隐藏容器中
        this.getContentPane().add(imageLabel);
        // 设置背景图片
        setBgImage();
        // 刷新界面
        this.getContentPane().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 游戏胜利，不能在进行按键
        if (winFlag) {
            return;
        }

        // 获取键盘按键
        int keyCode = e.getKeyCode();
        // 上：38 下：40 左：37 右：39 A：65 W：87
        switch (keyCode) {
            case 37 -> moveLeft();
            case 38 -> moveUp();
            case 39 -> moveRight();
            case 40 -> moveDown();
            case 65 -> initImage();
            case 87 -> victory();
        }
    }

    private void victory() {
        // 按 w 一键通关
        // 遍历 correctArray 数组
        for (int i = 0; i < correctArray.length; i++) {
            for (int j = 0; j < correctArray[i].length; j++) {
                imageArray[i][j] = correctArray[i][j];
            }
        }
        // 刷新图片
        initImage();
    }

    private void moveLeft() {
        // 空白在最右边，无法向左移动
        if (blankY == 3) {
            return;
        }
        // 向左移动
        imageArray[blankX][blankY] = imageArray[blankX][blankY + 1];
        imageArray[blankX][blankY + 1] = 0;
        blankY++;
        step++;

        // 刷新图片
        initImage();
    }

    private void moveRight() {
        // 空白在最左边，无法向右移动
        if (blankY == 0) {
            return;
        }
        // 向右移动
        imageArray[blankX][blankY] = imageArray[blankX][blankY - 1];
        imageArray[blankX][blankY - 1] = 0;
        blankY--;
        step++;

        // 刷新图片
        initImage();
    }

    private void moveDown() {
        // 空白在最上边，无法向下移动
        if (blankX == 0) {
            return;
        }
        // 向下移动
        imageArray[blankX][blankY] = imageArray[blankX - 1][blankY];
        imageArray[blankX - 1][blankY] = 0;
        blankX--;
        step++;

        // 刷新图片
        initImage();
    }

    private void moveUp() {
        // 空白在最下边，无法向上移动
        if (blankX == 3) {
            return;
        }
        // 向上移动
        imageArray[blankX][blankY] = imageArray[blankX + 1][blankY];
        imageArray[blankX + 1][blankY] = 0;
        blankX++;
        step++;

        // 刷新图片
        initImage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == reGameItem) {
            // 重新游戏
            reGame();
        } else if (source == reLoginItem) {
            // 重新登录
            this.setVisible(false);
            new LoginJFrame();
        } else if (source == exitGameItem) {
            // 退出游戏
            System.exit(0);
        } else if (source == publicItem) {
            // 公众号弹框展示
            publicAccount();
        } else if (source == beautyItem) {
            // 美女图片展示
            showBeautyImage();
        } else if (source == animalItem) {
            // 动物图片展示
            showAnimalImage();
        } else if (source == sportItem) {
            // 运动图片展示
            showSportImage();
        }
    }

    private void reGame() {
        step = 0;
        initData();
        initImage();
    }

    private void showSportImage() {
        // 更改路径 并生成1-10随机数
        int random = (int) (Math.random() * 10 + 1);
        imagePath = "puzzlegame\\image\\sport\\sport" + random + "\\";
        reGame();
    }

    private void showAnimalImage() {
        // 更改路径 并生成1-8随机数
        int random = (int) (Math.random() * 8 + 1);
        imagePath = "puzzlegame\\image\\animal\\animal" + random + "\\";
        reGame();
    }

    private void showBeautyImage() {
        // 更改路径 并生成1-13随机数
        int random = (int) (Math.random() * 13 + 1);
        imagePath = "puzzlegame\\image\\girl\\girl" + random + "\\";
        reGame();
    }

    // 公众号逻辑
    private void publicAccount() {
        // 弹框
        JDialog dialog = new JDialog();
        JLabel label = new JLabel(new ImageIcon("puzzlegame\\image\\about.png"));
        label.setBounds(0, 0, 258, 258);
        dialog.getContentPane().add(label);
        dialog.setSize(344, 344);
        dialog.setAlwaysOnTop(true); // 置顶
        dialog.setLocationRelativeTo(null); // 居中
        dialog.setModal(true); // 弹框不关闭，无法操作下面的界面
        dialog.setVisible(true);
    }
}
