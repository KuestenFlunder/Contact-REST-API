package com.ltp.contacts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping(value="/contacts/{id}") 
    public void getContact(@PathVariable String id) {
        System.out.println(id);
    }
    

}
