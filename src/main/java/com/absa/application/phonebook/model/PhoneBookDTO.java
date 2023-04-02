package com.absa.application.phonebook.model;

import javax.persistence.Entity;

public class PhoneBookDTO {


    private PhoneBook phoneBook;

    public PhoneBook getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }
}
