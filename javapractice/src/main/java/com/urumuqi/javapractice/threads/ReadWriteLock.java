package com.urumuqi.javapractice.threads;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuqi
 * @desc 1.可重复读锁; 2.写锁重入
 * @class ReadWriteLock
 * @date 2020/11/11 11:16
 **/
public class ReadWriteLock {

    private int readers = 0;
    private Map<Thread, Integer> readingThreads = new HashMap<Thread, Integer>();

    private int writeAccesses = 0;
    private int writeRequests = 0;
    private Thread writingThread = null;

    public synchronized void lockWrite() throws InterruptedException {
        writeRequests ++;
        Thread callingThread = Thread.currentThread();
        while(!canGrantWriteAccess(callingThread)) {
            wait();
        }
        writeRequests --;
        writeAccesses ++;
        writingThread = callingThread;
    }

    public synchronized void unlockWrite() {
        if (!isWriter(Thread.currentThread())) {
            throw new IllegalMonitorStateException("Calling Thread does not hold the write lock on this ReadWriteLock");
        }
        writeAccesses --;
        if (writeAccesses == 0) {
            writingThread = null;
        }
        notifyAll();;
    }

    public synchronized void lockRead() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        readers ++;
        while (!canGrantReadAccess(callingThread)) {
            wait();
        }
        readingThreads.put(callingThread, (getAccessCount(callingThread)) + 1);
    }


    public synchronized void unlockRead() {
        Thread callingThread = Thread.currentThread();
        if (!isReader(callingThread)) {
            throw new IllegalMonitorStateException("Calling Thread does not hold a read lock on this ReadWriteLock");
        }
        int accessCount = getReadAccessCount(callingThread);
        if (accessCount == 1) {
            readingThreads.remove(callingThread);
        } else {
            readingThreads.put(callingThread, (accessCount - 1));
        }
        notifyAll();
    }

    private int getReadAccessCount(Thread callingThread) {
        Integer accessCount = readingThreads.get(callingThread);
        if (accessCount == null) {
            return 0;
        }
        return accessCount.intValue();
    }

    private boolean canGrantReadAccess(Thread callingThread) {
        // 这里写锁降到读锁
        if (isWriter(callingThread)) {
            return true;
        }
        if (hasWriter()) {
            return false;
        }
        if (isReader(callingThread)) {
            return true;
        }
        return !hasWriteRequests();
    }

    private boolean hasWriteRequests() {
        return this.writeRequests > 0;
    }

    private boolean hasWriter() {
        return writingThread != null;
    }

    private boolean isReader(Thread callingThread) {
        return readingThreads.get(callingThread) != null;
    }

    private int getAccessCount(Thread callingThread) {
        Integer accessCount = readingThreads.get(callingThread);
        if (accessCount == null) {
            return 0;
        }
        return accessCount.intValue();
    }

    private boolean isWriter(Thread callingThread) {
        return writingThread == callingThread;
    }

    private boolean canGrantWriteAccess(Thread callingThread) {
        if (isOnlyReader(callingThread)) {
            return true;
        }
        if (hasReaders()) {
            return false;
        }
        if (writingThread == null) {
            return true;
        }
        return isWriter(callingThread);
    }

    private boolean isOnlyReader(Thread callingThread) {
        return readers == 1 && readingThreads.get(callingThread) != null;
    }

    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }
}
