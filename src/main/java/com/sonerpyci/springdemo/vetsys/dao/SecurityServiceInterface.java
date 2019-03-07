package com.sonerpyci.springdemo.vetsys.dao;

public interface SecurityServiceInterface {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
