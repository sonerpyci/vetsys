package com.sonerpyci.springdemo.vetsys.dao;

import com.sonerpyci.springdemo.vetsys.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}