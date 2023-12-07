package com.DD_microservices.Gestion_game.model;

import com.DD_microservices.Gestion_game.model.Misc.Personnage;
import com.DD_microservices.Gestion_game.model.Board.Board;
import io.swagger.v3.oas.annotations.Operation;

public class Game {

    private int position;
    private int dice;
    private Board board;
    private Personnage hero;

    public Game(Personnage hero) {
        this.hero = hero;
        position = hero.getPosition();
        board = new Board();
    }

    @Operation(summary = "lance le dé")
    public void tossDice() {
        dice = 1 + (int) (Math.random() * (6));
    }

    @Operation(summary = "avance du nombre de cases affiché par le dé")
    public void go() {
        tossDice();
        position += dice;
        if (position > 64) { position = 64; }
        System.out.println("Tu as fait " + dice + ", et tu es sur la case " + position + "/64");
    }

    @Operation(summary = "avance en bouclant jusque la case 64")
    public String play(Personnage hero) {

        System.out.println("Salut " + hero.getName() + "! Tu es un " + hero.getType() + ", tu as " + hero.getLife() + " points de vie et " + hero.getStrength() + " force d'attaque!");

        while (position < board.getSize()) {

            go();
            board.showCaseInfo(position - 1);

//            int interact = board.makeInteraction(position-1, hero);

//             interaction avec ennemy -> return niveau de vie de l'ennemi, si <= 0, ennemi mort
//            if (interact <= 0) {
//                board.eraseCase(position-1);
//            }

            if (position >= board.getSize()) {
                return "Gagné !";
            }

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
