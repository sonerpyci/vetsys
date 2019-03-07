package com.sonerpyci.springdemo.vetsys.services;

import com.sonerpyci.springdemo.vetsys.dao.RoleRepository;
import com.sonerpyci.springdemo.vetsys.dao.UserRepository;
import com.sonerpyci.springdemo.vetsys.dao.UserServiceInterface;
import com.sonerpyci.springdemo.vetsys.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}