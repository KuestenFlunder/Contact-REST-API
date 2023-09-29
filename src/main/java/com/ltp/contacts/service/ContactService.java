package com.ltp.contacts.service;


import com.ltp.contacts.entity.Contact;
import java.util.List;

public interface ContactService {

    Contact getContactById(String id) ;

    void saveContact(Contact conatact);

    void updateContact(String id, Contact contact);

    void deleteContact(String id);

    List<Contact> getContacts();
}
