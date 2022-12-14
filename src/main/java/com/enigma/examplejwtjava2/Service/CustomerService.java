package com.enigma.examplejwtjava2.Service;

import com.enigma.examplejwtjava2.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> findAll();
    public Customer getById(String id);
    public void createNewCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(String id);
}
