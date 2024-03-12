package org.basix.executor;

import java.util.concurrent.CompletableFuture;

public class MailService {

    public void sendMail(){
        LongTask.simulate();
        System.out.println("Mail was sent: "+ Thread.currentThread().getName());
    }

    public CompletableFuture<Void> sendMailAsync(){
        return CompletableFuture.runAsync(()->sendMail() );
    }
}
