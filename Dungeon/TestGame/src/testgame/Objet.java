/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgame;

/**
 *
 * @author philip.petrescu
 */
public class Objet extends Element {
    public String name;
    private boolean DansInventory=false;
    private Integer hitPoint;
    private Integer reco;
    
    
    
    public Objet(int x, int y,String tip, String type) {
        super(x, y, type);
        
        if(tip=="Potion"){
        hitPoint=0;
        reco=7;
        name="Potion";
        }
        
        if(tip=="Sword"){
        hitPoint=3;
        name="Sword";
        }
        
        if(tip=="Gun"){
        hitPoint=5;
        name="Gun";
        }
        
        if(tip=="Lance"){
        hitPoint=4;
        name="Lance";
        }
        
        if(tip=="Telescopica"){
        hitPoint=2;
        name="Telescopica";
        }
        
        if(tip=="Machine_Gun"){
        hitPoint=9;
        name="Machine_Gun";
        }
        SetDescription("L'objet "+tip+" est a X egale a :"+x+" et a Y egale a: "+y);
        
    }
    public int GetHitPoint(){
        return hitPoint;
        
    }
    public void InInventory(){
        DansInventory=true;
        super.x=null;
        super.y=null;
    }
    public void OnTheGround(int x,int y){
        DansInventory=false;
        super.x=x;
        super.y=y;
        System.out.println(this.name+ " a ete jeter");
    }
    
    @Override
    protected String GetDescription() {
        return super.Description;
    }

    @Override
    protected void SetDescription(String s) {
        super.Description=s;
    }

    @Override
    protected String GetType() {
        return super.type;
    }
    @Override
    public String toString(){
       String arme;
       if(name!="Potion"){
           arme= name +" attack= "+hitPoint;
       }else{
           arme = name +" Gain "+reco+ " life points";
       }
        return arme;
    }
}
