package com.DD_microservices.Gestion_joueurs.Model;


import jakarta.persistence.*;

@Entity
@Table(name="joueurdata")
public class JoueurData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="nom")
    private String gamerName;

    @Column
    private float scoreGamer;

    public int getId() {
        return id;
    }

    public String getGamerName() {
        return gamerName;
    }

    public float getScoreGamer() {
        return scoreGamer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public void setScoreGamer(float scoreGamer) {
        this.scoreGamer = scoreGamer;
    }
}
