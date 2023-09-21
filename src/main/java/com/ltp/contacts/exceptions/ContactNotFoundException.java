package com.ltp.contacts.exceptions;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException (String id){
        super( "The id " + id + " does not Exist in our Contact List.");
    }

}
