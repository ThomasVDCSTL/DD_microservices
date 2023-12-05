package com.DD_microservices.Gestion_game.model.Board;

import com.DD_microservices.Gestion_game.model.Misc.Enemies.Enemy;
import com.DD_microservices.Gestion_game.model.Misc.Hero;
import com.DD_microservices.Gestion_game.model.Misc.Items.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {

    @Id
    private int id;

    @OneToMany(mappedBy="board")
    private List<Tyle> board = new ArrayList<Tyle>();

    public Board() {
        this.id = id;
        for (int i = 0; i < 64; i++) {
            if (i<10) {
                board.add(new CaseVide(i));
            } else {
                board.add(new Item(i));
            }
            //ajouter random + cases plus spécifiques
        }

    }

    public void eraseCase(int position) {
        board.set(position, new CaseVide(position));
    }

    public void showCaseInfo(int position) {
        System.out.println(board.get(position));
    }

    public int makeInteraction(int position, Hero hero) {
        return board.get(position).interaction(hero);
    }

    public List<Tyle> getBoard() {
        return board;
    }

    public int getSize() {
        return board.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
