package com.enigma.examplejwtjava2.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//UserDetails(import) yang digunakan dalam penyedia otentikasi yang direferensikan DAO, yang menggunakan User
public class UserDetailImpl implements UserDetails {
    private String userName;
    private String password;
    //GrantedAuthority sebagai "izin"
    //kita dapat memberikan GrantedAuthoritys (izin) yang berbeda kepada pengguna dengan menempatkan mereka dalam konteks keamanan
    private List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    public UserDetailImpl(String userName, String password, List<GrantedAuthority> grantedAuthorities) {
        this.userName = userName;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    public UserDetailImpl() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
