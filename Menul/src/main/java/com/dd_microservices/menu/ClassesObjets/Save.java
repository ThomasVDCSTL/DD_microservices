package com.dd_microservices.menu.ClassesObjets;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Schema(description = "Classe contenant les id de tout les objets nécessaires à la sauvegarde d'une partie à un instant donné"
,example = """
        {
             "save": 45,
             "player": 1,
             "hero": 2,
             "date": "2023-12-04T11:17:09",
             "item": 3,
             "hp": 5,
             "board": 2,
             "location": 22
           }
        """)
@Entity
@Table(name="saves")
public class Save {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "save_id")
    protected int save;
    @Column(name = "player_id")
    protected int player;
    @Column(name = "hero_id")
    protected int hero;
    protected LocalDateTime date;
    @Column(name = "item_id")
    protected int item;
    protected int hp;
    @Column(name = "board_id")
    protected int board;
    protected int location;

    public Save(int player, int hero, int item, int hp, int board, int location) {
        this.player = player;
        this.hero = hero;
        this.item = item;
        this.hp = hp;
        this.board = board;
        this.location = location;
    }


    public Save update(int hp, int location, int itemId){
        this.hp=hp;
        this.location=location;
        this.item=itemId;
        return this;
    }

    @Override
    public String toString() {
        return this.player + "/" + this.save;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getHero() {
        return hero;
    }

    public void setHero(int hero) {
        this.hero = hero;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getBoard() {
        return board;
    }

    public void setBoard(int board) {
        this.board = board;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
