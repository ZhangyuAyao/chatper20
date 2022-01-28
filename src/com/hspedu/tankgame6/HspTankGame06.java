package com.hspedu.tankgame6;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class HspTankGame06 extends JFrame {//JFrame就是面板

    //定义MyPanel
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        HspTankGame06 hspTankGame01 = new HspTankGame06();

    }

    public HspTankGame06() {
        System.out.println("请输入选择 1：新游戏 2：继续上局");
        String key = scanner.next();
        mp = new MyPanel(key);

        //启动mp的线程，让其不停地重绘
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);//把面板加入到绘图区，里面会自动调用paint方法
        this.setSize(1500, 850);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.save2Local(mp.hero, mp.enemyTanks);
            }
        });
    }
}
