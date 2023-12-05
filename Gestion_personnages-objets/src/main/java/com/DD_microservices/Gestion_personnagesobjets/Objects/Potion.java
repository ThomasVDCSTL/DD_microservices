package com.DD_microservices.Gestion_personnagesobjets.Objects;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;

public class Potion extends Item{
    private String name ;
    private String type ;
    private int value;



    public Potion(String name, int value, String potion ) {
        this.name = name;
        this.value = value;
        this.type = potion;

    }
    public void interaction(Personnage player) {
        player.setLife(player.getVie() + value);
    }

}
