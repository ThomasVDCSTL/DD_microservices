package com.DD_microservices.Gestion_game.model.Misc.Enemies;

import com.DD_microservices.Gestion_game.model.Board.CaseVide;
import com.DD_microservices.Gestion_game.model.Misc.Hero;

import java.util.Scanner;

public class Enemy extends CaseVide {

    int forceAttack;
    int life;
    int dice;

    public Enemy(int id) {
        super(id);
    }

    public Enemy() {
        super();
    }

    public int interaction(Hero hero) {
        System.out.println("Pouf, je rencontre un ennemi!");

        System.out.println("Que veux tu faire ? Attaquer(1) ou fuir(2)?");
        Scanner choice1 = new Scanner(System.in);  // Create a Scanner object
        String attaqueFuite = choice1.nextLine();// Read user input

        if (attaqueFuite.equals("1")) {
            System.out.println("Que le combat commence...");
            while (hero.getLife() > 0 && getLife() > 0) {

                setLife(getLife() - hero.getForceAttack());

                if (getLife() > 0) {
                    hero.setLife(hero.getLife() - getForceAttack());
                    System.out.println("L'ennemi t'a touché ! Tes nouveaux points de vie: " + hero.getLife());

                } else {
                    System.out.println("Bravo, tu as vaincu l'ennemi, il a disparu !");
                }

                System.out.println("Tes PV: " + hero.getLife());

                if (getLife() < 0) {
                    System.out.println("Ses PV: 0");
                } else {
                    System.out.println("Ses PV: " + getLife());
                }
            }

        } else {
            dice = 1 + (int) (Math.random() * (6));
            System.out.println("Tu recules de " + dice + " cases.");
            hero.setPosition(hero.getPosition() - dice);
        }

        return getLife();
    }

    public int getForceAttack() {
        return forceAttack;
    }

    public int getLife() {
        return life;
    }

    public void setForceAttack(int forceAttack) {
        this.forceAttack = forceAttack;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
