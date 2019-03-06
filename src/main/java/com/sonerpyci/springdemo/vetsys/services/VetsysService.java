package com.sonerpyci.springdemo.vetsys.services;


import com.sonerpyci.springdemo.vetsys.dao.CustomerRepository;
import com.sonerpyci.springdemo.vetsys.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class VetsysService {

    @Autowired
    private CustomerRepository customerRepository;

    public Collection<Customer> findAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {
            customers.add(customer);
        }
        return customers;
    }

    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }

    public Customer findCustomerById(long id){
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }


    public void saveCustomer(Customer customer){
        System.out.println("SONER INFO : " + customer.getAddress());
        System.out.println("SONER INFO : " + customer.getDistrict());
        System.out.println("SONER INFO : " + customer.getPhone());
        customerRepository.save(customer);
    }

}
