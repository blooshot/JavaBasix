package org.basix.concurrency;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadDemo {
    public static void show(){
        System.out.println(Thread.currentThread().getName());
       /* for (var i =0; i<=10; i++){
            Thread thread = new Thread(new Download());
            thread.start();
        }*/
       /* Thread thread = new Thread(new Download());
        thread.start();*/
       /*try {
//            thread.join();
           thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Now i can scan file");

        thread.interrupt();*/


    }
    public static void race_condition(){
        var Status = new DownloadStatus();
        List<Thread> tl = new ArrayList();
        for (var i =0; i<10; i++){
            var thread = new Thread(new DownloadFileTask(Status));
            thread.start();
            tl.add(thread);
        }

        for (var thr : tl){
            try {
                thr.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


//        System.out.println(Status.getTotalBytes());
//        System.out.println(Status.getAtomicTotalBytes());
        System.out.println(Status.getLoadTotalBytes());
    }

    public static void syncedCollectionRace(){

        /*Map<Integer,String> mapu = new ConcurrentHashMap<>();
        mapu.put(1,"a");
        mapu.get(1);
        mapu.remove(1);*/


        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(()->{
            collection.addAll(Arrays.asList(1,2,3,0));
        });

        var thread2 = new Thread(()->{
            collection.addAll(Arrays.asList(5,7,8,9));
        });

        thread1.start();
        thread2.start();


        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(collection);
    }

/*    public static void showVolatile(){
        var Status = new DownloadStatus();

         var thread1 = new Thread(new DownloadFileTask(Status));
         var thread2 = new Thread(()->{
             while (!Status.isDone()){
                 System.out.println("im wait for while");

                //without sync block threads issue krte,
                 synchronized (Status){
                     try {
                         Status.wait();
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                 }
             }
             System.out.println(Status.getTotalBytes());
         });

         thread1.start();
         thread2.start();
    }*/

   /* public static void confinement_strategy(){
        List<Thread> threads = new ArrayList();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (var i =0; i<10; i++){
           var task = new DownloadFileTask();
           tasks.add(task);
            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        var totalbyte = tasks.stream()
                .map(t-> t.getStatus().getTotalBytes())
                        .reduce(Integer::sum);

        System.out.println(totalbyte);
    }*/
}
