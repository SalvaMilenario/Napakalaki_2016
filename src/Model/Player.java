 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import java.util.Random;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author Salva
 */
public class Player {
    
    final protected static int MAXLEVEL = 10;
    private boolean dead;
    final private String name;
    private int level;
    private Player enemy;
    private boolean canISteal; 
    private ArrayList <Treasure> visibleTreasures;
    private ArrayList <Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence; 
    
    public Player(String name)
    {
        this.level = 1;
        this.visibleTreasures = new ArrayList<>();
        this.hiddenTreasures = new ArrayList<>();
        this.pendingBadConsequence = new NumericBadConsequence("Vacio",0,0,0);
        this.name=name;
        this.dead=true;
        this.canISteal = true;
    }
    
    public Player(Player p)
    {
        this.canISteal=p.canISteal;
        this.dead=p.dead;
        this.enemy=p.enemy;
        this.hiddenTreasures=p.hiddenTreasures;
        this.level=p.level;
        this.name=p.name;
        this.pendingBadConsequence=p.pendingBadConsequence;
        this.visibleTreasures=p.visibleTreasures;
    }
    
    private void bringToLive()
    {
        dead = false;
    }
    private void incrementLevels(int l)
    {
        level = level + l;
    }
    public void discardAllTreasures()
    {
        ArrayList <Treasure> ocultos = new ArrayList(this.hiddenTreasures);
        ArrayList <Treasure> visibles = new ArrayList(this.visibleTreasures);
        for(Treasure t:ocultos)
        {
            discardHiddenTreasure(t);
        }
        for(Treasure t:visibles)
        {
            discardVisibleTreasure(t);
        }
    }
    public void haveStolen()
    {
        canISteal=false;
    }
    private void decrementLevels(int l)
    {
        if(level-l <= 0){
            level =  1;
        }else
            level = level - l;
    }
    private void setPendingBadConsequence(BadConsequence b)
    {
        pendingBadConsequence = b;
    }
    
    private void dieIfNoTreasures()
    {
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead=true;
    }

    private void applyPrize(Monster m)
    { 
        int nLevels = m.getLevelsGained();
        this.incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        if(nTreasures>0)
        {
            CardDealer dealer = CardDealer.getInstance();
            for(int i = 0;i<nTreasures;i++)
                hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    public CombatResult combat(Monster m)
    {
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        if(myLevel > monsterLevel)
        {
            this.applyPrize(m);
            if(level >= Player.MAXLEVEL)
                return CombatResult.WINGAME;
            else
                return CombatResult.WIN;
        }
        else
        {
            if (this.shouldCovert())
                return CombatResult.LOSEANDCONVERT;
            else
            {
                this.applyBadConsequence(m);
                return CombatResult.LOSE;
            }
        }
    }
    private void applyBadConsequence(Monster m)
    {
        BadConsequence bad = m.getBadConsequence();
        int nLevels = bad.getLevels();
        decrementLevels(nLevels);
        dead = bad.getDead();
        BadConsequence b = bad.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures); //tiene que hacer la llamada sobre bad, no sobre pending
        setPendingBadConsequence(b);
    }
    public void makeTreasureVisible(Treasure t)
    {
        boolean canI = this.canMakeTreasureVisible(t);
        if(canI)
        {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    private boolean canMakeTreasureVisible(Treasure t) 
    {
        boolean canI = true;// debe de ser inicialmente verdadero
        TreasureKind i = t.getType();
        if(i==TreasureKind.ONEHAND||i==TreasureKind.BOTHHANDS)
        {
            int contDos = howManyVisibleTreasures(TreasureKind.BOTHHANDS);
            int contOne = howManyVisibleTreasures(TreasureKind.ONEHAND);
            if((contOne>0&&i==TreasureKind.BOTHHANDS)||contDos>0)
                canI=false;
            if(contOne==2)
                canI=false;
        }
        else
            if(this.howManyVisibleTreasures(i)==1)
                canI=false;
        return canI;
    }
    private int howManyVisibleTreasures(TreasureKind tKind)
    {
        int cont=0;
        for(Treasure t: visibleTreasures)
        {
            if (t.getType()==tKind)
                cont++;
        }
        return cont;
    }
    public void discardVisibleTreasure(Treasure t)
    {
        CardDealer dealer = CardDealer.getInstance();
        visibleTreasures.remove(t);
        if( pendingBadConsequence!=null && !pendingBadConsequence.isEmpty() )
            pendingBadConsequence.substractVisibleTreasure(t);
        dealer.giveTreasureBack(t);
        this.dieIfNoTreasures();
    }
    public void discardHiddenTreasure(Treasure t)
    {
        hiddenTreasures.remove(t);
        if( pendingBadConsequence!=null && !pendingBadConsequence.isEmpty() )
            pendingBadConsequence.substractHiddenTreasure(t);
        this.dieIfNoTreasures();
    }
   
    protected int getCombatLevel()
    {
        int combatLevel = level;
        for (Treasure T : visibleTreasures)
            combatLevel += T.getBonus();
        return combatLevel;        
    }
    public int getLevels()
    {
        return this.level;
    }
    public Treasure stealTreasure()
    {
        boolean canI = canISteal();
        if(canI)
        {
            boolean canYou = enemy.canYouGiveMeATreasure();
            if(canYou)
            {
                Treasure treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
                return treasure;
            }
        }
        return null;
    }
    public void setEnemy(Player p)
    {
        enemy=p;
    }
    protected Treasure giveMeATreasure()
    {
        Random rad = new Random();
        int i = rad.nextInt(this.hiddenTreasures.size());
        return hiddenTreasures.remove(i);
    }
    protected boolean canYouGiveMeATreasure()
    {
        return !hiddenTreasures.isEmpty();
    }
    public boolean validState()
    {
        return (pendingBadConsequence.isEmpty())&&(hiddenTreasures.size()<=4)||(dead&&(hiddenTreasures.isEmpty()&&visibleTreasures.isEmpty()));
    }
    public void initTreasures()
    {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        this.bringToLive();
        int tirada = dice.nextNumber(), numeroTesoros=2;
        if(tirada==6)
            numeroTesoros = 3;
        else if (tirada == 1)
            numeroTesoros = 1;
        
        for(int i = 0;i<numeroTesoros;i++)
            hiddenTreasures.add(dealer.nextTreasure());
        
    }
    public boolean isDead()
    {
        return dead;
    }
    
    public ArrayList <Treasure> getVisibleTreasures()
    {
        return visibleTreasures;
    }
    public ArrayList <Treasure> getHiddenTreasures()
    {
        return hiddenTreasures;
    }
    public boolean canISteal()
    {
        return canISteal;
    }
    @Override
    public String toString()
    {
        String textoInicial = "\n\tName = " + name + 
                " \n\tLevel = " + Integer.toString(level) + 
                " \n\tCombatLevel = " + Integer.toString(this.getCombatLevel())+
                " \n\tPuede robar = "+Boolean.toString(canISteal)+
                " \n\tEnemigo = "+ enemy.getName()+
                " \n\tDead = " + Boolean.toString(dead)+
                " \n\tPendingBadConsequence: { " + pendingBadConsequence.toString() +
                "\n\t}";
        String textoHiddenTreasures = " \n\tArray Hidden Treasures: { ";
        String textoVisibleTreasures = " \n\tArray Visible Treasures: { ";
        if(!visibleTreasures.isEmpty())
        {
            for (Treasure t : visibleTreasures)
                textoVisibleTreasures += (t.toString() + " ");
        }
        else
        {
            textoVisibleTreasures += "No tiene ningún tesoro visible. ";
        }
        
        if(!hiddenTreasures.isEmpty())
        {
            for (Treasure t : hiddenTreasures)
                textoHiddenTreasures += (t.toString() + " ");
        }
        else
        {
            textoHiddenTreasures += "No tiene ningún tesoro oculto. ";
        }
        return textoInicial + textoHiddenTreasures + "}" + textoVisibleTreasures + "}";
    }
    public String getName()
    {
        return name;
    }
    protected int getOponentLevel(Monster m)
    {
        return m.getCombatLevel();
    }
    protected boolean shouldCovert()
    {
        if(Dice.getInstance().nextNumber()==1)
            return true;
        else
            return false;
    }
    protected Player getEnemy()
    {
        return enemy;
    }
}
