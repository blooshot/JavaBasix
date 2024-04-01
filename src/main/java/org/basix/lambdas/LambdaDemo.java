package org.basix.lambdas;

import java.util.List;
import java.util.function.*;

public class LambdaDemo {

    /*
     * Use UnaryOperator when you need to perform an operation on a single value.
     * Use BinaryOperator when you need to perform an operation on two values.
     * */
    public static void unaryOperatorFunction(){
        /*
        * Used for operations like incrementing/decrementing a value, negating a number, or transforming a value to a different type.
        * */
        UnaryOperator<Integer> sqre = n -> n * n;
        UnaryOperator<Integer> increment  = n -> n + 1;

        var result = sqre.andThen(increment).apply(2);
        System.out.println(result);
    }

    public static void binaryOperatorFunction(){
        /*
        *  Function Interface k type hai ye, or ye primitive value specific bhi aata hai IntBinaryOperator()
        * Used for operations like addition, subtraction, string concatenation, or custom comparison logic.
        * */

        BinaryOperator<Integer> add = (a,b)-> a +b;
        Function<Integer,Integer> squre = a -> a * a;

        var result = add.andThen(squre).apply(2,3);
        System.out.println(result);
    }

    public static void predicateShow(){
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        var result = isLongerThan5.test("adrf");
//        System.out.println(result);

        // Combining predicates
        Predicate<String> hasLeftBr = s -> s.startsWith("{");
        Predicate<String> hasRigtBr = s -> s.endsWith("}");
        Predicate<String> hasLRBr = hasLeftBr.and(hasRigtBr);

       var ex =  hasLRBr.test("{asdf:asdf");
        System.out.println(ex);
    }

    public static void functionShow(){
        Function<String, Integer> map = str -> str.length();
        var len = map.apply("krishna");
//        System.out.println(len);

        /*
        * Composing Funtions
        * there are 2 ways to do this
        * */
        Function<String,String> replaceColon = str -> str.replace(":","=");
        Function<String,String> addBraces = str-> "{" + str + "}";

        // Way 1
        var result = replaceColon.
                    andThen(addBraces).
                    apply("mera:lele");

        // Way 2
//        result = addBraces.compose(replaceColon).apply("asfsa:ohijwri");
        result = replaceColon.compose(addBraces).apply("asfsa:ohijwri");
        System.out.println(result);
    }

    public static void supplierShow(){
        /*
        * Supplier and Consumer can different name for primitive value function like BooleanSupplier,LongConsumer, for excluding autoboxing
        *
        * */
        Supplier<Double> getRandom = ()->Math.random();
        var random = getRandom.get();
        System.out.println(random);
    }

    public static void consumerShow(){
        List<Integer> list = List.of(1,2,3,4,5,6);

        //Example of Imperative Programming ( How needs to be done | for, if/else, switch/case)
        for (var item : list){
            System.out.println(item);
        }

        // Declartive Programming(What need to be done) | accepts a consumer
        list.forEach((item)-> System.out.println(item));

        // Consumer Chaining
        List<String> listString = List.of("a","b","c","d");
        Consumer<String> print = item -> System.out.println(item);
        Consumer<String> printUpper = item -> System.out.println(item.toUpperCase());

        listString.forEach(print.andThen(printUpper).andThen(print));

    }

    public static void print(String message){
        System.out.println(message);
    }
    public void print1(String message){
        System.out.println(message);
    }
    public LambdaDemo(String message){
        System.out.println(message);
    }
    public static void lambdaMethodRef(){
        /*  greet(message -> System.out.println(message)); can written as greet(System.out::println);
        *   this called method reference which can be achieved by instance or direct
        * */
        // Reference Method
//        greet(message -> print(message));
//        greet(LambdaDemo::print); // shortWay for above^ code

        // Instance Method
//        var demo = new LambdaDemo();
//        greet(message -> demo.print1(message));
//        greet(demo::print1); // shortWay for above^ code

        // Construction Method
//        greet(message -> new LambdaDemo(message));
//        greet(LambdaDemo::new); // shortWay for above^ code
    }

    public static String prefix = "-";
    public static void lambdaExo(){
        String sufafix  = "!";
        /* ---------------------------------------------------------------------
         * Some interface are called functional interface, cause they can be implemneted by using a fucntion
         * Instead of creating an anonymous class, we can pass lambda fuction for implementation
         *
         * */
        /* greet((message)->{
         *//*
         * we can defining type in param, cause interf. mein already humne type define kia hai
         * java jab greet() ko run krega to  wo intef. k print() se signature match krega
         * *//*
            message = message.toUpperCase();
            System.out.println(message);
        });*/

        /* ---------------------------------------------------------------------
         * parentheses() and curly brackets can be omitted in case of single param or single line statement
         * */
//        greet(message -> System.out.println(message));

        /*---------------------------------------------------------------------
        * also we can store lambda expression in a variable
        * */
//        Printer printer = message -> System.out.println(message);

        /*
        * Lambda cannot store fields/variables but they access methods or class fields/variable
        * */
        greet(message -> System.out.println(prefix+message+sufafix));
    }

    public static void showAnonyInnerCls(){
        /*
        * to jese showBasix() mein printer chalane k liye ConsolePrinter class banai, jisse over code likhna pada
        * iss problem ko Anonymous Inner Class bana kr kia ja sakta hai, example below
        *  isko lambda ki help se or improve kia ja sakta
        *  if we use *this keyword in anonymous class it represent the printer class only but in lambda it will
        * represent the current lambdaDemo class
        * */
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }

    public  static void showBasix(){
        greet(new ConsolePrinter());
    }

    public static void greet(Printer printer){
        printer.print("Chall bsdk3");
    }
}
