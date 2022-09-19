package com.enigma.examplejwtjava2.Service;

import com.enigma.examplejwtjava2.entity.Customer;
import com.enigma.examplejwtjava2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
    public class CustomerServiceDBImpl implements CustomerService{
        @Autowired
        CustomerRepository customerRepository;

        @Override
        public List<Customer> findAll() {
            return customerRepository.findAll();
        }

        @Override
        public Customer getById(String id) {
            return customerRepository.findById(id).get();
        }

        @Override
        public void createNewCustomer(Customer customer) {
            customerRepository.save(customer);
        }

        @Override
        public void updateCustomer(Customer customer) {

        }

        @Override
        public void removeCustomer(String id) {

        }
 }
