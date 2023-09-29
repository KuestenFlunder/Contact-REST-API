package com.ltp.contacts.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ltp.contacts.entity.Contact;
import com.ltp.contacts.service.ContactService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

//@Tag(name = "Contact Controller",description = "Create and retrieve contacts ")
@RequestMapping(value = "/contacts")
@RestController // Makes the @ResponseBody annotation obsolete for every method.
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Operation(summary = "Retrieves Contacts", description = "Provides a list of all contacts")
    @Tag(name = "GET contacts")
    @GetMapping
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @Operation(summary = "Get contact by Id", description = "Returns a contact based on an ID")
    @Tag(name = "GET contacts")
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @Tag(name = "POST new contact")
    @Operation(summary = "Create Contact", description = "Creates a contact from the provided payload")
    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Tag(name = "PUT contact update")
    @Operation(summary = "Update Contact", description = "Updates a contact based on the ID with the provided payload")
    @PutMapping("/contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @Valid @RequestBody Contact contact) {
        contactService.updateContact(id, contact);
        return new ResponseEntity<Contact>(contactService.getContactById(id), HttpStatus.OK);
    }

    @Tag(name = "DELETE contact")
    @Operation(summary = "Delete Contact", description = "Delete contact based on the ID")
    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
