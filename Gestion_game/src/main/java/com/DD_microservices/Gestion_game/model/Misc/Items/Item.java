package com.DD_microservices.Gestion_game.model.Misc.Items;

import com.DD_microservices.Gestion_game.model.Board.CaseVide;
import com.DD_microservices.Gestion_game.model.Misc.Hero;

public class Item extends CaseVide {

    private int ItemValue;

    private String name;

    public Item(int id) {
        super(id);
    }

    public Item() {
        super();
    }
    public int interaction(Hero hero) {
        System.out.println("Pouf, je vois un objet par terre !");

        if (name.equals("Weapon") || name.equals("Spell")) {
            return interactAttack(hero);
        } else {
           return interactPotion(hero);
        }
    }

    public int interactAttack(Hero hero) {

        System.out.println("Ouuuh, c'est un equipement offensif !");

        if (hero.getType().equals("Warrior") && name.equals("Weapon")) {
            hero.setForceAttack(hero.getForceAttack() + getItemValue());
            if (hero.getForceAttack() > 10) {
                hero.setForceAttack(10);
            }
            System.out.println("Tes nouveaux points d'attaque: " + hero.getForceAttack());
        }
        else if (hero.getType().equals("Wizard") && name.equals("Spell")) {
            hero.setForceAttack(hero.getForceAttack() + getItemValue());
            if (hero.getForceAttack() > 15) {
                hero.setForceAttack(15);
            }
            System.out.println("Nouveaux points d'attaque: " + hero.getForceAttack());
        } else {
            System.out.println("Mais il ne se passe rien...");
        }
        return hero.getForceAttack();
    }

    public int interactPotion(Hero hero) {
        System.out.println("Ouuuh, c'est une potion !");

        hero.setLife(hero.getLife() + getItemValue());

        if ((hero.getType().equals("Warrior") && hero.getLife() > 10)) {
            hero.setLife(10);
        }
        if ((hero.getType().equals("Wizard") && hero.getLife() > 15)) {
            hero.setLife(15);
        }

        System.out.println("Nouveaux points de vie: " + hero.getLife());
        return hero.getLife();
    }

    public int getItemValue() {
        return ItemValue;
    }
}
