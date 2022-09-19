package com.enigma.examplejwtjava2.Service;

import com.enigma.examplejwtjava2.dto.UserDetailImpl;
import com.enigma.examplejwtjava2.entity.Customer;
import com.enigma.examplejwtjava2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!customerRepository.findCustomersByUserName(username).isPresent()){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Invalid username or password");
        }
        Customer customer = customerRepository.findCustomersByUserName(username).get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails userDetails = new UserDetailImpl(customer.getUserName(), customer.getPassword(), authorities);
        return userDetails;
    }
}
