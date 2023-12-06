package com.DD_microservices.Gestion_game.model.Board;

import com.DD_microservices.Gestion_game.model.Misc.Personnage;

public class CaseVide extends Tyle {

    public CaseVide(int id) {
        super(id);
    }
    public CaseVide() {
        super();
    }

    public int interaction(Personnage hero) {
//        System.out.println("Ouf !");
        return 0;
    }

    public String toString() {
        return "C'est une case vide.";
    }

}
