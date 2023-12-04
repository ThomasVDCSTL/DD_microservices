package com.DD_microservices.Gestion_sauvegardes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@Repository
public class SavesController {
    private final SavesDAO savesDAO;
    private RestTemplate restTemplate = new RestTemplate();

    public SavesController(SavesDAO savesDAO) {
        this.savesDAO = savesDAO;
    }

    @GetMapping("/save")
    public List<Save> getSaves(){
        List<Save> res = savesDAO.findAll();
        System.out.println(res);
        return res;
        //return res.toArray(new Save[res.size()]);
    }

    @Operation(summary = "Renvoie la liste des sauvegardes", description = "va chercher la liste des sauvegardes du joueur dont l'id est renseigné dans le path")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sauvegardes renvoyées ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Save.class))}),
            @ApiResponse(responseCode = "400", description = "sauvegardes non renvoyées, le format n'est pas bon",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "sauvegardes non renvoyées car elles n'existent pas",
                    content = @Content)})
    @GetMapping("/save/{id}")
    public List<Save> getSavesList(@PathVariable Integer id){
        return savesDAO.findAllByPlayerOrderByDate(id);
    }
    @Operation(summary = "Renvoie la sauvegarde sélectionnée", description = "va chercher la sauvegarde du joueur dont les id sont renseignés dans le path")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sauvegarde renvoyée ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Save.class))}),
            @ApiResponse(responseCode = "400", description = "sauvegarde non renvoyée, le format n'est pas bon",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "sauvegarde non renvoyée car elle n'existe pas",
                    content = @Content)})
    @GetMapping("/save/{id}/{save}")
    public Save getSave(@PathVariable(value = "id") int id_joueur,@PathVariable(value = "save") int id_save){
        return savesDAO.findByPlayerAndSaveOrderByDate(id_joueur,id_save);
    }

    @Operation(summary = "Créé une sauvegarde", description = "Créé une sauvegarde grace à l'objet dans le body")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sauvegarde renvoyée ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Save.class))}),
            @ApiResponse(responseCode = "400", description = "sauvegarde non renvoyée, le format n'est pas bon",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "sauvegarde non renvoyée car elle n'existe pas",
                    content = @Content)})
    @PostMapping("/save")
    public void saveGame(@RequestBody Save partie){
        savesDAO.save(partie);
    }

    @Operation(summary = "Renvoie la sauvegarde sélectionnée", description = "va chercher la sauvegarde du joueur dont les id sont renseignés dans le path")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sauvegarde renvoyée ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Save.class))}),
            @ApiResponse(responseCode = "400", description = "sauvegarde non renvoyée, le format n'est pas bon",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "sauvegarde non renvoyée car elle n'existe pas",
                    content = @Content)})
    @DeleteMapping("/save/{game}")
    public void deleteSave(@PathVariable(value = "game") int game){
        savesDAO.deleteById(game);
    }


    @Operation(summary = "Renvoie la sauvegarde sélectionnée", description = "va chercher la sauvegarde du joueur dont les id sont renseignés dans le path")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "sauvegarde renvoyée ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Save.class))}),
            @ApiResponse(responseCode = "400", description = "sauvegarde non renvoyée, le format n'est pas bon",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "sauvegarde non renvoyée car elle n'existe pas",
                    content = @Content)})
    @PutMapping("/save")
    public void updateSave(@RequestBody Save game){
        savesDAO.save(game);
    }

}
