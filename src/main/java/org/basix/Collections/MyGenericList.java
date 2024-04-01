package org.basix.Collections;

import java.util.Iterator;

/* Jab kisi list ko iterate krna ho, but wo custom list ho, to uspr itration perform krne k liye, Iterable interface, interal behaviour se matlab nahi, bus iterate krne dega
*  Java iterable interface humko apne according customize krne deta iterator ki settings, here the demo
*
* */
public class MyGenericList <T> implements Iterable <T> {
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomListIterator(this);
    }

    private class CustomListIterator implements Iterator<T>{
        private  MyGenericList<T> list;
        private int index;

        public CustomListIterator(MyGenericList<T> list){
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return (index < list.count);
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
