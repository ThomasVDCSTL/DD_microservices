package com.DD_microservices.Gestion_personnagesobjets.Persos.Heros;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnages;

public class Wizard extends Personnages {


    public Wizard( String name, String type, int life, int forceAttack) {
        super(name , "Wizard" , 10,7);

    }


    @Override
    public String toString() {
        return
                "--             Player Info             --" +
                        "\n             Class : " + "Guerrier" +
                        "\n             force attaque :  " + value +
                        "\n             vie : " + getLife();
    }

}
