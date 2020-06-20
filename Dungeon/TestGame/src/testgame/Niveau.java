/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author philip.petrescu
 */
public class Niveau {

    private ArrayList<Decor> deco = new ArrayList();
    private ArrayList<Personnage> enemy = new ArrayList();
    private ArrayList<Objet> obj = new ArrayList();
    private Personnage player;
    private Scanner s = new Scanner(System.in);
    private int coordx;
    private int coordy;
    private int lastx = 0;
    private int lasty = 0;
    private boolean next = false;
    int[][] mapa
            = {
                {0, 1, 0, 0, 0, 2, 0, 3, 0, 2},
                {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 2, 0, 0, 1, 1, 1},
                {0, 2, 1, 0, 1, 2, 1, 0, 2, 0},
                {2, 0, 1, 0, 1, 0, 0, 2, 1, 1},
                {1, 3, 1, 0, 1, 2, 1, 0, 3, 5},
                {0, 0, 1, 0, 1, 0, 0, 1, 3, 0},
                {1, 0, 2, 3, 0, 0, 2, 0, 3, 0},
                {0, 1, 0, 1, 1, 2, 0, 3, 1, 0},
                {0, 3, 0, 2, 0, 0, 1, 1, 1, 0},
                {2, 1, 0, 3, 0, 2, 0, 0, 0, 0}};

    public void Niveau() {
    }

    ;
    public void GenerateElem() {
        int rand;
        int rando;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {

                rand = (int) (Math.random() * 3);
                rando = (int) (Math.random() * 6);
                if (mapa[i][j] == 1) {
                    deco.add(new Decor(i, j, "mur"));
                }

                if (mapa[i][j] == 3 && rand == 0) {
                    enemy.add(new Personnage(i, j, "Troll", "Ennemy"));
                }
                if (mapa[i][j] == 3 && rand == 1) {
                    enemy.add(new Personnage(i, j, "Gnome", "Ennemy"));
                }
                if (mapa[i][j] == 3 && rand == 2) {
                    enemy.add(new Personnage(i, j, "Warrior", "Ennemy"));
                }

                if (mapa[i][j] == 2 && rando == 0) {
                    obj.add(new Objet(i, j, "Potion", "Objet"));
                }
                if (mapa[i][j] == 2 && rando == 1) {
                    obj.add(new Objet(i, j, "Sword", "Objet"));
                }
                if (mapa[i][j] == 2 && rando == 2) {
                    obj.add(new Objet(i, j, "Gun", "Objet"));
                }
                if (mapa[i][j] == 2 && rando == 3) {
                    obj.add(new Objet(i, j, "Lance", "Objet"));
                }
                if (mapa[i][j] == 2 && rando == 4) {
                    obj.add(new Objet(i, j, "Telescopica", "Objet"));
                }
                if (mapa[i][j] == 2 && rando == 5) {
                    obj.add(new Objet(i, j, "Machine_Gun", "Objet"));
                }
                if (mapa[i][j] == 5) {
                    coordx = i;
                    coordy = j;
                }
            }
        }
    }

    public void Start() {

        player = new Personnage(0, 0, "Hero", "Player");
        System.out.println("Entrer le nom de votre personnage");
        player.SetName(s.nextLine());
        System.out.println("Bienvenue dans le donjeon, tu commence ton adventure dans la case (0,0), ton but e d'arrive a (5,9)");
        System.out.println("Ton hit point est 1, si tu t'equipe d'une arme ton hitpoint va s'aggrandir avec le hitpoint de l'arme ");
        System.out.println("");
        GenerateElem();
        int reponse;

        while (player.x != coordx || player.y != coordy) {

            if (player.isDead() == true) {
                break;
            }

            System.out.println("Quelle est votre desire?");
            System.out.println("1.Changer l'arme active");
            System.out.println("2.Avancez");
            System.out.println("3.Voire l'inventaire");
            System.out.println("4.Voire point de vie");
            System.out.println("5.Boire Potion");
            reponse = s.nextInt();

            Story(reponse);

            if (checkEnemy() != null) {
                fight(checkEnemy());
            }
            if (checkObj() != null) {
                takeObj(checkObj());
            }

        }
        if (coordx == player.x && coordy == player.y) {
            System.out.println("Bravo! tu a finit le jeux");

        } else {
            System.out.println("Domage! vous avez perdu, peut etre la prochaine fois! :) ");
        }

    }

    public Personnage checkEnemy() {
        Personnage p = null;
        for (Personnage pers : enemy) {
            if (pers.x == player.x && pers.y == player.y) {
                p = pers;
            }
        }
        return p;

    }

    public Objet checkObj() {
        Objet o = null;
        for (Objet objet : obj) {
            if (objet.x == player.x && objet.y == player.y) {
                o = objet;
            }
        }
        return o;

    }

    public void Story(int reponse) {
        switch (reponse) {
            case 1: {
                player.ChangeActive();
                System.out.println("");
                break;
            }
            case 2: {
                Move();
                break;
            }
            case 3: {
                player.ShowIventory();
                System.out.println("");
                break;
            }
            case 4:{
                System.out.println( player.GetVitalite());
                System.out.println("");
                break;
            }
            case 5:{
               player.BoirePotion();
                System.out.println("");
               break;
            }
        }
    }
    
    public void takeObj(Objet obiect) {
        System.out.println(obiect.name + " e par terre");
        player.AjouteObj(obiect);
    }

    public void Move() {
        int reponse;
        boolean hasMoved = false;
        while (hasMoved == false) {
            System.out.println("Ou voullez vous aller?");
            System.out.println("1.en Haut");
            System.out.println("2.a Droite");
            System.out.println("3.a Gauche");
            System.out.println("4.en Bas");
            System.out.println("5.Anuller");
            reponse = s.nextInt();

            switch (reponse) {
                case 1: {
                    if (isMovePossible(player.x - 1, player.y)) {
                        lastx = player.x;
                        lasty = player.y;
                        player.MoveTo(player.x - 1, player.y);
                        hasMoved = true;
                    } else {
                        System.out.println("C'est impossible d'y aller en Haut");
                    }

                    break;
                }
                case 2: {
                    if (isMovePossible(player.x, player.y + 1)) {
                        lastx = player.x;
                        lasty = player.y;
                        player.MoveTo(player.x, player.y + 1);
                        hasMoved = true;
                    } else {
                        System.out.println("C'est impossible d'y aller a Droite");
                    }
                    break;
                }
                case 3: {
                    if (isMovePossible(player.x, player.y - 1)) {
                        lastx = player.x;
                        lasty = player.y;
                        player.MoveTo(player.x, player.y - 1);
                        hasMoved = true;
                    } else {
                        System.out.println("C'est impossible d'y aller a Gauche");
                    }
                    break;
                }
                case 4: {
                    if (isMovePossible(player.x + 1, player.y)) {
                        lastx = player.x;
                        lasty = player.y;
                        player.MoveTo(player.x + 1, player.y);
                        hasMoved = true;
                    } else {
                        System.out.println("C'est impossible d'y aller en Bas");
                    }
                    break;
                }
                default: {
                    System.out.println("Commande annule!");
                    hasMoved = true;
                    break;
                }
            }
        }

    }

    public boolean isMovePossible(int x, int y) {
        boolean ok = true;
        if (x < 0 || y < 0 || x > 9 || y > 10) {
            ok = false;
        }

        if (ok == true) {
            for (Decor d : deco) {
                if (d.isWall(x, y)) {
                    ok = false;
                }
            }
        }

        return ok;
    }

    public void fight(Personnage inamic) {
        String reponse;

        System.out.println(player.GetName() + " a rencontrer " + inamic);
        System.out.println("Voullez vous vous battre avec " + inamic.GetName());
        System.out.println("Oui/Non");
        s.nextLine();
        reponse = s.nextLine();

        if (reponse.compareToIgnoreCase("oui") == 0) {

            while (inamic.isDead() == false && player.isDead() == false) {

                player.hit(inamic);
                if (inamic.isDead() == true) {
                    enemy.remove(inamic);
                    break;
                }
                inamic.hit(player);
                if (player.isDead() == true) {
                    break;
                }
                System.out.println(player.isDead());
                System.out.println("");

            }
        } else {

            player.MoveTo(lastx, lasty);

            return;
        }

    }

}
