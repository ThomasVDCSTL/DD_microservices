package com.DD_microservices.Gestion_game.model.Misc.Items;

import com.DD_microservices.Gestion_game.model.Misc.Personnage;

public class Potion extends Item {
    private String name ;
    private String type ;
    private int value;



    public Potion(String name, int value, String potion ) {
        this.name = name;
        this.value = value;
        this.type = potion;

    }
    public int interaction(Personnage player) {
        player.setLife(player.getVie() + value);
        return player.getLife();
    }

}