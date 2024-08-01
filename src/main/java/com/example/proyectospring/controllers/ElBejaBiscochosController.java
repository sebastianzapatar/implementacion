package com.example.proyectospring.controllers;

import com.example.proyectospring.modelentity.Postre;
import com.example.proyectospring.services.IPostreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController()
@RequestMapping("/api")
public class ElBejaBiscochosController {
    @Autowired
    private IPostreService postreService;
    @GetMapping("/elbejabiscochos")
    public List<Postre> getElBejaBiscochos() {
        System.out.println("getElBejaBiscochos");
        return postreService.findAll();
    }
    @PostMapping("/elbejabiscochos")
    public ResponseEntity<?> postElBejaBiscochos
            (@Valid @RequestBody Postre postre) {
        Map<String,String> response= new HashMap<>();
        try{
            postreService.save(postre);
        }
        catch (Exception e){

            response.put("message",e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
        return ResponseEntity.status(201).body(postre);
    }
    @DeleteMapping("/elbejabiscochos/{id}")
    public void deleteElBejaBiscochos
            (@PathVariable Long id) {
        postreService.deleteById(id);
    }
    @GetMapping("/elbejabiscochos/{id}")
    public ResponseEntity<?> getElBejaBiscochosById
            (@PathVariable Long id) {
        Postre w= postreService.findById(id);
        Map<String,String> response= new HashMap<>();
        if(w==null){
            response.put("message","dessert not found");
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.status(200).body(w);
    }
    @PutMapping("/elbejabiscochos/{id}")
    public Postre putElBejaBiscochos
            (@RequestBody Postre postre, @PathVariable Long id) {
        Postre w= postreService.findById(id);
        if(w==null){
            throw new RuntimeException("Postre no encontrado");
        }
        w.setName(postre.getName());
        w.setDescription(postre.getDescription());
        w.setPrice(postre.getPrice());
        return postreService.save(w);
    }
}
