package com.dd_microservices.menu.ClassesObjets;

import jakarta.persistence.*;

@Table(name= "object")
@Entity
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
