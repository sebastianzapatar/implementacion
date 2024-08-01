package com.example.proyectospring.services;

import com.example.proyectospring.dao.IPostreDAO;
import com.example.proyectospring.modelentity.Postre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostreService implements IPostreService{

    @Autowired
    private IPostreDAO postreDAO;
    @Override
    public List<Postre> findAll() {
        return postreDAO.findAll();
    }

    @Override
    public Postre save(Postre postre) {
        return postreDAO.save(postre);
    }

    @Override
    public Postre findById(Long id) {
        return postreDAO.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        postreDAO.deleteById(id);
    }
}
