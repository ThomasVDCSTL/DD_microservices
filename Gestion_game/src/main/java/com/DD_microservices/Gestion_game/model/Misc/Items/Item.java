package com.DD_microservices.Gestion_game.model.Misc.Items;

import com.DD_microservices.Gestion_game.model.Board.Tyle;
import com.DD_microservices.Gestion_game.model.Misc.Personnage;
import jakarta.persistence.*;

public abstract class Item extends Tyle {

    private int id;
    protected String type;
    protected String name;

    public Item(String type, String name, int forceAttack) {
        this.type = type;
        this.name = name;
        this.forceAttack = forceAttack;
    }

    protected int forceAttack ;
    public Item() {
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getForceAttack() {
        return forceAttack;
    }

    public void setForceAttack(int forceAttack) {
        this.forceAttack = forceAttack;
    }

    public int getId() {
        return id;
    }


}
