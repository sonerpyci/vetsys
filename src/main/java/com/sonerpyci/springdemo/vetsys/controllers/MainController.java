package com.sonerpyci.springdemo.vetsys.controllers;


import com.sonerpyci.springdemo.vetsys.models.Customer;
import com.sonerpyci.springdemo.vetsys.models.Pet;
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
    public void saveCustomer(@ModelAttribute Customer customer, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp){
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


    @GetMapping(value = "/pet")
    public String initPet(HttpServletRequest req){
        req.setAttribute("pets", vetsysService.findAllPets());
        req.setAttribute("mode", "PET_VIEW");
        return "pet"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @GetMapping(value = "/createPet")
    public String createPet(HttpServletRequest req){
        req.setAttribute("mode", "PET_CREATE");
        return "pet";
    }

    @PostMapping(value = "/savePet")
    public void updatePet(@ModelAttribute Pet pet, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp){
        vetsysService.savePet(pet);
        req.setAttribute("pets", vetsysService.findAllPets());
        req.setAttribute("mode", "PET_VIEW");
        try {
            resp.sendRedirect("/pet"); //redirect to pet page
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/updatePet")
    public String initPet(@RequestParam long id, HttpServletRequest req){
        req.setAttribute("pet", vetsysService.findPetById(id));
        req.setAttribute("mode", "PET_EDIT");
        return "pet"; //application.properties'de suffix keywordlu ayarı silersem burada .jsp uzantısını eklemem gerekir. (index.jsp)
    }

    @GetMapping(value = "/deletePet")
    public void deletePet(@RequestParam long id, HttpServletRequest req, HttpServletResponse resp){
        vetsysService.deletePet(id);
        try {
            resp.sendRedirect("/pet");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
