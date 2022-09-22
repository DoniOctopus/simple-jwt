package com.enigma.examplejwtjava2.controller;

import com.enigma.examplejwtjava2.Service.CustomerUserDetailService;
import com.enigma.examplejwtjava2.dto.LoginForm;
import com.enigma.examplejwtjava2.security.JWTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    JWTokenUtil jwTokenUtil;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomerUserDetailService customerUserDetailService;

    @GetMapping("/login")
    public String login(@RequestBody LoginForm loginForm){
        UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(loginForm.getUsername(),loginForm.getPassword());
        authenticationManager.authenticate(upat);
        UserDetails userDetails = customerUserDetailService.loadUserByUsername(loginForm.getUsername());
        String token = jwTokenUtil.generateToken(userDetails);
        return token;
    }
}
