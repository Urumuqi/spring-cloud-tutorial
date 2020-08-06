package com.urumuqi.javapractice.lambda;

/**
 * @author wuqi
 * @desc todo
 * @class MyThread
 * @date 2020/8/4 10:40
 **/
public class MyThread {

    public static void main(String[] args) {
        System.out.println("Java Rocks!!");
        new Thread(() -> System.out.println("In Java 8, Lambda express rocks!!")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In Java 8, Normal Thread run");
            }
        }).start();
        System.out.println("Java Main Thread end");
    }
}
