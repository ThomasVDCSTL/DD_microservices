package com.DD_microservices.Gestion_personnagesobjets.Persos.Heros;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Fighter;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnages;

public abstract class Hero extends Personnages implements Fighter {


    public Hero(String name, String type, int life, int value) {
        super(name, type, life, value);
    }

    /* Méthode a definir ensemble
@todo interaction de combat
 */
    @Override
    public int attaque() {

        return value;
    }

    @Override
    public void encaisse(Fighter adversaire) { setLife((getVie()- adversaire.attaque()));

    }

    @Override
    public int getVie() {
        return this.life;
    }

    @Override
    public boolean isAlive() {
        return this.life > 0 ;
    }
}
