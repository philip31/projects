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
public class Decor extends Element{

    public Decor(int x, int y, String type) {
        super(x, y, type);
        SetDescription("Le mur est a X egale a :"+x+" et a Y egale a: "+y);
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
    public boolean isWall(int i,int j){
        boolean este;
        if(super.x==i && super.y==j)
            este=true;
        else este =false;
        return este;
    }
    
}
