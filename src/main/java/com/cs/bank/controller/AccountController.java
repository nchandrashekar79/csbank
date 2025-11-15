package com.cs.bank.controller;

import com.cs.bank.entity.Person;
import com.cs.bank.service.PersonService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    public PersonService personService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("person/{personId}")
    public Person getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }
    @GetMapping("persons")
    public List<Person> getAllPersons() {
        return (List<Person>) personService.getAllPersons();
    }


    @PutMapping("person/{id}")
    public ResponseEntity<Person> updateAccount(@PathVariable Long id, @RequestBody Person updatedPerson) {
        Person existing = personService.getPerson(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        updatedPerson.setPersonId(id);
        personService.updatePerson(updatedPerson);
        logger.info("Updated person: {}", updatedPerson);
        return ResponseEntity.ok(updatedPerson);

    }

    @PutMapping("persons/{id}")
    public void updatedPersonDetails(Person updatedPerson) {
        personService.updatePerson(updatedPerson);
        logger.info("Updated person: {}", updatedPerson);
    }


    @DeleteMapping("person/{id}")
    public void deleteAccount(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping("person/search")
    public List<Person> searchAccount() {
        List<Person> getALLpersonsDetails = (List<Person>) personService.getAllPersons();
        if (getALLpersonsDetails != null && !getALLpersonsDetails.isEmpty()) {
            for (Person person : getALLpersonsDetails) {
                logger.info("Person Details: {}", person);
            }
        } else {
            logger.info("No person records found.");
        }
        return getALLpersonsDetails;
    }



    @PostMapping(value = "persons", produces = "application/json")
    public void createPersons(@RequestBody @Valid List<Person> persons) {
      personService.saveAll(persons);

    }


    @PostMapping("/person")
    public Person savePerson(@RequestBody  @Valid Person personDto) {
        return personService.createPerson(personDto);
    }
}