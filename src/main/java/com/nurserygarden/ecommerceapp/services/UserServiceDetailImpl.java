package com.nurserygarden.ecommerceapp.services;

import com.nurserygarden.ecommerceapp.repositories.UserRepository;
import com.nurserygarden.ecommerceapp.repositories.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceDetailImpl implements UserDetailsService {

    private  final UserRepository userRepository;

    public UserServiceDetailImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not Found with username:" + username));
        return UserDetailsImpl.build(user);
    }
}
