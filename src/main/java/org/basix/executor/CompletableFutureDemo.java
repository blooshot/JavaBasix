package org.basix.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void showComposing(){
        //basically ek task complete hone k baad, dusre task ko execute krne ko composing bolenge
        // apne ko pehle ID-> email nikalna hai, then usse email -> playlist
        var future = CompletableFuture.supplyAsync(()->"email");
        future.thenCompose(email -> CompletableFuture.supplyAsync(()->"playlist")).thenAccept(playlist -> System.out.println(playlist));
    }

    public static int toFahrenhiet(int celsius){
        return (int) (celsius * 1.8) + 32;
    }

    public static void showTransformation(){
        var future = CompletableFuture.supplyAsync(()->24);

       /* try {
            var result = future.thenApplyAsync((celsius)->{
                return (celsius * 1.8) + 32;
            }).get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }*/

        //we can do above^^ with less lines
        future
                .thenApply(CompletableFutureDemo::toFahrenhiet) // Transforming the result
                .thenAccept(f-> System.out.println(f)); // showing/consuming the result the result
    }

    public static void showException(){
        var future = CompletableFuture.supplyAsync(()->{
            System.out.println("Main chala hawao mein");
            throw new IllegalArgumentException();
        });

        try {
            //get() passess the expection msg to Main thread, to the exception can be thrown
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

       /* try {
            //exceptionally() return a naya future that used to return the default value, and stops program to crash
            var lastValue = future.exceptionally(e->3).get();
            System.out.println(lastValue);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }*/

    }

    public static void show(){
        var future = CompletableFuture.supplyAsync(()->1);

        //** thenRun used to run a code or execute another task after accomplishion of current/initial task
        /*future.thenRun(()->{
            // runs on Main thread
            System.out.println("Done: "+Thread.currentThread().getName());
        });*/

        /*future.thenRunAsync(()->{
            // runs on forkJoinPool thread, doesn't block main thread
            System.out.println("Done: "+Thread.currentThread().getName());
        });*/


        //** thenAccept, future k result pr operation perform krne deta, or ek new Completable return krta hai
        future.thenAcceptAsync(result->{
            // Async hai to forkPool Thread chalega, warna main pr chalega
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });

        LongTask.simulate();
    }
}
