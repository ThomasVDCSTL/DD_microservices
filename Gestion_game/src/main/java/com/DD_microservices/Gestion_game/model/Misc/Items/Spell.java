package com.DD_microservices.Gestion_game.model.Misc.Items;

import com.DD_microservices.Gestion_game.model.Misc.Personnage;

public class Spell extends Item {
    private String name;

    private String type;

    public Spell( String type, String name, int forceAttack) {
        super( type, name, forceAttack);
        this.name = name;

        this.type = type;
    }
    public int interaction(Personnage player) {
        if (player.getType().equalsIgnoreCase("Wizard")) {
            player.setArme(this);
        } else {
            System.out.println("Ceci n'est pas adapté a un Moldu");
        }
        return player.getStrength();
    }

    @Override
    public String toString() {
        return "Spell{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}