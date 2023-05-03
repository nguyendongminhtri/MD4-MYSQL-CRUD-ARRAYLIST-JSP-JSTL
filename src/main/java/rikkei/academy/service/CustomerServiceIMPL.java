package rikkei.academy.service;

import rikkei.academy.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements ICustomerService {
    public static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Cha Beo", "chabeo@gmail.com", "JV11"));
        customerList.add(new Customer(2, "Ngan", "ngan@gmail.com", "Thanh Hoa"));
        customerList.add(new Customer(3, "Son TX", "sontx@gmail.com", "Thanh Hoa"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId()!=0){
            customerList.set(customerList.indexOf(findById(customer.getId())), customer);
            return;
        }
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getId()==id){
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getId()==id){
                 customerList.remove(i);
            }
        }
    }
}
