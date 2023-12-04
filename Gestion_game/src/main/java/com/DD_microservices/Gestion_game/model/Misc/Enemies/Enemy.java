package com.DD_microservices.Gestion_game.model.Misc.Enemies;

import com.DD_microservices.Gestion_game.model.Board.CaseVide;
import com.DD_microservices.Gestion_game.model.Misc.Hero;

public class Enemy extends CaseVide {

    public Enemy(int id) {
        super(id);
    }

    public Enemy() {
        super();
    }

    public int interaction(Hero hero) {
        System.out.println("Pouf, je rencontre un ennemi!");
        return 0;
    }
}
