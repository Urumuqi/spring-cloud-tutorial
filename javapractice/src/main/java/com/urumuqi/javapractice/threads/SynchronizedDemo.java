package com.urumuqi.javapractice.threads;

/**
 * @author wuqi
 * @desc todo
 * @class SynchronizedDemo
 * @date 2020/11/3 14:07
 **/
public class SynchronizedDemo {

    public static void main(String[] args) {

        Counter counter = new Counter();

        // 两个线程 调用同一个 对象实例的同步块
        // 两个线程 在调用同一个对象实例的同步块时，会串行执行
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        // thread start
        threadA.start();
        threadB.start();

        // 两个线程 调用不同对象实例 的 同步块
        // 不同的线程 调用不同对象 的 同步块，不会导致串行执行
        // Thread threadA1 = new CounterThread(new Counter());
        // Thread threadB1 = new CounterThread(new Counter());
        //
        // threadA1.start();
        // threadB1.start();
    }
}

/**
 * Synchronized Counter.
 */
class Counter {
    long count = 0;

    public synchronized void add(long value) {
        this.count += value;
    }
}

class CounterThread extends Thread {
    protected Counter counter = null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        // super.run();
        for (int i = 0; i < 10; i++) {
            counter.add(i);
            System.out.println("Current Thread Name : " + getName() + " counter = " + i);
        }
    }
}
