package com.DD_microservices.Gestion_game.web.controller;

import com.DD_microservices.Gestion_game.model.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
        private Game game;
        public GameController() {
            this.game = game;
        }

        @GetMapping(value = "/game")
        public String originalMenu() {
            return "Bienvenue, tu es un " + "???, " + "tu as " + "??? " +
                    "de points de vie et " + "??? " +  "d'attaque. Que veux-tu faire ? Jouer(1) / Quitter(2) ";
        }

//        @PostMapping(value = "game/{choix1}")
//        public int choice1(@pathvariable?) {
//            return 1 ou 2, selon le choix
//        }
}
