package com.sonerpyci.springdemo.vetsys.controllers;


import com.sonerpyci.springdemo.vetsys.models.Customer;
import com.sonerpyci.springdemo.vetsys.services.VetsysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class MainController {

    @Autowired
    private VetsysService vetsysService;




    @GetMapping(value = "/")
    public String init(HttpServletRequest req){
        req.setAttribute("customers", vetsysService.findAllCustomers());
        req.setAttribute("mode", "CUSTOMER_VIEW");
        return "index"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @GetMapping(value = "/updateCustomer")
    public String init(@RequestParam long id, HttpServletRequest req){
        req.setAttribute("customer", vetsysService.findCustomerById(id));
        req.setAttribute("mode", "CUSTOMER_EDIT");
        return "index"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @PostMapping(value = "/saveCustomer")
    public void updateCustomer(@ModelAttribute Customer customer, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp){
        vetsysService.saveCustomer(customer);
        req.setAttribute("customers", vetsysService.findAllCustomers());
        req.setAttribute("mode", "CUSTOMER_VIEW");
        try {
            resp.sendRedirect("/"); //redirect to homepage
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/createCustomer")
    public String createCustomer(HttpServletRequest req){
        req.setAttribute("mode", "CUSTOMER_CREATE");
        return "index";
    }

    @GetMapping(value = "/deleteCustomer")
    public void deleteCustomer(@RequestParam long id, HttpServletRequest req, HttpServletResponse resp){
        vetsysService.deleteCustomer(id);
        try {
            resp.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
