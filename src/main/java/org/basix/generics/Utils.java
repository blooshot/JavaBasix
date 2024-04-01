package org.basix.generics;

public class Utils {

    // here we have generic method only
    public static <K extends Comparable<K>> K max(K first, K second){
        return  (first.compareTo(second) < 0) ? second : first;
    }

    public static <k, V> void multiParam(k key, V value){
        // multiparam generic
        System.out.println(key+" = "+value);
    }

    public static void printUser(User user){
        System.out.println(user);
    }

    public static void printUsersList(GenericList<User> users){

    }

    //class CAP#1 {}

    public static void printUsersListWild(GenericList<? super User> users){

        // with extends keyword hum sirf user k object ko read kr skate hai, usme add ya update nahi
//        User x = users.get(0);

//        super keyword k use se apan values read nhi kr skte type cast k sath, apne Object hi use krna padega
//        Object u = users.get(0);
//        Also super keyword gives us access to add data
        users.add(new Instructor(30));

    }
}
