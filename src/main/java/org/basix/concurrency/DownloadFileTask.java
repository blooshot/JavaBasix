package org.basix.concurrency;

public class DownloadFileTask implements Runnable{

    private DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        //Rage condition
        this.status = status;
    }

   /* public DownloadFileTask() {
     //confinement
        this.status = new DownloadStatus();
    }*/
    @Override
    public void run() {
        System.out.println("Downloading File: "+ Thread.currentThread().getName());
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
//        System.out.println("Downloading Complete: "+ Thread.currentThread().getName());

        for (var j =0; j<=10_000; j++){
            if(Thread.currentThread().isInterrupted()) return;
//            System.out.println("Downloaded byte: "+i);
//            status.increamentTotalBytes1();
//            status.increamentTotalBytes();
//            status.increamentAtomicTotalBytes();
            status.increamentLoadTotalBytes();
        }
        /*status.done();
        synchronized (status){
            status.notifyAll();
        }*/
        System.out.println("Downloading Complete: "+ Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }

}
