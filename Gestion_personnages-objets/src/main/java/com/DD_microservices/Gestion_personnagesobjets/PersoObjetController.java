package com.DD_microservices.Gestion_personnagesobjets;


import com.DD_microservices.Gestion_personnagesobjets.DAO.EnemyDAO;
import com.DD_microservices.Gestion_personnagesobjets.DAO.PersonnageDAO;
import com.DD_microservices.Gestion_personnagesobjets.DAO.ObjetDAO;
import com.DD_microservices.Gestion_personnagesobjets.Objects.Item;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Enemy.Enemy;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Heros.Hero;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersoObjetController {

    private final PersonnageDAO persoDao;
    private final EnemyDAO enemyDao;
    private final ObjetDAO objetDao;

    public PersoObjetController(PersonnageDAO persoDao , EnemyDAO enemyDao, ObjetDAO objetDao) {
        this.persoDao = persoDao;
        this.enemyDao = enemyDao;
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
    public void newPersonage( @RequestBody Hero newPersonnage ){
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
public void modifiePerso(@RequestBody Hero personnageDetails) {
        persoDao.save(personnageDetails);
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
        return persoDao.findAll();

    }

    @GetMapping("/enemy/{id}")
    @Operation(summary = "On choisis un ennemie en particulier via son ID")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Ennemie trouvé",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Ennemie non trouvée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Ennemie non accessible",
                    content = @Content) })
    public Optional<Personnage> afficherUnEnemy(@PathVariable int id) {
        return persoDao.findById(id);

    }

    @DeleteMapping("/enemy/{id}")
    @Operation(summary = "On Supprime un ennemie en particulier via son ID")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Ennemie supprimer",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Ennemie non supprimer",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Ennemie non accessible",
                    content = @Content) })
    public void deleteEnemy(@PathVariable ("id") int id){
        persoDao.deleteById(id);
    }

    @PostMapping("/enemy")
    @Operation(summary = "Création d'un nouveau ennemie")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Personnage crée",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Personnage non crée",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Je ne sais pas",
                    content = @Content) })
    public void newEnemy( @RequestBody Enemy newEnemy ){
        persoDao.save(newEnemy);
    }
    @PutMapping("/enemy")
    @Operation(summary = "On modifie un personnage en particulier via son ID")
    @ApiResponses(value  = {
            @ApiResponse(responseCode = "200", description = "Personnage modifié",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),
            @ApiResponse(responseCode = "400" , description = "Personnage non modifier",
                    content =  @Content),
            @ApiResponse(responseCode = "404",description = "Personnage non accessible",
                    content = @Content) })
    public void modifieEnemy(@RequestBody Enemy personnageDetails) {
        persoDao.save(personnageDetails);
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
