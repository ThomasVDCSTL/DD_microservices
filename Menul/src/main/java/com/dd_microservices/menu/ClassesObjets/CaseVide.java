package com.dd_microservices.menu.ClassesObjets;

public class CaseVide extends Tyle {

    public CaseVide(int id) {
        super(id);
    }
    public CaseVide() {
        super();
    }

    public int interaction(Personnage hero) {
//        System.out.println("Ouf !");
        return 5;
    }

    public String toString() {
        return "C'est une case vide.";
    }

}
