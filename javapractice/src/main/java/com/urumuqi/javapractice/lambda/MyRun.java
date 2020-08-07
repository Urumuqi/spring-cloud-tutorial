package com.urumuqi.javapractice.lambda;

/**
 * @author wuqi
 * @desc todo
 * @class MyRun
 * @date 2020/8/6 17:10
 **/
public class MyRun {

    // lambda 表达式会生成类的私有方法，表达式内this表示当前类；这点区别与匿名类

    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());
    public static void main(String[] args) {
        new MyRun().r1.run();
        new MyRun().r2.run();
    }

    @Override
    public String toString() {
        return "hello lambda";
    }
}
