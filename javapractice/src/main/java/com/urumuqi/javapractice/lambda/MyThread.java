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

        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run () {
                    System.out.println("Thread : " + getName() + " running");
                    for (int ii = 0; ii < 100; ii ++) {
                        // do nothing
                    }
                }
            }.start();
        }
        System.out.println("Java Main Thread end");
    }
}
