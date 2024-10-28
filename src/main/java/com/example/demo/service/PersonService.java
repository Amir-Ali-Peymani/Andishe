package com.example.demo.service;

import com.example.demo.entity.Person;

import java.util.List;

public interface PersonService {

    void savePerson(Person person);

    void deletePerson(Long id);

    List<Person> getAllPersons();

    Person getPersonById(Long id);
}
