package com.example.JuintTesting.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class UserServiceDetails implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SimpleGrantedAuthority userRole = new SimpleGrantedAuthority("USER");
        SimpleGrantedAuthority adminRole = new SimpleGrantedAuthority("ADMIN");
        User user = new User("udhaya" , passwordEncoder.encode("udhaya"), Arrays.asList(adminRole));
        return user;
    }
}
