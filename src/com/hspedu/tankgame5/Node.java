package com.hspedu.tankgame5;

/**
 * @author Zhang Yu
 * @version 1.0
 * 用于从本地文件中恢复记录的坦克坐标、方向
 */
public class Node {
    private int x;
    private int y;
    private int direct;


    public Node(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
