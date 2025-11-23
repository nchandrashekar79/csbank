package com.cs.bank.controller;

import com.cs.bank.entity.Person;
import com.cs.bank.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestController {

    @Autowired
    public PersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);


    @GetMapping({"test", "hello"})
    public String test(){
        return "Hello World";
    }

    //Test methods

    @GetMapping("personcreatetest")
    public void createAccountTest() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        //Person person1 = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        Person createdPerson = personService.createPerson(person);
        logger.info("Created person: {}", createdPerson.getPersonId());

    }
}

