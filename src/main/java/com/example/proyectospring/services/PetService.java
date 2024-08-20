package com.example.proyectospring.services;

import com.example.proyectospring.dao.IPetDao;
import com.example.proyectospring.modelentity.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements IPetService{

    @Autowired
    private IPetDao petDao;
    @Override
    public Pet savePet(Pet pet) {
        System.out.println(pet);
        return petDao.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petDao.deleteById(id);
    }

    @Override
    public Pet updatePet(Pet pet) {
        return petDao.save(pet);
    }

    @Override
    public Pet getPet(Long id) {
        return petDao.findById(id).orElse(null);
    }

    @Override
    public List<Pet> getAllPets() {
        return petDao.findAll();
    }
    @Override
    public List<Pet> getPetsByOwnerId(Long ownerId) {
        return petDao.findPetByOwnerId(ownerId);
    }
}
