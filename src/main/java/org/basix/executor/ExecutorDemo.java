package org.basix.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class ExecutorDemo {

    public static void completeableFutureShow(){
        // just chala kr chhodna hai to, runnable use hoga
        Runnable task = () -> System.out.println("Ae sala main chala: "+Thread.currentThread().getName());
        // completable class forkJoinPool use krti hai under the hood, agr apan pool na de to
        var future = CompletableFuture.runAsync(task);

        // Callable or supplier use hoga agr value return hogi to
        Supplier<Integer> task1 = () -> {
            System.out.println("Ae sala main chala1: "+Thread.currentThread().getName());
            return 1;
        };
        var future1 = CompletableFuture.supplyAsync(task1);

        // change future1 or future for diffrent results
        try {
           var result = future1.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    public static void executorShow(){
//        var executor = Executors.newFixedThreadPool(2);
        var singleExecutorTh = Executors.newSingleThreadExecutor();
      /* try {
           for (var i=0; i<10; i++){
           // using runnable
               executor.submit(()-> {
                   System.out.println(Thread.currentThread().getName());
               });
           }
       }finally {
           executor.shutdown();
       }*/

        try {
            // using callable
            var future = singleExecutorTh.submit(()-> {
                   System.out.println(Thread.currentThread().getName());
                   LongTask.simulate();
                   return 2;
            });

            System.out.println("Doing more work: "+Thread.currentThread().getName());

            try {
                var result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }finally {
            singleExecutorTh.shutdown();
        }
    }
}
