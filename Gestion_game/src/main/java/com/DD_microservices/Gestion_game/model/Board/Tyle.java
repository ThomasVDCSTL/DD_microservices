package com.DD_microservices.Gestion_game.model.Board;

import com.DD_microservices.Gestion_game.model.Misc.Personnage;
import jakarta.persistence.*;

@Entity
public abstract class Tyle {

    @ManyToOne
    @JoinColumn(name="board_id", nullable=false)
    private Board board;

    @Id
    private int id;

    public Tyle(int id) {
        this.id = id;
    }
    public Tyle() {
        this.id = -1;
    }

    public abstract int interaction(Personnage hero);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
