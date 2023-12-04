package com.DD_microservices.Gestion_joueurs.Controller;

import com.DD_microservices.Gestion_joueurs.Dao.joueurDao;
import  com.DD_microservices.Gestion_joueurs.Model.JoueurData;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class controllerJoueur {

    private joueurDao joueur_Dao;

    public controllerJoueur(joueurDao joueur_Dao) {
        this.joueur_Dao = joueur_Dao;
    }
//        @RequestMapping(value="/Joueurs", method = RequestMethod.GET)
//
//    public MappingJacksonValue joueurs() {
//        Iterable<JoueurData> joueurs = joueur_Dao.findAllJoueur();
//
//        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("id");
//
//        FilterProvider listOfFilters = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);
//
//        MappingJacksonValue joueursFiltres = new MappingJacksonValue(joueurs);
//
//        joueursFiltres.setFilters(listOfFilters);
//
//        return joueursFiltres;
//
//    }

    @GetMapping("/Joueurs")
    public List<JoueurData> afficherJoueurs() {
        return joueur_Dao.findAll();
    }
    @GetMapping(value="/Joueurs/{id}")
    public Optional<JoueurData> afficherJoueur(@PathVariable int id) {
        return joueur_Dao.findById(id);
    }

    @PutMapping("/Joueurs")
    public void modifierJoueur(@RequestBody JoueurData joueur) {
        joueur_Dao.save(joueur);
    }

    @PostMapping("/Joueurs")
    public void ajouterJoueur(@RequestBody JoueurData joueur) {
        joueur_Dao.save(joueur);
    }

    @DeleteMapping("/Joueurs/{id}")
    public void deleteJoueur(@PathVariable int id) {
        joueur_Dao.deleteById(id);
    }











}
