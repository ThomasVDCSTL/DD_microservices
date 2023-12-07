package com.dd_microservices.menu.ClassesObjets;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;

public class Weapon extends Item{
   private String name;
private int value ;

   public Weapon(String name, int value) {
      this.name = name;
      this.value = value;
   }
public void interaction(Personnage player) {
        if (player.getType().equalsIgnoreCase("Warrior")) {
            player.setArme(this);
        } else {
            System.out.println("c'est pour les guerrier pas toi ");
        }
    }

}
