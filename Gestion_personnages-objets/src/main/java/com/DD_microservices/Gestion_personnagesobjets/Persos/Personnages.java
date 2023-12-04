package com.DD_microservices.Gestion_personnagesobjets.Persos;


import com.DD_microservices.Gestion_personnagesobjets.Persos.Enemy.Enemy;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public abstract class Personnages  {
    @Id
    protected  int id;


    protected String name;
   protected String type;
    @Column(name = "strength")
    protected int value ;





    public Personnages(){

    }


    public Personnages( String name, String type, int life, int value) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.life = life;
        this.value = value;
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

    public String getType() {
        return type;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
                        "\n "+ name+ " + name + 0" +
                        "\n type='" + type +
                        "\n life=" + life ;
    }


}
