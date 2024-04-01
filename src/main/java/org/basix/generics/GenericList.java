package org.basix.generics;

/*
* Under the hood java K generic ko object mein convert kr dega jisko hum byte code mein dekh sakte hai
* MyList ki poor man approach runtime error degi, lekin generic compile time mein hi bta dega issue, or speed mein change rahega
* constraint(extends) lagane se type fix ho jaate hai, uske alawa koi other type ka koi value nhi lega, uske childs hi accept krega only
* */

// isko contraint bolte, agr ye na ho to java K ko direct object class se replace krega,
// agr ek se jada constraint(extends) hai to left most wale ko choose krega iss selection ko erasure bolte
//public class GenericList <K extends Number & Comparable>{
public class GenericList <K>{

    private K[] items = (K[]) new Object[10];
    private int count;

    public void add(K item){
        items[count++] = item;
    }

    public K get(int index){
        return items[index];
    }

}
