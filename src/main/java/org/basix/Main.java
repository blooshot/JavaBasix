package org.basix;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.basix.Library.Books;
import org.basix.Library.Ledger;
import org.basix.Library.UserDeserializer;
import org.basix.Library.Users;
import org.basix.executor.CompletableFutureDemo;
import org.basix.executor.ExecutorDemo;
import org.basix.executor.MailService;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

  /*  var newBook = new Books(1,"The Mummy","Krishna",20.60);
       var User = new Users(1,"krishna","Support",'1');
       var Ledger1 = new Ledger();
       var mapper = new ObjectMapper();
       String jsonObj = null;
       try {
           jsonObj = mapper.writeValueAsString(newBook);
        } catch (JsonProcessingException e) {
            // Handle JSON processing exception
            e.printStackTrace();
        }*/

//        System.out.println(jsonObj);
//        System.out.println(Ledger1.getIssue_date());
        var scanner = new Scanner(System.in);
        var scanReturn = scanner.nextLine();
        UserDeserializer jsonRead;
        var mapper = new ObjectMapper();
//        mapper.registerModule(new SimpleModule("UserDeserializer"));
        try {
            jsonRead = mapper.readValue(scanReturn, UserDeserializer.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonRead.getName());
      /*  var commandu = new CommandBase();
        commandu.start();*/

      /*  var video = new Video();
        video.setFileName("MahVideio.mp4");
        video.setTitle("Mera video aa gya");
        video.setUser(new User("krishnaJi", "krishna@asf.gom"));

        var processor = new VideoProcessor(new VideoEncoderImpl(), new VideoDatabaseImpl());
        processor.process(video);*/


       /*
       // Constructor Injection or Poormans code
       var report = new TaxReport(n(ew TaxCalculator2018(10_000)));
        report.show();
        // Setter injection
        report.setCalculator(new TaxCalculator2019());
        report.show();*/

        // Method Injection
        /*var report = new TaxReport();
        report.show(new TaxCalculator2018(10_000));
        report.show(new TaxCalculator2019());*/

//        System.out.println(Thread.activeCount());
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        ThreadDemo.show();
//        ThreadDemo.race_condition();
//        ThreadDemo.syncedCollectionRace();
//        ThreadDemo.confinement_strategy();
//        ThreadDemo.showVolatile();

//        ExecutorDemo.executorShow();
//        ExecutorDemo.completeableFutureShow();

      /*  var sendMail = new MailService();
//        sendMail.sendMail();
        sendMail.sendMailAsync();
        System.out.println("fassa reh gya: "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

//        CompletableFutureDemo.show();
//        CompletableFutureDemo.showException();
//         CompletableFutureDemo.showTransformation();
//        CompletableFutureDemo.showComposing();
    }

}