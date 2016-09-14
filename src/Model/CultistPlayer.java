/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class CultistPlayer extends Player{
    
    private static int totalCultisPlayers=0;
    private Cultist myCultistCard;
    
    public CultistPlayer (Player p, Cultist c)
    {
        super(p);
        totalCultisPlayers++;
        myCultistCard = c;
    }
    public static int getTotalCultistPlayer()
    {
        return totalCultisPlayers;
    }
    @Override
    protected boolean shouldCovert()
    {
        return false;
    }
    @Override
    public int getCombatLevel()
    {
        int combatLevelNotCultist = super.getCombatLevel();
        return combatLevelNotCultist+
                (combatLevelNotCultist*20)/100+
                myCultistCard.getGainedLevels()*totalCultisPlayers;
    }
    @Override
    protected int getOponentLevel(Monster m)
    {
        return m.getLevelChangeAgainstCultistPlayer();
    }
    
    @Override
    protected Treasure giveMeATreasure()
    {
        Random rad = new Random();
        ArrayList<Treasure> tVisible = super.getVisibleTreasures();
        int i = rad.nextInt(tVisible.size());
        return super.getVisibleTreasures().remove(i);
    }
    
    @Override
    protected boolean canYouGiveMeATreasure()
    {
        return !super.getVisibleTreasures().isEmpty();
    }
}
