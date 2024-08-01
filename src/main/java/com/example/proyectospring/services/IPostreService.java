package com.example.proyectospring.services;

import com.example.proyectospring.modelentity.Postre;
import java.util.*;
public interface IPostreService {
    public List<Postre> findAll();
    public Postre save(Postre postre);

    public Postre findById(Long id);

    public void deleteById(Long id);
}
