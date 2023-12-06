package com.DD_microservices.Gestion_game.web.controller;

import com.DD_microservices.Gestion_game.model.Game;
import com.DD_microservices.Gestion_game.model.Misc.Personnage;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GameController {
        public RestTemplate restTemplate = new RestTemplate();
        private Game game;
        private Personnage hero = new Personnage("Loulou", "Warrior", 10, 8);
        public GameController() {
            this.game = game;
        }

//        @GetMapping("/gestionPerso")
//        public Personnage getPerso() {
//            String url = "http://172.22.114.61:8080/personnage/2";
//            ResponseEntity<Personnage> response = restTemplate.getForEntity(url, Personnage.class);
//            return response.getBody();
//        }

        @Operation(summary = "affiche le menu original + résumé du joueur")
        @GetMapping(value = "/game")
        public String originalMenu(Personnage hero) {
            return "Bienvenue, " + hero.getName() + " tu es un " + hero.getType() + "tu as " + hero.getLife() +
                    "points de vie et " + hero.getStrength() +  "d'attaque. Que veux-tu faire ? Jouer(1) / Quitter(2) ";
        }

        @Operation(summary = "affiche tu quittes")
        @GetMapping(value = "/game/2")
        public String leave() {
            return "Tu quittes le jeu.";
        }

        @Operation(summary = "Affiche la dernière case, via le game")
        @GetMapping(value = "/game/1")
          public String startGame() {
            String url = "http://172.22.114.61:8080/personnage/3";
            ResponseEntity<Personnage> response = restTemplate.getForEntity(url, Personnage.class);
            game = new Game(response.getBody());
            return game.play(response.getBody());
        }


}
