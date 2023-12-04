package com.DD_microservices.Gestion_game.model.Misc;

public class Hero {
    private int position;
    private int forceAttack;
    private int life;
    private String type;

    public String toString() {
        return "Je suis un Herooos";
    }

    public int getPosition() {
        return position;
    }

    public int getForceAttack() {
        return forceAttack;
    }

    public int getLife() {
        return life;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setForceAttack(int forceAttack) {
        this.forceAttack = forceAttack;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
