package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Caisse;
import com.example.demo.services.CaisseService;

@RestController
@CrossOrigin(origins = {
    "http://localhost:3000",
    "https://dubai-jade.vercel.app"
})
// @CrossOrigin(origins = "http://localhost:3000")
public class CaisseController {
    @Autowired
    public CaisseService caisseService;
    
    @PostMapping("/caisse")
    public Caisse createCaisse(@RequestBody Caisse caisse) {
        return caisseService.saveCaisse(caisse);
    }
    @GetMapping("/caisse")
    public List<Caisse> listCaisse() {
        return caisseService.listCaisse();
    }
    @GetMapping("/last")
    public ResponseEntity<Caisse> getLastCaisse() {
        Caisse lastCaisse = caisseService.getLastCaisse();
        return ResponseEntity.ok(lastCaisse);
    }
    @GetMapping("/caisse/{id}")
    public ResponseEntity<Caisse> getCaisseById(@PathVariable("id") Long id) {
        Caisse caisse = caisseService.OneCaisse(id);
        return ResponseEntity.ok(caisse);
    }
}
