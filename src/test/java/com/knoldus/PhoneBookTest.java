package com.knoldus;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Test
    void findPhoneByName() {
        String name = "VAISHALI";
        Optional<String> getPhoneNumber = phoneBook.findPhoneByName(name);
        assert (getPhoneNumber.get().equals("9815637483"));
    }

    @Test
    void findNameByPhoneNumber() {
        String phoneNumber = "9815637483";
        Optional<String> getNameByPhoneNum = phoneBook.findNameByPhoneNumber(phoneNumber);
        assert (getNameByPhoneNum.get().equals("VAISHALI"));
    }
}
