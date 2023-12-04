package com.DD_microservices.Gestion_game.model.Misc.Items;

import com.DD_microservices.Gestion_game.model.Board.CaseVide;
import com.DD_microservices.Gestion_game.model.Misc.Hero;

public class Item extends CaseVide {

    public Item(int id) {
        super(id);
    }

    public Item() {
        super();
    }
    public int interaction(Hero hero) {
        System.out.println("Pouf, je vois un objet par terre !");
        return 0;
    }
}
