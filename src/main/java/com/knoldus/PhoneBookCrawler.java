package com.knoldus;

import java.util.Map;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * PhoneBookCrawler class has all the
 * functionality implementing PhoneBook Class.
 */
public class PhoneBookCrawler {

    /**
     * Using logger.
     */
    private final Logger logger = LogManager.getLogger(PhoneBookCrawler.class);

    /**
     * Method fetches phone number by name.
     *
     * @param name stores names
     * @return phone number if found else prints punish.
     */
    //Exercise 2
    public Optional<String> findPhoneByNameAndPunishIfNothingFound(final String name) {

        PhoneBook phoneBook = new PhoneBook();
        Optional<String> phoneResult = phoneBook.findPhoneByName(name);

        return phoneResult.map(Optional::of).orElseGet(()
                -> Optional.of("punish"));
    }

    /**
     * Returns phone number if passed name exists.
     * Prints phonebook if passed record not found
     *
     * @param name takes name as a parameter.
     * @return phone number if found, else prints whole phone book.
     */
    public Optional<Object> findPhoneByNameAndPrintPhoneBookIfNothingFound(final String name) {
        PhoneBook phoneBook = new PhoneBook();
        try {
            Optional<String> phoneResult = phoneBook.findPhoneByName(name);

            return phoneResult.<Optional<Object>>map(Optional::of).orElseGet(()
                    -> Optional.of(phoneBook));
        } catch (Exception e) {
            logger.info(e);
        }
        return Optional.empty();
    }

    /**
     * Stream implementation.
     *
     * @param name stores names
     * @return phone number else prints punish
     */
    public Optional<String>
    findPhoneByNameAndPunishIfNothingFoundUsingStreams(final String name) {

        PhoneBook phoneBook = new PhoneBook();
        try {
            Optional<String> getResult = phoneBook.getPhoneBook()
                    .entrySet().stream()
                    .filter(p -> name.equals(p.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst();
            return getResult.map(Optional::of).orElseGet(()
                    -> Optional.of("punish"));
        } catch (Exception e) {
            logger.info(e);
        }
        return Optional.empty();
    }

    /**
     * Returns phone number when name is given.
     * Prints phonebook if no records found.
     *
     * @param name stores names
     * @return phone number else prints phonebook contents
     */
    public Optional<Object>
    findPhoneByNameAndPrintPhoneBookIfNothingFoundStreams(final
                                                          String name) {
        PhoneBook phoneBook = new PhoneBook();
        try {
            Optional<String> getResult = phoneBook
                    .getPhoneBook().entrySet().stream()
                    .filter(p -> name.equals(p.getKey()))
                    .map(Map.Entry::getValue)
                    .findFirst();
            return getResult.<Optional<Object>>map(Optional::of).orElseGet(()
                    -> Optional.of(phoneBook));
        } catch (Exception e) {
            logger.info(e);
        }
        return Optional.empty();
    }

    /**
     * This method finds phone number if name is given and vice versa.
     *
     * @param name        stores name
     * @param phoneNumber stores number
     * @return phone number
     */
    public String
    findPhoneNumberByNameOrNameByPhoneNumber(final String name,
                                             final String phoneNumber) {
        PhoneBook phoneBook = new PhoneBook();
        final String message = "No such record exist!";

        if (phoneBook.findPhoneByName(name).isPresent()) {
            return phoneBook.findPhoneByName(name).get();
        } else if (phoneBook.findNameByPhoneNumber(phoneNumber)
                .isPresent()) {
            return phoneBook.findNameByPhoneNumber(phoneNumber).get();
        } else {
            return message;
        }
    }
}
