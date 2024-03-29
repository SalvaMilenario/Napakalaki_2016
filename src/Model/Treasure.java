/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


/**
 *
 * @author Salva
 */
public class Treasure {
    private String name;
    private int bonus;
    private TreasureKind type;
    
    public Treasure(String n, int bonus, TreasureKind t)
    {
        this.name = n;
        this.bonus = bonus;
        this.type = t;
    }

    public String getName()
    {
        return name;
    }

    public int getBonus()
    {
        return bonus;
    }
    
    public TreasureKind getType()
    {
        return type;
    }
    @Override
    public String toString(){
        return "\n\tTesoro: " + name +  
               "\n\t\tBonus: " + Integer.toString(bonus) +
               "\n\t\tTreasureKind: " + type;
    }
}