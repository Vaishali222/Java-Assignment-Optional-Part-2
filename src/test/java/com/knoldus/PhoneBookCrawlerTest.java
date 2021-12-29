package com.knoldus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class PhoneBookCrawlerTest {

    PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler();

    String name = "VAISHALI";
    String phoneNumber = "9815637483";

    @Test
    void findPhoneByNameAndPunishIfNothingFound() {

        Optional<String> getPhoneNumber = phoneBookCrawler
                .findPhoneByNameAndPunishIfNothingFound(name);
        assert (getPhoneNumber.get().equals("9815637483"));
    }

    @Test
    void findPhoneByNameAndPrintPhoneBookIfNothingFound() {

        Optional<Object> getPhoneNumber1 = phoneBookCrawler
                .findPhoneByNameAndPrintPhoneBookIfNothingFound(name);
        assert (getPhoneNumber1.get().equals("9815637483"));
    }

    @Test
    void findPhoneByNameAndPunishIfNothingFoundUsingStreams() {
        Optional<String> getPhoneNumber2 = phoneBookCrawler
                .findPhoneByNameAndPunishIfNothingFoundUsingStreams(name);
        assert (getPhoneNumber2.get().equals(phoneNumber));
    }

    @Test
    void findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams() {

        Optional<Object> getPhoneNumber3 = phoneBookCrawler
                .findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams(name);
        assert (getPhoneNumber3.get().equals("9815637483"));
    }

    @Test
    void findPhoneNumberByNameOrNameByPhoneNumber() {
        String phone = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber(name, phoneNumber);
        Assertions.assertEquals(phone, "9815637483");
    }

    @Test
    void findPhoneNumberByNameOrNameByPhoneNumber1() {
        name = "AYESHA";
        String getName = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber(name, phoneNumber);
        Assertions.assertEquals(getName, "7678979779");
    }
}
