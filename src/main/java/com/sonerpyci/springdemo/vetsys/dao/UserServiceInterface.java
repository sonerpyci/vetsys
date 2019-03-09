package com.sonerpyci.springdemo.vetsys.dao;

import com.sonerpyci.springdemo.vetsys.models.User;

import java.util.List;

public interface UserServiceInterface {

    void save(User user);

    User findByUsername(String username);

    List findUsersBySearch(String searchQuery);
}