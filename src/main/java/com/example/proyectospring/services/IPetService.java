package com.example.proyectospring.services;

import com.example.proyectospring.modelentity.Pet;

import java.util.List;

public interface IPetService {
    public Pet savePet(Pet pet);
    public void deletePet(Long id);
    public Pet updatePet( Pet pet);
    public Pet getPet(Long id);
    public List<Pet> getAllPets();

    public List<Pet> getPetsByOwnerId(Long ownerId);
}
