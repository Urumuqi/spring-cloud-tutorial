package com.urumuqi.javapractice.threads;

/**
 * @author wuqi
 * @desc todo
 * @class AsynchronizedConn
 * @date 2020/11/3 15:00
 **/
public class AsynchronizedConn {
}

/**
 * MySignal class.
 * shared signal between threads.
 *
 * 线程通信 - 共享对象
 */
class MySignal {
    protected boolean hasDataToProcess = false;

    public synchronized boolean isHasDataToProcess() {
        return this.hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasData) {
        this.hasDataToProcess = hasData;
    }
}

class MonitorObject {
    //
}

/**
 * 为了避免信号丢失，用一个变量来保存是否被通知过。在notify前，设置自己已经被通知过；在wait后，设置自己没有被通知过，需要等待通知.
 */
class MyWaitNotify {

    MonitorObject myMonitorObj = new MonitorObject();

    boolean wasSignalled = false;

    public void doWait() {
        synchronized (myMonitorObj) {
            if (!wasSignalled) {
                try {
                    myMonitorObj.wait();
                } catch (InterruptedException e) {
                    // do something
                }
            }
            wasSignalled = false;
        }
    }

    public void doNotify() {
        synchronized (myMonitorObj) {
            wasSignalled = true;
            myMonitorObj.notify();
        }
    }
}
