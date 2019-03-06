package com.sonerpyci.springdemo.vetsys.services;


import com.sonerpyci.springdemo.vetsys.dao.VetsysRepository;
import com.sonerpyci.springdemo.vetsys.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class VetsysService {

    @Autowired
    private VetsysRepository vetsysRepository;

    public Collection<Customer> findAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : vetsysRepository.findAll()) {
            customers.add(customer);
        }
        return customers;
    }

}
