package com.example.proyectospring.controllers;

import com.example.proyectospring.modelentity.Postre;
import com.example.proyectospring.services.IPostreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
