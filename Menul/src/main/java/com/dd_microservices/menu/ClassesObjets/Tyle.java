package com.dd_microservices.menu.ClassesObjets;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
