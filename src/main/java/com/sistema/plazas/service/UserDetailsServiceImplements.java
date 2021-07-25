package com.sistema.plazas.service;

import com.sistema.plazas.repository.UserRepository;
import com.sistema.plazas.security.JwtUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplements implements UserDetailsService {

	@Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	com.sistema.plazas.entity.User user = userRepository.findByUsername(username).get();
        return JwtUser.build(user);
    }
}