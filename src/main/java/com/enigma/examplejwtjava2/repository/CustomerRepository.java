package com.enigma.examplejwtjava2.repository;

import com.enigma.examplejwtjava2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    public Optional<Customer> findCustomersByUserName(String userName);
}
