package com.ltp.contacts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    

}
