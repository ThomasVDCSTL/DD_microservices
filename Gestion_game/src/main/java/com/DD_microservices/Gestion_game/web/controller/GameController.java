package com.DD_microservices.Gestion_game.web.controller;

import com.DD_microservices.Gestion_game.model.Game;
import com.DD_microservices.Gestion_game.model.Misc.Personnage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
        private Game game;
        private Personnage hero = new Personnage("Loulou", "Warrior", 10, 8);
        public GameController() {
            this.game = game;
        }

        @GetMapping(value = "/game")
        public String originalMenu() {
            return "Bienvenue, tu es un " + "???, " + "tu as " + "??? " +
                    "de points de vie et " + "??? " +  "d'attaque. Que veux-tu faire ? Jouer(1) / Quitter(2) ";
        }
        @GetMapping(value = "/game/2")
        public String leave() {
            return "Tu quittes le jeu.";
        }

        @GetMapping(value = "/game/1")
          public String startGame() {
            game = new Game(hero);
            return game.play(hero);
        }


}
