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
public class Cultist
{
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedlevels)
    {
        this.name = name;
        this.gainedLevels = gainedlevels;
    }
    
    public int getGainedLevels()
    {
        return this.gainedLevels;
    }
}
