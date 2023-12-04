package com.DD_microservices.Gestion_personnagesobjets.Persos;


import com.DD_microservices.Gestion_personnagesobjets.Persos.Enemy.Enemy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public abstract class Personnages {
    @Id
    protected int id;

    protected int life;
    protected String name;
    protected String type;
    @Column(name = "strength")
    protected int forceAttack;


    public Personnages() {

    }


    public Personnages(String name, String type, int life, int value) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.life = life;
        this.forceAttack = forceAttack;
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
        return forceAttack;
    }

    public void setValue(int value) {
        this.forceAttack = value;
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



    @Override
    public String toString() {
        return
                "id=" + id +
                        "\n " + name + " + name + 0" +
                        "\n type='" + type +
                        "\n life=" + life;
    }


}
