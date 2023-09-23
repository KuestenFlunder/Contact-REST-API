package com.ltp.contacts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

@SpringBootTest
@AutoConfigureMockMvc
class ContactsApplicationTests {

@Autowired
private MockMvc mockMvc;

@Autowired
private ContactRepository contactRepository;

private Contact[] contacts = new Contact[]{
new Contact("1","Peter Pan","123"),
new Contact("2","Captain Hook","234"),
new Contact("3","Tinker Bell","234"),
};

@BeforeEach
void setupTestRepository(){
	for (Contact contact : contacts) {
		contactRepository.saveContact(contact);
	}
}

@AfterEach
void clearTestRepository(){
	contactRepository.getContacts().clear();
}





}
