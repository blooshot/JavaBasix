package org.basix.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    Lock lock = new ReentrantLock();
    private volatile boolean isDone;
    public  boolean isDone() {
        return isDone;
    }
    public  void done() {
        isDone = true;
    }

    private AtomicInteger atomicTotalBytes = new AtomicInteger();
    public int getAtomicTotalBytes() {
        return atomicTotalBytes.get();
    }
    public void increamentAtomicTotalBytes(){
        atomicTotalBytes.incrementAndGet();
    }

    private LongAdder loadTotalBytes = new LongAdder();
    public int getLoadTotalBytes() { return loadTotalBytes.intValue(); }
    public void increamentLoadTotalBytes() { loadTotalBytes.increment(); }

    public int getTotalBytes() {
        return totalBytes;
    }
    public void increamentTotalBytes(){
        /*lock.lock();
        try {
            totalBytes++;
        }
        finally {
            lock.unlock();
        }*/

        // increamentTotalBytes1 is same as below
        // ye approach bhasad felati hai, do synchronized method ek class k, ek sath nhi chalenge, isliye inme "this" ki jagah koi new object pass kr do
       /* synchronized (this){
            totalBytes++;
        }*/
    }

    public synchronized void increamentTotalBytes1(){
        totalBytes++;
    }

}
