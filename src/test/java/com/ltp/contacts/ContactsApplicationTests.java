package com.ltp.contacts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.apache.catalina.connector.Request;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
@AutoConfigureMockMvc
class ContactsApplicationTests {

@Autowired
private MockMvc mockMvc;

@Autowired
ObjectMapper objectMapper;

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

@Test
public void getContactByIdTest() throws Exception {
	RequestBuilder request = MockMvcRequestBuilders.get("/contact/1");
	
	mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.name").value(contacts[0].getName()))
		.andExpect(jsonPath("$.phoneNumber").value(contacts[0].getPhoneNumber()));
}

@Test
public void getAllContactsTest() throws Exception{
	RequestBuilder request = MockMvcRequestBuilders.get("/contact/all");
	
	mockMvc.perform(request)
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.size()").value(contacts.length))
		.andExpect(jsonPath("$[2].name").value(contacts[2].getName()));
}

@Test
public void contactNotFoundTest() throws Exception{
	RequestBuilder request = MockMvcRequestBuilders.get("/contact/4");
	
	mockMvc.perform(request)
		.andExpect(status().isNotFound());
}

@Test
public void validContactCreationTest() throws Exception{
	RequestBuilder request = MockMvcRequestBuilders
		.post("/contact")
		.contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(new Contact( "Wendy Darling","456")));

	mockMvc.perform(request)
		.andExpect(status().isCreated());
}
@Test
public void invalidContactCreationTest() throws Exception{
	RequestBuilder request = MockMvcRequestBuilders
		.post("/contact")
		.contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(new Contact( " "," ")));

	mockMvc.perform(request)
		.andExpect(status().isBadRequest());
}

@Test
public void updateContactTest() throws Exception{
	RequestBuilder request = MockMvcRequestBuilders
		.put("/contact/1")
		.contentType(MediaType.APPLICATION_JSON)
		.content(objectMapper.writeValueAsString(new Contact("1","Winnie Puh","789")));

	mockMvc.perform(request)
		   .andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("$.name").value("Winnie Puh"));
}


}
