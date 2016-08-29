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

// Como todos los atributos de un BadConsequence 
// permanecen inmutables a lo largo de su existencia
// resulta interesante marcarlos como constantes (final)
// Una excepción son los dos ArrayList

public abstract class BadConsequence 
{
    protected static int MAXTREASURES = 10;
    protected String text;   // Todos tienen nombre
    protected int levels;    // Todos tienen niveles
    protected boolean death; // Todos tienen un valor de muerte
    
    public BadConsequence(String text, int levels, boolean death)
    {
        this.text = text;
        this.levels = levels;   
        this.death = death;
    }
    
    public String getText()
    {
        return text;
    }
    
    public int getLevels()
    {
        return levels;
    }
        
    public boolean getDead()
    {
        return death;
    }
        
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    @Override
    public abstract String toString();
}
/*
public class BadConsequence 
{
    protected static int MAXTREASURES = 10;
    final private String text; 
    final private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    final private boolean death;   
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures; 
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden)
    {
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.death = false;
        this.specificHiddenTreasures = new ArrayList<>();
        this.specificVisibleTreasures = new ArrayList<>();
    }
    public BadConsequence(String text, boolean death)
    {
        this.text = text;
        this.levels = Player.MAXLEVEL;
        this.nVisibleTreasures = MAXTREASURES;
        this.nHiddenTreasures = MAXTREASURES;    
        this.death = death;
        this.specificHiddenTreasures = new ArrayList<>();
        this.specificVisibleTreasures = new ArrayList<>();
    }
    public BadConsequence(String text , int levels,
                            ArrayList<TreasureKind> tVisible,
                            ArrayList<TreasureKind> tHidden)
    {
        this.text = text;
        this.levels = 0;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;    
        this.death = false;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
    
    public String getText()
    {
        return text;
    }
    
    public int getLevels()
    {
        return levels;
    }
    
    public int getNVisisbleTreasures()
    {
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures()
    {
        return nHiddenTreasures;
    }
    
    public boolean getDead()
    {
        return death;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures()
    {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures()
    {
        return specificHiddenTreasures;
    }
    
    public boolean isEmpty()
    {
        return  specificVisibleTreasures.isEmpty() &&
                specificHiddenTreasures.isEmpty() &&
                nVisibleTreasures==0 &&
                nHiddenTreasures==0;
    }
    public void substractVisibleTreasure(Treasure t)
    {
        if(nVisibleTreasures==0)
            specificVisibleTreasures.remove(t.getType());
        else
            nVisibleTreasures = (nVisibleTreasures-1) < 0 ? 0 : nVisibleTreasures-1 ;
    }
    
    public void substractHiddenTreasure(Treasure t)
    {
        if(nHiddenTreasures==0)
            specificHiddenTreasures.remove(t.getType());
        else
                nHiddenTreasures = (nHiddenTreasures-1) < 0 ? 0 : nHiddenTreasures-1 ;    
           
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h)
    {
//        Se pueden dar dos casos, que el bad sea o no de tesoros específicos
        if(!specificVisibleTreasures.isEmpty() || !specificHiddenTreasures.isEmpty())
        { // CASO: solo tesoros especificos
            ArrayList<TreasureKind> newHiddenTreasuresBad = new ArrayList<>();
            ArrayList<TreasureKind> newVisibleTreasuresBad = new ArrayList<>();
            boolean onlyOneV, onlyOneSpecific, add = true;
            for(Treasure t : v) // recorremos V, Hay que hacer lo mismo con H
                if(specificVisibleTreasures.contains(t.getType())) // si el tesoro de v está en los tesoros especificos visible del bad
                {
                    // comprobamos que solo haya un tesoro de un mismo tipo en cada array
                    // ya que puede haber dos tesoros ONEHAND
                    onlyOneV = v.lastIndexOf(t)==v.indexOf(t);
                    onlyOneSpecific = 
                            specificVisibleTreasures.lastIndexOf(t.getType()) ==
                            specificVisibleTreasures.indexOf(t.getType());
                    if(!onlyOneV && onlyOneSpecific)
                    {
                        if(add)
                        {
                            add = false;                 
                            newVisibleTreasuresBad.add(t.getType());            
                        }                                                       
                    }else{                                                                           
                        newVisibleTreasuresBad.add(t.getType());                
                    }
                }
            add = true;    
            for(Treasure t : h) // Oculto a ajustar
                if(specificHiddenTreasures.contains(t.getType()))
                {
                    onlyOneV = h.lastIndexOf(t)==h.indexOf(t);
                    onlyOneSpecific = 
                            specificHiddenTreasures.lastIndexOf(t.getType()) ==
                            specificHiddenTreasures.indexOf(t.getType());
                    if(!onlyOneV && onlyOneSpecific)
                    {
                        if(add)
                        {
                            add = false;
                            newHiddenTreasuresBad.add(t.getType());
                        }
                    }else{
                        newHiddenTreasuresBad.add(t.getType());
                    }
                }
            return new BadConsequence(text, 0, newVisibleTreasuresBad, newHiddenTreasuresBad);
        }
        else
        {
            //Número de tesoros visibles a quitar
            int minVisibleTreasures = nVisibleTreasures > v.size() ? v.size() : nVisibleTreasures;
            int minHiddenTreasures = nHiddenTreasures > h.size() ? h.size() : nHiddenTreasures;
            return new BadConsequence(text, 0, minVisibleTreasures, minHiddenTreasures);
        }

    }
    
    @Override
    public String toString()
    {
        String textoInicial = "\n\tText = " + text + 
                " \n\tLevels = " + Integer.toString(levels) + 
                " \n\tNumber of Visible Treasures = " + Integer.toString(nVisibleTreasures) +
                " \n\tNumber of Hidden Treasures = " + Integer.toString(nHiddenTreasures) +
                " \n\tDeath = " + Boolean.toString(death);
        String textoArrayHiddenTreasures = " \n\tArray Specific Hidden Treasures: ";
        String textoArrayVisibleTreasures = " \n\tArray Specific Visible Treasures: ";
        if(!specificHiddenTreasures.isEmpty())
        {
            for (TreasureKind tk : specificHiddenTreasures)
                textoArrayHiddenTreasures += (tk.toString() + " ");
        }
        else
        {
            textoArrayHiddenTreasures += "No pierde ningún tesoro específico.";
        }
        
        if(!specificVisibleTreasures.isEmpty())
        {
            for (TreasureKind tk : specificVisibleTreasures)
                textoArrayVisibleTreasures += (tk.toString() + " ");
        }
        else
        {
            textoArrayVisibleTreasures += "No pierde ningún tesoro específico.";
        }
        return textoInicial + textoArrayHiddenTreasures + textoArrayVisibleTreasures;
    }
}
  */