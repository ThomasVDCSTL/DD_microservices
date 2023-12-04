package com.DD_microservices.Gestion_personnagesobjets;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersoObjetController {

@GetMapping("/personnages")
    public String listPersonnages(){
    return "perso";
}
@GetMapping("/personnages/{id}")
    public String afficherUnPerso(@PathVariable int id){
    return " Vous avez demandé le personnage avec L'id " +id;
}
@PutMapping()

}
