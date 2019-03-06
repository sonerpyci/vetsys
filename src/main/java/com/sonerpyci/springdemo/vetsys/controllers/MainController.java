package com.sonerpyci.springdemo.vetsys.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("hellojsp")
    public String init(){
        return "index"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)

    }



}
