package com.DD_microservices.Gestion_personnagesobjets.Persos.Heros;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;

public class Wizard extends Personnage {


    public Wizard( String name, String type, int life, int forceAttack) {
        super(name , "Wizard" , 10,7);

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
