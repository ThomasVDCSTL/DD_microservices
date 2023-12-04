package com.DD_microservices.Gestion_personnagesobjets.Persos.Heros;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnages;
import org.springframework.beans.factory.annotation.Value;

public class Warrior extends Personnages {

    public Warrior(String name, String type, int vie, int forceAttack) {
     super(name, "Warrior", 5,10);
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


