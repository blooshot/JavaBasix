package org.basix.Collections;

public class Customer implements Comparable<Customer>{

    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Customer customer) {

        /*
         * if( this.name > customer.name) isliye use nahi kr skte kyuki,
         * ye sirf number or characters ko hi compare kr sakta hai
         * */

        return this.name.compareTo(customer.name);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
