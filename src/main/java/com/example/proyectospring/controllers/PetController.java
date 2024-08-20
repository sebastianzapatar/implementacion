package com.example.proyectospring.controllers;

import com.example.proyectospring.modelentity.Person;
import com.example.proyectospring.modelentity.Pet;
import com.example.proyectospring.services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private IPetService petService;

    @GetMapping()
    public List<Pet> getAllPets(){
        return petService.getAllPets();
    }
    @PostMapping()
    public Pet savePet(@RequestBody Pet pet){
        return petService.savePet(pet);
    }
    @GetMapping("/people/{id}")
    public List<Pet> getPetsByOwnerId(@PathVariable Long id){
        return petService.getPetsByOwnerId(id);
    }

}
