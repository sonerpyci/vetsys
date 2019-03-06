package com.sonerpyci.springdemo.vetsys.controllers.rest;

import com.sonerpyci.springdemo.vetsys.models.Customer;
import com.sonerpyci.springdemo.vetsys.services.VetsysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
public class MainRestController {

    @Autowired
    private VetsysService vetsysService;


    @GetMapping(value = "/")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping(value = "/findAllCustomers" )
    public Collection<Customer> getAllCustomers(){
        return vetsysService.findAllCustomers();
    }


}
