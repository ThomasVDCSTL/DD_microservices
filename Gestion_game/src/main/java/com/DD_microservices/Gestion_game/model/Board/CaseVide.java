package com.DD_microservices.Gestion_game.model.Board;

import com.DD_microservices.Gestion_game.model.Misc.Hero;

public class CaseVide extends Tyle {

    public CaseVide(int id) {
        super(id);
    }
    public CaseVide() {
        super();
    }

    public int interaction(Hero hero) {
        System.out.println("Ouf !");
        return 0;
    }

    public String toString() {
        return "C'est une case vide.";
    }

}
