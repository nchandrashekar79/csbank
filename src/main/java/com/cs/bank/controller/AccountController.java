package com.cs.bank.controller;

import com.cs.bank.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AccountController {

    @GetMapping("persontest")
    public Person getPersonTest() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        return person;
    }

    @GetMapping("person")
    public Person getPerson() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        return person;
    }

    @PostMapping("person")
    public void createAccount() {


    }

    @PutMapping("person")
    public void updateAccount() {


    }
}

