package com.example.demo.service.Impl;

import com.example.demo.entity.Person;
import com.example.demo.exception.DataNotFound;
import com.example.demo.exception.InvalidData;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void savePerson(Person person) {
        if (person == null) {
            throw new InvalidData("invalid data");
        }
        Person person1 = personRepository.getPersonById(person.getId());
        if (person1 == null){
            personRepository.save(person);
        }else {
            personRepository.deleteById(person.getId());
            personRepository.save(person);
        }
    }

    @Override
    public void deletePerson(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
        }else{
            throw new DataNotFound(id);
        }
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
