package com.DD_microservices.Gestion_joueurs.Model;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Schema(description = "Données du joueur",
example = """
        {
            "id": 0,
            "gamerName": "string",
            "scoreGamer": 0
          }
        """)
@Entity
@Table(name="joueurdata")
public class JoueurData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="nom")
    @Size(min=3, max=25)
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
