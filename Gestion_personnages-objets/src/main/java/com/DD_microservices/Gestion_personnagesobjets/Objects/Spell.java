package com.DD_microservices.Gestion_personnagesobjets.Objects;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;

public class Spell extends Item{
    private String name;

    private String type;

    public Spell( String type, String name, int forceAttack) {
        super( type, name, forceAttack);
        this.name = name;

        this.type = type;
    }
    public void interaction(Personnage player) {
        if (player.getType().equalsIgnoreCase("Wizard")) {
        player.setArme(this);
        } else {
            System.out.println("Ceci n'est pas adapté a un Moldu");
        }
    }
}
