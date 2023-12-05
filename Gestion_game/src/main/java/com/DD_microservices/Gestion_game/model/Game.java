package com.DD_microservices.Gestion_game.model;

import com.DD_microservices.Gestion_game.model.Misc.Hero;
import com.DD_microservices.Gestion_game.model.Board.Board;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Repository;

public class Game {

    private int position;
    private int dice;
    private Board board;
    private Hero hero;

    public Game(Hero hero) {
        this.hero = hero;
        position = hero.getPosition();
        board = new Board();
    }

    public void tossDice() {
        dice = 1 + (int) (Math.random() * (6));
    }

    public void go() {
        tossDice();
        position += dice;
        if (position > 64) { position = 64; }
//            return "Tu as fait " + dice + ", et tu es sur la case " + position + "/64";
    }

    public String play(Hero hero) {

        while (position < board.getSize()) {

            go();
//            board.showCaseInfo(position - 1);

            int interact = board.makeInteraction(position-1, hero);

//             interaction avec ennemy -> return niveau de vie de l'ennemi, si <= 0, ennemi mort
            if (interact <= 0) {
                board.eraseCase(position-1);
            }

//            if (position >= board.getSize()) {
//                return "Gagné !";
//            }

//          Si le niveau de vie du heros est <0

//            if (hero.getLifeLevel() < 0) {
//                hero.setLifeLevel(0);
//                System.out.println("Tu es mort...");
//                break;
//            }

//            Voir comment on interagit avec le joueur

//            System.out.println("Tu veux passer au tour suivant(1) ou afficher tes stats(2) ?");
//            String statChoice = scanner.nextLine();// Read user input
//            if (statChoice.equals("2")) {
//                System.out.println("Points de vie: " + perso.getLifeLevel());
//                System.out.println("Points d'attaque: " + perso.getForceAttaque());
//            }
        }
        return "tu es sur la case " + position;
    }

}
