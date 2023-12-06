package com.DD_microservices.Gestion_game.model.Board;

import com.DD_microservices.Gestion_game.model.Misc.Items.Potion;
import com.DD_microservices.Gestion_game.model.Misc.Items.Spell;
import com.DD_microservices.Gestion_game.model.Misc.Items.Weapon;
import com.DD_microservices.Gestion_game.model.Misc.Personnage;
import com.DD_microservices.Gestion_game.model.Misc.Items.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Board {

    @Id
    private int id;

    @OneToMany(mappedBy = "board")
    private List<Tyle> board = new ArrayList<Tyle>();

    public Board() {
        this.id = id;
        for (int i = 0; i < 64; i++) {
            switch (i) {
                case 1, 10, 4, 21, 37 -> board.add(new Weapon("Massue", 3));
                case 18, 25, 41, 52 -> board.add(new Weapon("Epée", 5));
                case 0, 3, 7, 16, 22 -> board.add(new Spell("Eclair", "Sort", 3));
                case 47, 48 -> board.add(new Spell("Boule de feu", "Sort", 5));
                case 6, 12, 30, 32, 38, 42 -> board.add(new Potion("petite", 3, "potion"));
                case 27, 40 -> board.add(new Potion("petite", 5, "potion"));
                default -> board.add(new CaseVide());
            }
            Collections.shuffle(board);
        }
    }

        public void eraseCase ( int position){
            board.set(position, new CaseVide(position));
        }

        public void showCaseInfo ( int position){
            System.out.println(board.get(position));
        }

        public int makeInteraction ( int position, Personnage hero){
            return board.get(position).interaction(hero);
        }

        public List<Tyle> getBoard () {
            return board;
        }

        public int getSize () {
            return board.size();
        }

        public int getId () {
            return id;
        }

        public void setId ( int id){
            this.id = id;
        }
    }

