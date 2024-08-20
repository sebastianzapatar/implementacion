package com.example.proyectospring.services;

import com.example.proyectospring.dao.IPeopleDao;
import com.example.proyectospring.modelentity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPeopleDao peopleDao;
    @Override
    public Person savePerson(Person person) {
        // TODO Auto-generated method stub
        return peopleDao.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        // TODO Auto-generated method stub
        peopleDao.deleteById(id);
    }

    @Override
    public Person updatePerson(Person person) {
        // TODO Auto-generated method stub
        return peopleDao.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        // TODO Auto-generated method stub
       return peopleDao.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPeople() {
        // TODO Auto-generated method stub
        return peopleDao.findAll();
    }
}
