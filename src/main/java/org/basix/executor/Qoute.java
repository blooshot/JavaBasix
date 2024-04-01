package org.basix.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Qoute {


    public static CompletableFuture<String> createAsyncCall(String site, String requestJson,Integer time){
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Getting Qoute from: "+site+" | "+ Thread.currentThread().getName());
            LongTask.simulate(time);
            return requestJson;
        });

        /*try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }*/
    }

    public static void getSites(){

//        Thread.currentThread().

        var site1 = createAsyncCall("site1","{site='site1', price='200'}", 3);
        var site2 = createAsyncCall("site2","{site='site2', price='1000'}", 1);
        var site3 = createAsyncCall("site3","{site='site3', price='800'}", 5);


       try {
           System.out.println(site1.get());
           System.out.println(site2.get());
           System.out.println(site3.get());
//           System.out.println(CompletableFuture.allOf(site1,site2,site3).get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        /*var future = CompletableFuture.supplyAsync(()->{
            System.out.println("Getting Qoute from site1");
//           return  "{site='site1', price='200'}";
        }).thenAccept(()-> System.out.println("{site='site1', price='200'}"));*/
    }
}
