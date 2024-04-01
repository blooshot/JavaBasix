package org.basix.generics;

public class User implements Comparable<User> {

    public int points;

    public User(int point){
        this.points = point;
    }
    @Override
    public int compareTo(User Other) {
        /*
        * this < Other  -> -1 // any negetive number
        * this == Other ->  0
        * this > Other  ->  1 // any positive number
        * */

        return this.points - Other.points;
    }

    @Override
    public String toString() {
        return "User{" +
                "points=" + points +
                '}';
    }
}
