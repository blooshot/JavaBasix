package org.basix;

import org.basix.Collections.CollectionsDemo;
import org.basix.Collections.Customer;
import org.basix.Collections.EmailComparator;
import org.basix.lambdas.LambdaDemo;
import org.basix.streams.StreamsDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
   /*     var scanner = new Scanner(System.in);
        var scanReturn = scanner.nextLine();
        UserDeserializer jsonRead;
        var mapper = new ObjectMapper();
        mapper.registerModule(new SimpleModule("UserDeserializer"));
        try {
              jsonRead = mapper.readValue(scanReturn, UserDeserializer.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonRead.getName());*/
      /*  var commandu = new CommandBase();
        commandu.start();*/
/*-----------------------------------------  REAL CODE STARTS HERE  ------------------------------------------------*/

    /*
    *  INTERFACES AND MYTUBE CODE
    * */

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

        /*
        *  CONCURRENCY & THREAD CODE
        * */
//        System.out.println(Thread.activeCount());
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        ThreadDemo.show();
//        ThreadDemo.race_condition();
//        ThreadDemo.syncedCollectionRace();
//        ThreadDemo.confinement_strategy();
//        ThreadDemo.showVolatile();

        /*
        *   EXECUTOR SERVICE AND COMPLEATABLES CODE
        * */
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
//        CompletableFutureDemo.showTransformation();
//        CompletableFutureDemo.showComposing();
//        CompletableFutureDemo.showCombine();
//        CompletableFutureDemo.showAllOfMethod();
//        CompletableFutureDemo.showAnyOfMethod();
//        CompletableFutureDemo.handlingTimeout();
//        Qoute.getSites();


        /*
        *   GENERICS CODE
        * */
       /* var mlist = new MyList();
        mlist.add(1);
        mlist.add("1");*/

        // reference type ka example
        /*var genList = new GenericList<String>();
        genList.add("adfs");
        genList.add("pqrwo");*/

        // premitive type
        /*GenericList<Integer> genListPre = new GenericList<>();
        genListPre.add(1); // java Boxing the value
        int num = genListPre.get(0); // java unboxing
        System.out.println(num);*/

        /*var user1 = new User(240);
        var user2 = new User(2310);
//        if(user1.compareTo(user2) < 0){
//            System.out.println("U1 < U2");
//        } else if (user1.compareTo(user2) == 0) {
//            System.out.println("U1 == U2");
//        }else {
//            System.out.println("U1 > U2");
//        }

        System.out.println(Utils.max(user2,user1));
        Utils.multiParam(10,"20");*/

        /* user class ko inherit krne k baad bhi instructor printuser() Accept nhi krege,
        * uske liye ya to sare elements dubara userList ko ander dekar, userList ko printUser() mein dena hoga
        * warna apan use krenge wildcard, jo chalega sarkari
        * */
//        var instructorGenericList = new GenericList<>();
//        Utils.printUsersList(instructorGenericList);

        /* ye wild card wala sab ander le jayega, kyuki end mein sabko defualt(Object) parent class mein cast kr dega
        *  iss behavoir ko restrict krne k liye printUsersListWild() User constraint use krenge,
        *  taki ye method sirf User class or uski sub-type or sub-class ko hi accept krre
        * */
//        Utils.printUsersListWild(new GenericList<Integer>());


        /*
        *   COLLECTIONS UTILS CODE
        * */
           /* var list = new MyGenericList<String>();
            list.add("name");
            list.add("class");

            var itrator = list.iterator();
            while (itrator.hasNext()){
                System.out.println(itrator.next());
            }*/
            /*for(var it : list){
                System.out.println(it);
            }*/

//        CollectionsDemo.collectionCore();
        /*List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("r1z","e3"));
        customers.add(new Customer("r2x","e2"));
        customers.add(new Customer("r3","e1"));*/

        // Ye comparable ko use krega sorting k liye
//        Collections.sort(customers);

        // Ye humare defined comparator use krega sorting k liye
//        Collections.sort(customers,new EmailComparator());
// **## By default println() object k toString() ko call krta hai, agr wo implemented nahi hai, to numbered object de dega
//        System.out.println(customers);

//        CollectionsDemo.showQueue();
//        CollectionsDemo.showSet();
//        CollectionsDemo.showMap();


        /*
        *   LAMBDA AND FUCTIONAL INTERFACES CODE
        * */
//        LambdaDemo.showBasix();
//        LambdaDemo.showAnonyInnerCls();
//        LambdaDemo.lambdaExo();
//        LambdaDemo.lambdaMethodRef();
//        LambdaDemo.consumerShow();
//        LambdaDemo.supplierShow();
//        LambdaDemo.functionShow();
//        LambdaDemo.predicateShow();
//        LambdaDemo.binaryOperatorFunction();
//        LambdaDemo.unaryOperatorFunction();

        /*
        *   STREAMS API CODE
        * */
//        StreamsDemo.show();
//        StreamsDemo.createStream();
//        StreamsDemo.slicingAndSort();
//        StreamsDemo.reducerD();
        StreamsDemo.collectorK();

        /*-----------------------------------------  REAL CODE ENDS HERE  ------------------------------------------------*/

      /*  String url = "https://swapi.dev/api/people/1";
        HttpClient theClient = HttpClient.newHttpClient();
        HttpRequest theRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        HttpResponse<String> theResponse = theClient.sendAsync(theRequest,HttpResponse.BodyHandlers.ofString()).join();
        if (theResponse.statusCode() == 200) {
            // Successful response
            String responseBody = theResponse.body();
            System.out.println("Response body: " + responseBody);
        } else {
            // Handle unsuccessful response
            System.err.println("Error: HTTP status code " + theResponse.statusCode());
        }*/

    }

}