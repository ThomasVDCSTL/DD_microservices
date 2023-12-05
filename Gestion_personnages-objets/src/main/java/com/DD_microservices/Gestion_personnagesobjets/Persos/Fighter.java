package com.DD_microservices.Gestion_personnagesobjets.Persos;

public interface Fighter {
    int attaque();

    //méthode defence (perte de pointspour le heros)
    void encaisse(Fighter adversaire);

    // methode point de vie
    int getVie();
    //méthode est il en vie ? ( tant que il est en vie on continue)
    boolean isAlive ();
}
