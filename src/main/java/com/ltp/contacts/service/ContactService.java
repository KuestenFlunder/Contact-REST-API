package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;

public interface ContactService {
    
    Contact getContactById(String id);
    void saveContact ( Contact conatact);
    void updateContact(String id, Contact contact);
}
