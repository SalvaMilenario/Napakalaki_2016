/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class DeathBadConsequence extends NumericBadConsequence
{
    public DeathBadConsequence(String text)
    {
        super(text, 0, 0, 0);
        super.death=true;
    }
    @Override
    public void substractVisibleTreasure(Treasure t)
    {
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t)
    {
    }
    
    @Override
    public boolean isEmpty()
    {
        return !death;
    }
    
    @Override
    public String toString()
    {
        return  "Mal royo:\n\tText = " + text + 
                " \n\tLevels = " + Integer.toString(levels) + 
                " \n\tDeath = " + death ;
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
        return this;
    }
}
