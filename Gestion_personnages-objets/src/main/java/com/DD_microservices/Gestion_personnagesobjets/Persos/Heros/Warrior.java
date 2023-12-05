package com.DD_microservices.Gestion_personnagesobjets.Persos.Heros;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;

public class Warrior extends Personnage {

    public Warrior(String name, String type, int vie, int forceAttack) {
     super(name, "Warrior", 5,10);
    }

    @Override
    public String toString() {
        return
                "--             Player Info             --" +
                        "\n             Class : " + "Guerrier" +
                        "\n             force attaque :  " + strength +
                        "\n             vie : " + getLife();
    }



}


