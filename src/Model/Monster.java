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
public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence bc;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String name, int level, 
                    BadConsequence bc, 
                    Prize prize)
    {
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.bc = bc;
        this.levelChangeAgainstCultistPlayer=0;
    }
    public Monster(String name, int level, 
                    BadConsequence bc, 
                    Prize prize,
                    int levelChangeAgainstCultistPlayer)
    {
        
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.bc = bc;
        this.levelChangeAgainstCultistPlayer=levelChangeAgainstCultistPlayer;
    }
    public String getName()
    {
        return name;
    }
    public int getCombatLevel()
    {
        return combatLevel;
    }
    public BadConsequence getBadConsequence()
    {
        return bc;
    }
    public int getLevelsGained()
    {
        return prize.getLevels();
    }
    public int getTreasuresGained()
    {
        return prize.getTreasures();
    }
    public int getLevelChangeAgainstCultistPlayer()
    {
        return combatLevel + levelChangeAgainstCultistPlayer;
    }
    public String toString()
    {
        return "Name = " + name + 
                " \nCombat level = " + Integer.toString(combatLevel) + 
                " \nPrize: " + prize.toString() +
                " \nBad consequence: " + bc.toString()+
                " \nlevelChangeAgainstCultistPlayer: "+Integer.toString(levelChangeAgainstCultistPlayer);
    }
}
