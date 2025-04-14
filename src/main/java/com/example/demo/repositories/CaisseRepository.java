package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Caisse;

public interface CaisseRepository extends JpaRepository<Caisse, Long> {
 // Si tu as un champ dateCreation
 Caisse findTopByOrderByDateDesc();


}
