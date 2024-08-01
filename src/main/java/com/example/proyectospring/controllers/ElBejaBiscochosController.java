package com.example.proyectospring.controllers;

import com.example.proyectospring.modelentity.Postre;
import com.example.proyectospring.services.IPostreService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Postre postElBejaBiscochos
            (@RequestBody Postre postre) {
        System.out.println("postElBejaBiscochos");
        return postreService.save(postre);
    }
    @DeleteMapping("/elbejabiscochos/{id}")
    public void deleteElBejaBiscochos
            (@PathVariable Long id) {
        postreService.deleteById(id);
    }
    @GetMapping("/elbejabiscochos/{id}")
    public Postre getElBejaBiscochosById
            (@PathVariable Long id) {
        Postre w= postreService.findById(id);
        if(w==null){
            throw new RuntimeException("Postre no encontrado");
        }
        return w;
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
