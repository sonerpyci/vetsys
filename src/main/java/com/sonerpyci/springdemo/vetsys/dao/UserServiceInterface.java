package com.sonerpyci.springdemo.vetsys.dao;

import com.sonerpyci.springdemo.vetsys.models.User;

public interface UserServiceInterface {

    void save(User user);

    User findByUsername(String username);
}