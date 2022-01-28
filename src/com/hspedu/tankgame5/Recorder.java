package com.hspedu.tankgame5;

import java.io.*;
import java.util.Vector;

/**
 * @author Zhang Yu
 * @version 1.0
 */
public class Recorder {
    private static int hitEnemyTankCount = 0;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static ObjectOutputStream oos = null;
    private static ObjectInputStream ois = null;
    private static String filePath = "src\\recorder.txt";

    private static Vector<Node> nodes = new Vector<>();

    public static String getFilePath() {
        return filePath;
    }

    public static int getHitEnemyTankCount() {
        return hitEnemyTankCount;
    }

    public static void addHitEnemyTankCount() {
        hitEnemyTankCount++;
    }

    public static void save2Local(Hero hero, Vector<EnemyTank> enemyTanks) {
        //保存分数
        //保存敌人坦克坐标
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(hitEnemyTankCount + "\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                String tankInfo = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirect();
                bw.write(tankInfo + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Vector<Node> getNodesAndEnemyTankRec() {
        try {
            br = new BufferedReader(new FileReader(filePath));
            hitEnemyTankCount = Integer.parseInt(br.readLine());
            String line = "";
            while((line = br.readLine()) != null ) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return nodes;
    }


}
