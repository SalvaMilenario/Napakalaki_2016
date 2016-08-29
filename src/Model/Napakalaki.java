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
public class Napakalaki {
//    Implementación singleton
//    Su intención consiste en garantizar que una clase sólo tenga una instancia 
//    y proporcionar un punto de acceso global a ella.

    private static Napakalaki instance = null;
    private ArrayList<Player> players; 
    private Player currentPlayer;
    private Monster currentMonster;
    private int currentPlayerIndex; //índice del jugador que posee el turno
    private static boolean firstTurn = true;
    final private CardDealer dealer = CardDealer.getInstance();
    // El constructor privado no permite que se genere un constructor por defecto.
    // (con el mismo modificador de acceso que la definición de la clase)
    private Napakalaki()
    {
        
    }
    public static Napakalaki getInstance()
    {
        if (instance == null)
            instance=new Napakalaki();
        return instance;
    }
    private void initPlayers(ArrayList<String> names)
    {
        players = new ArrayList<Player>();
        for(String n : names)
            players.add(new Player(n));
    }
    private Player nextPlayer()
    {
        if(firstTurn) // Si es el primer turno
        {
            firstTurn=false; // el primer índice se selecciona con el dado
            currentPlayerIndex = Dice.getInstance().nextNumber()%players.size();
        }
        else
        {
            currentPlayerIndex++;                   
            currentPlayerIndex %= players.size(); // De esta maneta se controla 
        }                                         // que no se salga del vector
        currentPlayer = players.get(currentPlayerIndex);
        return currentPlayer;
    }

    public CombatResult developCombat()
    {
        CombatResult result = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        if (result == CombatResult.LOSEANDCONVERT)
        {
            Cultist c = dealer.nextCultist();
            CultistPlayer newCultist = new CultistPlayer(currentPlayer, c);
            for(Player p:players)
            {
                if(p==currentPlayer)
                {
                    int i = players.indexOf(currentPlayer);
                    players.remove(currentPlayer);
                    players.add(i, newCultist);
                }
                else
                    if(p.getEnemy()==currentPlayer)
                        p.setEnemy(newCultist);
            }
            currentPlayer = newCultist;
        }
        return result;
    }
    
    public void discardVisibleTreasures(ArrayList <Treasure> treasures )
    {
        for(Treasure t:treasures)
        {
            currentPlayer.discardVisibleTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void discardHiddenTreasures(ArrayList <Treasure> treasures )
    {
        for(Treasure t:treasures)
        {
            currentPlayer.discardHiddenTreasure(t);
            dealer.giveTreasureBack(t);
        }
    }
    
    public void makeTreasureVisible(Treasure t)
    {
        currentPlayer.makeTreasureVisible(t);
    }

    public void initGame(ArrayList<String> players)
    {
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    public Monster getCurrentMonster()
    {
        return currentMonster;
    }
    
    public boolean nextTurn()
    {
        boolean stateOk = nextTurnIsAllowed();
        if(stateOk){ 
            currentMonster = dealer.nextMonster();
            currentPlayer =  nextPlayer();
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();
            }
        }
        return stateOk;
    }
        
    private boolean nextTurnIsAllowed()
    {
//      En la primera ejecución, currentPlayer aún es nulo
        return currentPlayer==null ? true : currentPlayer.validState();
    }
    private void setEnemies()
    {
        for (Player p:players)
        {
            boolean repite =true;
            int i = this.players.indexOf(p);
            do
            {
                int idp= Dice.getInstance().nextNumber() & this.currentPlayerIndex+1;
                if(i!=idp)
                {
                    p.setEnemy(this.players.get(idp));
                    repite=false;
                }
            }while(repite);
        }
    }
        
    public boolean endOfGame(CombatResult result)
    {
        return result==CombatResult.WINGAME;
    }
    
}