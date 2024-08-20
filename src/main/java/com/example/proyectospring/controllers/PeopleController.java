package com.example.proyectospring.controllers;

import com.example.proyectospring.modelentity.Person;
import com.example.proyectospring.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    @Autowired
    private IPersonService personService;

    @GetMapping()
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
    @PostMapping()
    public Person savePerson(@RequestBody Person person){
        return personService.savePerson(person);
    }
}
