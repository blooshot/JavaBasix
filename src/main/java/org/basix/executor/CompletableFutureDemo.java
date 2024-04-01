package org.basix.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void handlingTimeout(){
        var future = CompletableFuture.supplyAsync(()->{
            LongTask.simulate(4);
            return 1;
        });

        try {
//            future.orTimeout(2, TimeUnit.SECONDS).get(); // it just break program to exit thread by throw exception
            var res = future. // this will return a default value/data if task gets timeout
                    completeOnTimeout(1,2,TimeUnit.SECONDS).get();
            System.out.println(res);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAnyOfMethod(){
        // dono mein se jis thread ka kaam pehle khatam hoga uska result pehle dikha denge
        var first = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            LongTask.simulate(2);
            return 20;
        });

        var second = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            LongTask.simulate(3);
            return 31;
        });
//        LongTask.simulate(3);
        CompletableFuture.anyOf(first,second).thenAccept(res-> System.out.println(res+Thread.currentThread().getName()));
        /*first.thenAccept(res-> System.out.println(res+Thread.currentThread().getName()));
        second.thenAccept(res-> System.out.println(res+Thread.currentThread().getName()));*/
    }

    public static void showAllOfMethod(){
        // **allof sare task ko execute hone ka wait krta hai, uske baad apna ek alag task bana kr unn task k results ko use kr sakta hai
        var first = CompletableFuture.supplyAsync(()->1);
        var second = CompletableFuture.supplyAsync(()->2);
        var third = CompletableFuture.supplyAsync(()->3);

        var allTasks = CompletableFuture.allOf(first,second,third);

        allTasks.thenRun(()->{
            try {
                var firstResult = first.get();
                System.out.println(firstResult);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Ho gya kaam khatam Maalik");
        });
    }


    public static void showCombine(){
        // **thenCombine 2 async executed tasks k results ko agruments mein lekar unpr execution krta hai

        var first = CompletableFuture.supplyAsync(()->"20USD").thenApply(str->{
            var price = str.replace("USD","");
            return Integer.parseInt(price);
        });
        var second = CompletableFuture.supplyAsync(()->0.9);

        first.thenCombine(second,(price, exchangeRate)-> price * exchangeRate).thenAccept(result-> System.out.println(result));
    }


    public static CompletableFuture<String> getUserEmailAsync(){
        return CompletableFuture.supplyAsync(()->"email");
    }

    public static CompletableFuture<String> getPlaylistAsync(String email){
        return CompletableFuture.supplyAsync(()->"playlist");
    }
    public static void showComposing(){
        //basically ek task complete hone k baad, uske result se dusre task ko execute krne ko composing bolenge
        // apne ko pehle ID-> email nikalna hai, then usse email -> playlist
       /* var future = CompletableFuture.supplyAsync(()->"email");
        future.thenCompose(email -> CompletableFuture.supplyAsync(()->"playlist")).thenAccept(playlist -> System.out.println(playlist));*/

        // Another way of composing by creating methods
        getUserEmailAsync().thenCompose(CompletableFutureDemo::getPlaylistAsync).thenAccept(playlist -> System.out.println(playlist));
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
                .thenApply(CompletableFutureDemo::toFahrenhiet) // thenApply future k result function ki help se change kr skta hai
                .thenAccept(f-> System.out.println(f)); // thenAccept kindoff sideEffect hai, ek chiz hone pr dusri new kuch krna, pehle mein change na krna
    }

    public static void showException(){
        var future = CompletableFuture.supplyAsync(()->{
            System.out.println("Main chala hawao mein");
            throw new IllegalArgumentException();
        });

        try {
            //get() passess the expection msg to Main thread, so the exception can be thrown
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
