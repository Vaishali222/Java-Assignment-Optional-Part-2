package com.knoldus;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Entity class - PhoneBook.
 */

public class PhoneBook {

    /**
     * Using logger.
     */
    private final Logger logger = LogManager.getLogger(PhoneBookCrawler.class);

    /**
     * Map to store names and phone numbers.
     */
    private final Map<String, String> userPhoneBook =
            Stream.of(new Object[][]{
                    {"VAISHALI", "9815637483"},
                    {"AYESHA", "7678979779"},
                    {"RITIKA", "9899793737"},
                    {"ANJALI", "8678983362"},

            }).collect(Collectors.toMap(data ->
                    (String) data[0], data -> (String) data[1]));

    /**
     * getPhoneBook method.
     *
     * @return phonebook contents.
     */
    public Map<String, String> getPhoneBook() {

        return userPhoneBook;
    }

    //Exercise 4

    /**
     * Overridden toString() for PhoneBook details.
     *
     * @return phoneBook details
     */
    @Override
    public String toString() {

        logger.info("Hello Vaishali");
        return "Phone Book having name and phone number : " + userPhoneBook;
    }
    //Exercise 1

    /**
     * Method to find phone number using name.
     *
     * @param name name
     * @return phone number corresponding to passed name
     */

    public Optional<String> findPhoneByName(final String name) {
        try {
            return (userPhoneBook.containsKey(name))
                    ? Optional.of(userPhoneBook.get(name)) : Optional.empty();
        } catch (Exception e) {
            logger.info(e);
        }
        return Optional.empty();
    }
    //Part of Exercise 7

    /**
     * Method to find phone number using name.
     *
     * @param phoneNum stores phone number
     * @return name corresponding to passed phoneNumber
     */

    public Optional<String> findNameByPhoneNumber(final String phoneNum) {
        try {
            for (Map.Entry<String, String>
                    phoneDir : userPhoneBook.entrySet()) {
                if (phoneDir.getValue().equals(phoneNum)) {
                    return Optional.of(phoneDir.getKey());
                }
            }
        } catch (Exception e) {
            logger.info("Exception" + e);
        }
        return Optional.empty();
    }
}
