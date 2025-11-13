package com.cs.bank.controller;

import com.cs.bank.entity.Person;
import com.cs.bank.service.PersonService;
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

    @PostMapping("person")
    public Person createAccount() {
        Date dateOfBirth = new Date();
       // Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        Person createdPerson = personService.createPerson(new Person());
        logger.info("Created person: {}", createdPerson);
        return createdPerson;
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

@GetMapping("search")
public List<Person> searchAccount(){
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
//Test methods
    @GetMapping("persontest")
    public Person getPersonTest() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        return person;
    }

    @PostMapping("personcreatetest")
    public void createAccountTest() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        //Person person1 = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        Person createdPerson = personService.createPerson(person);
        logger.info("Created person: {}", createdPerson.getPersonId());

    }

    @PostMapping("personcreatetest1")
    public void createAccountTest1() {
        Date dateOfBirth = new Date();
        Person person = new Person("Doe", "John", dateOfBirth, "john.doe@example.com", "1234567890", "123 Main St", "1234567890");
        Person person1 = new Person("vinod", "narra", dateOfBirth, "vinod.narra@example.com", "1122334556", "234 Main St", "1234567890");
        Person person2 = new Person("Alice", "Smith", dateOfBirth, "alice.smith@example.com", "9988776655", "345 Main St", "0987654321");
        java.util.List<Person> persons = java.util.Arrays.asList(person, person1, person2);
        // create the additional persons now (the original 'person' will be created by the existing call below)
        
        for (Person p : persons) {
            Person createdPerson = personService.createPerson(p);
            logger.info("Created person: {}", createdPerson.getPersonId()); 
    }
}
}