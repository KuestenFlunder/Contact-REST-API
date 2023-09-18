package com.ltp.contacts.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;



@RestController //Makes the @ResponseBody annotation obsolete for every method.
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping(value="/contact/{id}") 
    //@ResponseBody --> serialise to JSON
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);
           return new ResponseEntity<Contact>(contact,HttpStatus.OK);
    }    

    @PostMapping(value="/contact")
    // RequstBody deserialise the JSON to an POJO
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact) {
        contactService.saveContact(contact);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @Put
    

}
