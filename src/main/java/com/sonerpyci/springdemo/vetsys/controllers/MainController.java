package com.sonerpyci.springdemo.vetsys.controllers;


import com.sonerpyci.springdemo.vetsys.services.VetsysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class MainController {

    @Autowired
    private VetsysService vetsysService;




    @GetMapping("/")
    public String init(HttpServletRequest req){
        req.setAttribute("customers", vetsysService.findAllCustomers());
        req.setAttribute("mode", "CUSTOMER_VIEW");
        return "index"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }



}
