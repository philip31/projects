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
public abstract class Element {
    
    //variabilele
    protected String type;
    protected Integer x;
    protected Integer y;
    protected String Description;
    
    //constructorul
    public Element(int x, int y, String type){
        this.x=x;
        this.y=y;
        this.type=type;
        
    }
    
    //metodele abstracte
    abstract protected String GetDescription();
     abstract protected void SetDescription(String s);
    abstract protected String GetType();
    
    //metodele Non-abstracte
    
}
