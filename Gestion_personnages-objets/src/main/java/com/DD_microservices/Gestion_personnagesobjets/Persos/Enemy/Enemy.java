package com.DD_microservices.Gestion_personnagesobjets.Persos.Enemy;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Fighter;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnages;

public abstract class Enemy extends Personnages implements Fighter {
    public Enemy(String name, String type, int life, int value) {
        super(name, type, life, value);
    }

    @Override
    public int attaque() {
        return this.value;
    }

    @Override
    public void encaisse(Fighter adversaire) {
        setLife(getLife() - adversaire.attaque());

    }

    @Override
    public int getVie() {
        return this.life;
    }

    @Override
    public boolean isAlive() {
        return this.life > 0;
    }


    public void interaction(Fighter player) {

        while (this.isAlive() && player.isAlive()) {
            this.encaisse(player);
            System.out.println("Vous avez attaqué l'ennemi");
            System.out.println("l'ennemi est-il vivant ?" + this.isAlive());
            if (this.isAlive()) {
                player.encaisse(this);
                System.out.println("l'ennemi vous attaque aiiie votre vie est desormais a : " + player.getVie());
                System.out.println("vie ennemi : " + this.getLife());
            } else {
                System.out.println("Combat gagné il vous reste : " + player.getVie() + " HP");
            }
        }
    }
}
