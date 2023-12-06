package com.DD_microservices.Gestion_game.model.Misc;


import com.DD_microservices.Gestion_game.Fighter;
import com.DD_microservices.Gestion_game.model.Misc.Items.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

public class Personnage implements Fighter {

    protected int id;
    protected Item arme;
    protected int life;
    protected String name;
    protected String type;
    protected  int strength;

    protected int position;


    public Personnage(String name, String type, int life, int strength) {
        this.name = name;
        this.type = type;
        this.life = life;
        this.strength = strength;
    }

    public Personnage() {

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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int value) {
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

    public int getVie() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int attaque() {
        return strength + arme.getForceAttack();
    }

    public boolean isAlive() {
        return this.life > 0;
    }

    public void encaisse(Fighter adversaire) {
        setLife((getVie() - adversaire.attaque()));
    }

    public Item getArme() {
        return arme;
    }

    public void setArme(Item arme) {
        this.arme = arme;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        "\n " + name + " + name + 0" +
                        "\n type='" + type +
                        "\n life=" + life;
    }

    public void StartFight(Fighter player) {

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