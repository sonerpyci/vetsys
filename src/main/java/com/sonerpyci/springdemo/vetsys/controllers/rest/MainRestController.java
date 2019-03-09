package com.sonerpyci.springdemo.vetsys.controllers.rest;

import com.google.gson.Gson;
import com.sonerpyci.springdemo.vetsys.models.Customer;
import com.sonerpyci.springdemo.vetsys.services.PetService;
import com.sonerpyci.springdemo.vetsys.services.CustomerService;
import com.sonerpyci.springdemo.vetsys.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;


@RestController
public class MainRestController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private PetService petService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/searchCustomer")
    public String searchCustomer(@RequestParam String searchQuery, HttpServletRequest req, HttpServletResponse resp){

        List customers = customerService.findCustomersBySearch(req.getParameter("searchQuery"));
        req.setAttribute("customerResult", customers);
        return new Gson().toJson(customers);
    }

    @PostMapping(value = "/searchPet")
    public String searchPet(@RequestParam String searchQuery, HttpServletRequest req, HttpServletResponse resp){

        List pets = petService.findPetsBySearch(req.getParameter("searchQuery"));
        req.setAttribute("customerResult", pets);
        return new Gson().toJson(pets);
    }

    @PostMapping(value = "/searchUser")
    public String searchUser(@RequestParam String searchQuery, HttpServletRequest req, HttpServletResponse resp){

        List users = userService.findUsersBySearch(req.getParameter("searchQuery"));
        req.setAttribute("userResult", users);

        return new Gson().toJson(users);
    }

    @GetMapping(value = "/findAllCustomers" )
    public Collection<Customer> getAllCustomers(){
        return customerService.findAllCustomers();
    }

    @GetMapping(value = "/delete")
    public void deleteCustomer(@RequestParam long id){
        customerService.deleteCustomer(id);
    }

}
