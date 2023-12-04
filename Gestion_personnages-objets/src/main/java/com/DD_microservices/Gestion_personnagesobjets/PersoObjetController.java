package com.DD_microservices.Gestion_personnagesobjets;


import com.DD_microservices.Gestion_personnagesobjets.DAO.PersoObjetDAO;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnages;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersoObjetController {

    private PersoObjetDAO persoDao;

    public PersoObjetController(PersoObjetDAO persoDao) {
        this.persoDao = persoDao;
    }


@GetMapping("/personnages/{id}")
    public Optional<Personnages> afficherUnPerso(@PathVariable int id) {
        return persoDao.findById(id);

    }

    @DeleteMapping("/personnages/{id}")
    public void deletePerso(@PathVariable ("id") int id){
        //return persoDao.delete(id);
}

@PostMapping("/personnage")
    public Personnages newPersonage( @RequestBody Personnages newPersonnage ){
        return persoDao.save(newPersonnage);
    }
@PutMapping("/personnage/{id}")
public Personnages modifiePerso(@PathVariable int id , @RequestBody Personnages personnageDetails) {
        Personnages updatePersonnage = persoDao.getById(id);
        updatePersonnage.setName(personnageDetails.getName());
        updatePersonnage.setType(personnageDetails.getType());
        updatePersonnage.setLife(personnageDetails.getLife());
        persoDao.save(updatePersonnage);
        ResponseEntity.ok(updatePersonnage);
        return updatePersonnage;
}

}
