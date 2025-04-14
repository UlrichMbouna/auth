package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Caisse;
import com.example.demo.repositories.CaisseRepository;

@Service
public class CaisseService {

    @Autowired
    private CaisseRepository caisseRepository;

    public Caisse saveCaisse(Caisse caisse) {
        return caisseRepository.save(caisse);
    }
    
    public List<Caisse> listCaisse() {
        return caisseRepository.findAll();
    }
      // Récupérer la dernière caisse créée
      public Caisse getLastCaisse() {
        return caisseRepository.findTopByOrderByDateDesc();
    }
    public Caisse OneCaisse(Long id){
            return caisseRepository.findById(id).orElseThrow(() -> new RuntimeException("Caisse not found with id: " + id));
    }
}
