package com.hspedu.tankgame6;

import java.util.*;

/**
 * @author Zhang Yu
 * @version 1.0
 *
 * 用于前面章节的复习
 */
public class anonymous {
    public static void main(String[] args) {
        IA tiger = new IA() {
            @Override
            public void m1() {
                System.out.println("直接使用匿名内部类搞定");
            }
        };
        tiger.m1();
        System.out.println(tiger.getClass());

        System.out.println(Color_.RED.compareTo(Color_.BLUE));
        if (true) {
            throw new AgeTrueException("fdfd");
        }
    }
}
class AgeTrueException extends RuntimeException {
    public AgeTrueException(String message) {
        super(message);
    }
}

interface IA {
    abstract public void m1();
    //Vector
    //LinkedList
    //HashSet
    //Hashtable
    //TreeSet

}

enum Color_
{
    RED, GREEN, BLUE;
}


