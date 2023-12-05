package com.DD_microservices.Gestion_personnagesobjets;


import com.DD_microservices.Gestion_personnagesobjets.DAO.PersonnageDAO;
import com.DD_microservices.Gestion_personnagesobjets.DAO.ObjetDAO;
import com.DD_microservices.Gestion_personnagesobjets.Objects.Item;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersoObjetController {

    private final PersonnageDAO persoDao;
    private final ObjetDAO objetDao;

    public PersoObjetController(PersonnageDAO persoDao, ObjetDAO objetDao) {
        this.persoDao = persoDao;
        this.objetDao = objetDao;
    }

    @GetMapping("/personnage")
    @Operation(summary = "On déroule la liste des perso ")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Personnage trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Personnage non trouvée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Personnage non accessible",
                    content = @Content) })
    public List<Personnage> afficherListPerso() {
        return persoDao.findAll();
    }

@GetMapping("/personnage/{id}")
@Operation(summary = "On choisis un personnage en particulier via son ID")
@ApiResponses(value  = {
        @ApiResponse(responseCode = "200", description = "Personnage trouvé",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = Personnage.class)) }),
        @ApiResponse(responseCode = "400" , description = "Personnage non trouvée",
                content =  @Content),
        @ApiResponse(responseCode = "404",description = "Personnage non accessible",
                content = @Content) })
    public Optional<Personnage> afficherUnPerso(@PathVariable int id) {
        return persoDao.findById(id);
    }

    @DeleteMapping("/personnage/{id}")
    @Operation(summary = "On Supprime un personnage en particulier via son ID")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Personnage supprimer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Personnage non supprimer",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Personnage non accessible",
                    content = @Content) })
    public void deletePerso(@PathVariable ("id") int id){
         persoDao.deleteById(id);
}

@PostMapping("/personnage")
@Operation(summary = "Création d'un nouveau personnage")
@ApiResponses(value  = {
        @ApiResponse(responseCode = "200", description = "Personnage crée",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = Personnage.class)) }),
        @ApiResponse(responseCode = "400" , description = "Personnage non crée",
                content =  @Content),
        @ApiResponse(responseCode = "404",description = "Je ne sais pas",
                content = @Content) })
    public void newPersonage( @RequestBody Personnage newPersonnage ){
        persoDao.save(newPersonnage);
    }
@PutMapping("/personnage")
@Operation(summary = "On modifie un personnage en particulier via son ID")
@ApiResponses(value  = {
        @ApiResponse(responseCode = "200", description = "Personnage modifié",
                content = {@Content(mediaType = "application/json",
                        schema = @Schema(implementation = Personnage.class)) }),
        @ApiResponse(responseCode = "400" , description = "Personnage non modifier",
                content =  @Content),
        @ApiResponse(responseCode = "404",description = "Personnage non accessible",
                content = @Content) })
public void modifiePerso(@RequestBody Personnage personnageDetails) {
        persoDao.save(personnageDetails);
}

    //---------------------------------------------------HERO-------------------------------------------------------------------
    @GetMapping("/hero")
    @Operation(summary = "On déroule la liste des hero ")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "enemy trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Enemy non trouvée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Enemy non accessible",
                    content = @Content) })
    public List<Personnage> afficherListHero() {
        String[] heroTypes =  new String[] { "Warrior", "Wizard" };
        return persoDao.findByTypeIn(heroTypes);

    }

    //---------------------------------------------------ENEMY-------------------------------------------------------------------
    @GetMapping("/enemy")
    @Operation(summary = "On déroule la liste des enemy ")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "enemy trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Enemy non trouvée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Enemy non accessible",
                    content = @Content) })
    public List<Personnage> afficherListEnemy() {
        String[] enemyTypes =  new String[] { "Dragon", "Goblin","Sorcier" };
        return persoDao.findByTypeIn(enemyTypes);

    }

//---------------------------------------------------Item-------------------------------------------------------------------

    @GetMapping("/objets")
    @Operation(summary = "On déroule la liste des objets ")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Objets trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Objet non trouvée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Objet non accessible",
                    content = @Content) })
    public List<Item> afficherListObjet() {
        return objetDao.findAll();

    }

    @GetMapping("/objet/{id}")
    @Operation(summary = "On choisis un objet en particulier via son ID")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Objet trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Objet non trouvée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Objet non accessible",
                    content = @Content) })
    public Optional<Item> afficherUnObjet(@PathVariable int id) {
        return objetDao.findById(id);

    }

    @DeleteMapping("/objet/{id}")
    @Operation(summary = "On Supprime un objet en particulier via son ID")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Objet supprimer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Objet non supprimer",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Objet non accessible",
                    content = @Content) })
    public void deleteObjet(@PathVariable ("id") int id){
        objetDao.deleteById(id);
    }

    @PostMapping("/objet")
    @Operation(summary = "Création d'un nouveau objet")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Objet crée",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Objet non crée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Je ne sais pas",
                    content = @Content) })
    public void newObjet( @RequestBody Item newItem ){
        objetDao.save(newItem);
    }
    @PutMapping("/objet")
    @Operation(summary = "On modifie un objet en particulier via son ID")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Objet modifié",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Objet non modifier",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Objet non accessible",
                    content = @Content) })
    public void modifieObjet(@RequestBody Item itemDetails) {
       objetDao.save(itemDetails);
    }
}
