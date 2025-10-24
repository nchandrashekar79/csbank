package com.cs.bank.service;

import com.cs.bank.entity.Person;
import com.cs.bank.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPerson(Long personId) {
        return personRepository.findById(personId).orElse(null);
    }
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
    public void deletePerson(Long personId) {
        personRepository.deleteById(personId);
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.findAll();
    }


}
