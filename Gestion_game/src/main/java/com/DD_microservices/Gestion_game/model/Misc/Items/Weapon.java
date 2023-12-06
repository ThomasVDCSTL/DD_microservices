package com.DD_microservices.Gestion_game.model.Misc.Items;

import com.DD_microservices.Gestion_game.model.Misc.Personnage;

public class Weapon extends Item{
    private String name;
    private int value ;

    public Weapon(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public int interaction(Personnage player) {
        if (player.getType().equalsIgnoreCase("Warrior")) {
            player.setArme(this);
        } else {
            System.out.println("c'est pour les guerriers pas toi ");
        }
        return player.getStrength();
    }

}
