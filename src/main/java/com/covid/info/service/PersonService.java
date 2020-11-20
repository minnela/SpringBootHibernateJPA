package com.covid.info.service;

import com.covid.info.domain.Person;

import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    List<Person> getAllPatients();
    Person getPersonById(int id);
    void updatePersonCovidInfo(int id);
    void deletePersonById(int id);


}
