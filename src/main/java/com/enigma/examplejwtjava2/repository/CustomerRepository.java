package com.enigma.examplejwtjava2.repository;

import com.enigma.examplejwtjava2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
