package com.DD_microservices.Gestion_personnagesobjets.Persos.Heros;

import com.DD_microservices.Gestion_personnagesobjets.Persos.Fighter;
import com.DD_microservices.Gestion_personnagesobjets.Persos.Personnage;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table( name = "perso")
@Entity
public class Hero extends Personnage implements Fighter {

@Id
private int id;
    public Hero(String name, String type, int life, int forceAttack) {
        super(name, type, life,forceAttack);
    }

    public Hero() {

    }


    @Override
    public int attaque() {

        return strength;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return strength;
    }

    public void setValue(int value) {
        this.strength = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
