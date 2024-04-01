package org.basix.Collections;

import java.util.*;

/* INTERFACE    -> IMPLEMENTATION
*  collection   -> Arraylist
*  List         -> Arraylist
*  Queue        -> ArrayeDeque
*  Set          -> HashSet
*  Map          -> HashMap
*
* */
public class CollectionsDemo {
    public static void collectionCore(){
        Collection<String> collection = new ArrayList<>();
        collection.add("1");
        collection.add("2");
        collection.add("3");
        System.out.println(collection);
    }

    public static void collectionList(){
//        Collections class indexing support nahi krta isliye list banaya, add,get,remove index base pr chal sakte hai
        // maintain order

        List<String> list = new ArrayList<>();
        Collections.addAll(list,"dso","ji","lkias");

        list.add(2,"lawdeya");
        System.out.println(list);
    }

    public static void showQueue(){
        // Queue work on FIFO principle
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("d");
//        queue.offer("f"); // add methods can give error, but offer will return boolean

//        var front = queue.peek(); // return first element, not throw error if queu is null
//        var front = queue.element(); // throw error if queue is null
        var front = queue.remove(); // remove firt element
//        var front = queue.poll();
        System.out.println(front);
        System.out.println(queue);
    }

    public static void showSet(){
        // works as a list of only unique elements, not maintain the order of elements
        Set<String> set1 = new HashSet<>();
        set1.add("k1");
        set1.add("k2");
        set1.add("k3");

        Set<String> set2 = new HashSet<>(Arrays.asList("k2","k3","k5"));

        // Intersaction : jo elements same hai dono mein wo return honge
//        set1.retainAll(set2);

        // Union : dono sets k element merge kr dega, Unique entries only
//        set1.addAll(set2);

        // Difference : set1 se wo sab elements hata dega, jo set2 mein hai
        set1.removeAll(set2);

        System.out.println(set1);
    }

    public static void showMap(){
        var c1 = new Customer("name1","e1");
        var c2 = new Customer("name2","e2");
        var c3 = new Customer("name3","e3");

        Map<String, Customer> map = new HashMap<>();

        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);
        map.put(c3.getEmail(), c3);

        var unknow = new Customer("Unknown","ueno");

        // get by key
//        var customer = map.get("e2");

        // get by key or a default value
//        var customer = map.getOrDefault("e22",unknow);

//        var customer = map.containsKey("e2");

//        var customer = map.replace("e2",new Customer("adspf","adsf"));

//        System.out.println(map);

        // iteration returns key
        /*for ( var key : map.keySet()){
            System.out.println(key);
        }*/

        // iteration returns K V object
        /*for ( var entry : map.entrySet()){
//            System.out.println(entry);
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }*/

        // returns collection of customers
        for ( var customer : map.values()){
            System.out.println(customer);
        }

    }


}
