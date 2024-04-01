package org.basix.Collections;

import java.util.Comparator;

public class EmailComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer customer, Customer customer1) {
        return customer.getEmail().compareTo(customer1.getEmail());
    }
}
