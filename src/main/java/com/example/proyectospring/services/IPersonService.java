package com.example.proyectospring.services;

import com.example.proyectospring.modelentity.Person;

import java.util.List;

public interface IPersonService {
    public Person savePerson(Person person);
    public void deletePerson(Long id);
    public Person updatePerson( Person person);
    public Person getPerson(Long id);
    public List<Person> getAllPeople();
}
