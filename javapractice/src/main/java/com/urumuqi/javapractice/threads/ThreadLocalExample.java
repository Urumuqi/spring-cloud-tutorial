package com.urumuqi.javapractice.threads;

/**
 * @author wuqi
 * @desc todo
 * @class ThreadLocalExample
 * @date 2020/11/3 16:29
 **/
public class ThreadLocalExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // do nothing
            }

            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInst = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInst);
        Thread thread2 = new Thread(sharedRunnableInst);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
