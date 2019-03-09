package com.sonerpyci.springdemo.vetsys.services;

import com.sonerpyci.springdemo.vetsys.dao.RoleRepository;
import com.sonerpyci.springdemo.vetsys.dao.UserRepository;
import com.sonerpyci.springdemo.vetsys.dao.UserServiceInterface;
import com.sonerpyci.springdemo.vetsys.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List findUsersBySearch(String searchQuery){
        List userSearchResult = new ArrayList<>();
        Query query = entityManager.createQuery("SELECT u.id , u.username FROM User u WHERE u.username LIKE:searchQuery");
        query.setParameter("searchQuery", '%'+searchQuery+'%');
        try {
            userSearchResult = query.getResultList();
        } catch (Exception e) {
            // Handle exception
        }
        return userSearchResult;
    }





}