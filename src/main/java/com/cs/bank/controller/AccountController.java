package com.cs.bank.controller;

import com.cs.bank.entity.Person;
import com.cs.bank.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AccountController {

    @Autowired
    public PersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("persontest")
    public Person getPersonTest() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        return person;
    }

    @GetMapping("person/{personId}")
    public Person getPerson(@PathVariable Long personId) {
      return personService.getPerson(personId);
    }

    @PostMapping("person")
    public Person createAccount() {
        Date dateOfBirth = new Date();
       // Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        Person createdPerson = personService.createPerson(new Person());
        logger.info("Created person: {}", createdPerson);
        return createdPerson;
    }

    @GetMapping("personcreate")
    public void createAccountTest() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        Person createdPerson = personService.createPerson(person);
        logger.info("Created person: {}", createdPerson.getPersonId());

    }

    @PutMapping("person")
    public void updateAccount() {


    }

    @DeleteMapping("person")
    public void deleteAccount() {


    }
    @GetMapping("search")
    public void searchAccount(){

    }
}

