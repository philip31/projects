/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author philip.petrescu
 */
public class Personnage extends Element {

    //variables
    ArrayList<Objet> inventory = new ArrayList();
    private int vitaliteMax = 20;
    private int vitalite;
    private String name;
    private final int InventorySpace = 2;
    private Scanner scan = new Scanner(System.in);
    private boolean isDead = false;
    private int hitPoint;
    public Boolean didFight=null;

//constructor
    public Personnage(int x, int y, String ennemy, String type) {
        super(x, y, type);

        if (ennemy == "Hero") {
            vitalite = vitaliteMax;
            hitPoint = 1;
        }
        if (ennemy == "Troll") {
            vitalite = 14;
            hitPoint = 1;
            name = "Troll";
        }
        if (ennemy == "Gnome") {
            vitalite = 3;
            hitPoint = 5;
            name = "Gnome";
        }
        if (ennemy == "Warrior") {
            vitalite = 15;
            hitPoint = 3;
            name = "Warrior";

        }
        SetDescription(ennemy + " est a X egale a :" + x + " et a Y egale a: " + y);
    }
//metode abstracte

    @Override
    protected String GetDescription() {
        return super.Description;
    }

    @Override
    protected void SetDescription(String s) {
        super.Description = s;
    }

    @Override
    protected String GetType() {
        return super.type;
    }

//metode non-abstracte
    public void MoveTo(int x, int y) {
        super.x = x;
        super.y = y;
        System.out.println("Le joueur est maintenant a : " + "(" + super.x + "," + super.y + ")");

    }

    public void hit(Personnage p) {
        if (inventory.isEmpty()) {
            System.out.println(name + " a inflict damage: " + hitPoint + " a " + p.name);
            p.Damage(hitPoint);
        } else {

            System.out.println(name + " a inflict damage: " + (hitPoint + inventory.get(0).GetHitPoint()) + " a " + p.name);
            p.Damage(hitPoint + inventory.get(0).GetHitPoint());
        }
    }

    public void ChangeActive() {
        String reponse;
        if (!inventory.isEmpty()) {
            System.out.println("Choisisez l'objet que vous voullez faire active:");
            System.out.println(inventory);
            reponse = scan.nextLine();
            for (Objet i : inventory) {
                if (reponse.compareToIgnoreCase(i.name)==0) {
                    Collections.swap(inventory, inventory.indexOf(i), 0);
                    System.out.println(inventory.get(0).name + " est maintenant active");
                    return;

                }
            }

            System.out.println("Il n'y a acun objet de ce type ");

        } else {
            System.out.println("Vous n'avez pas d'objets dans l'inventoire");
        }
    }

    public void Damage(int vit) {

        if (vitalite - vit > 0) {

            System.out.println(name + " a perdu " + vit + " points de vie");
            System.out.println("Point de vie restant " + (vitalite - vit));
            this.vitalite -= vit;

        } else {
            System.out.println(name + " a perdu " + vit + " points de vie");
            System.out.println("Point de vie restant " + 0);
            this.vitalite = 0;
            isDead=true;
            System.out.println(name + " est mort");

        }
    }

    public void Recovery() {
        if (vitalite + 7 > vitaliteMax) {

            System.out.println("Tu a gagne " + 7 + " points de vie");
            System.out.println("Point de vie " + vitaliteMax);
            this.vitalite = vitaliteMax;

        } else {
            System.out.println("Tu a gagne " + 7 + " points de vie");
            System.out.println("Point de vie  " + (vitalite + 7));
            this.vitalite += 7;
        }
    }
    public void BoirePotion(){
        boolean este=false;
        
        for(Objet o:inventory){
            if(o.name=="Potion"){
                este = true;
                inventory.remove(o);
                break;
            }
        }
        if(este==true){
            Recovery();
        }
        else {
            System.out.println("Pas de potion dans l'inventaire");
        }
    }

    public int GetVitalite() {
        return vitalite;
    }

    public void ShowIventory() {
        System.out.println(inventory);
    }

    public void AjouteObj(Objet o) {
        String reponse;

        if (inventory.size() == InventorySpace) {
            System.out.println("Vous n'avez pas assez de place! Voullez vous renoncez a un objet?");
            System.out.println("Oui/Non");

            if (scan.nextLine().compareToIgnoreCase("oui")==0) {
                System.out.println("Choisisez l'objet que vous voullez jeter:");
                System.out.println(inventory);
                System.out.println("Introduisez le nom de l'objet ou taster \"quit\" pour terminer ");
                reponse = scan.nextLine();
                if (reponse.compareToIgnoreCase("quit")==0) {
                    return;
                } else {
                    for (Objet i : inventory) {
                        if (reponse.compareToIgnoreCase(i.name)==0) {
                            JeterObj(i);
                            inventory.add(o);

                            o.InInventory();
                            return;

                        }
                    }
                    System.out.println("Acun Objet avec se nom");
                }
            } else {
                return;
            }
        } else {
            System.out.println("Objet " + o.name + " est maintenant dans l'inventoire");
            inventory.add(o);
            o.InInventory();
        }
    }

    public void JeterObj(Objet o) {
        inventory.remove(o);
        o.OnTheGround(super.x, super.y);

    }

//seteri
    public void SetName(String nume) {
        this.name = nume;
    }
    

//getteri
    public String GetName() {
        return name;
    }

    public int GetVitaliteMax() {
        return vitaliteMax;
    }

    public void SetVitaliteMax(int vitm) {
        vitaliteMax = vitm;
    }
    
    @Override
    public String toString(){
    return name+" hitpoint: "+hitPoint+", vie: "+vitalite;
}
   

    public boolean isDead() {
        return isDead;
    }
}
