/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author Salva
 */
public class CardDealer {
    //    Implementación singleton
    //    Su intención consiste en garantizar que una clase sólo tenga una instancia 
    //    y proporcionar un punto de acceso global a ella.
    private static final CardDealer instance = new CardDealer();
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Cultist> unusedCultists;
    
    // El constructor privado no permite que se genere un constructor por defecto.
    // (con mismo modificador de acceso que la definición de la clase)    
    private CardDealer()
    {
    }
    
    public static CardDealer getInstance()
    {
        return instance;
    }
    
    private void initTreasureCardDeck()
    {
        usedTreasures = new ArrayList<>();
        unusedTreasures = new ArrayList<>();
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación",3, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora Thompson", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la UGR", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necro-playboycon", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-comicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necro-gnomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycón",3,TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentácula de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
    }

    private void initMonsterCardDeck()
    {
        usedMonsters = new ArrayList<>();
        unusedMonsters = new ArrayList<>();
        BadConsequence badConsequence;
        Prize prize;
        
        /* 3 byankhees de bonanza */
        badConsequence = new SpecificBadConsequence("Pierdes tu armadura visible y "
                + "\n\totra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("3 byankhees de bonanza", 8 , badConsequence, prize));
        
        /* Chubithulhu */
        badConsequence = new SpecificBadConsequence("Embobados con el lindo primigenio "
                + "\n\tte descartas de tu casco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Chubithulhu",2, badConsequence, prize));
        
        /*El sopor de Dunwich*/ 
        badConsequence = new SpecificBadConsequence("El primordial bostezo contagioso. "
                + "\n\tPierdes el calzado visible.", 0, 
                new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2, badConsequence, prize));
        
         
        /* Ángeles de la noche ibicenca */
        badConsequence = new SpecificBadConsequence("Te atrapan para llevarte de fiesta "
                + "\n\ty te dejan caer en mitad del vuelo. Descarta 1 mano visible "
                + "\n\ty 1 mano oculta", 0,
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca", 14, 
                badConsequence, prize));
        
        /* El gorrón en el umbral */
        badConsequence = new NumericBadConsequence("Pierdes todos tus tesoros visibles", 0,
        BadConsequence.MAXTREASURES,0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",10, badConsequence, prize));
        
        /* H.P. Munchcraft */
        badConsequence = new SpecificBadConsequence("Pierdes la armadura visible", 0,
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        /* Bichgooth */
        badConsequence = new SpecificBadConsequence("Sientes bichos bajo la ropa. "
                + "\n\tDescarta la armadura visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2, badConsequence,prize));
        
        /* El rey de la rosa */
        badConsequence = new NumericBadConsequence("Pierdes 5 niveles y "
                + "\n\t3 tesoros visibles", 5, 3, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        /* La que redacta en las tinieblas */
        badConsequence = new NumericBadConsequence("Toses los pulmones y pierdes dos "
                + "\n\tniveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2, 
                badConsequence, prize));
 
        /* Los hondos */
        badConsequence = new DeathBadConsequence("Estos monstruos resultan bastante "
                + "superficiales y te aburren mortalmente");
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos",8, badConsequence, prize));
        
        /* Semillas Cthulhu */
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles y 2 tesoros "
                + "\n\tocultos", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        /* Dameargo */
        badConsequence = new SpecificBadConsequence("Te intentas escaquear. Pierdes una "
                + "\n\tmano visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        /* Pollipólipo volante */
        badConsequence = new NumericBadConsequence("Da mucho asquito. Pierdes 3 niveles",
                3, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        /* Yskhtihyssg-Goth */
        badConsequence = new DeathBadConsequence("No le hace gracia que pronuncien "
                + "\n\tmal su nombre. Estas muerto");
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, badConsequence, prize));
        
        /* Familia feliz */
        badConsequence = new DeathBadConsequence("La familia te atrapa. Estas muerto");
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        /* Roboggoth */
        badConsequence = new SpecificBadConsequence("La quinta directiva primaria te "
                + "\n\tobliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),
                new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        
        /* El espia */
        badConsequence = new SpecificBadConsequence("Te asusta en la noche. Pierdes un "
                + "\n\tcasco visible", 0, 
                new ArrayList(Arrays.asList(TreasureKind.HELMET)), 
                new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espia", 5, badConsequence, prize));
        
        /* El Lenguas */
        badConsequence = new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 "
                + "\n\tniveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas" , 20, badConsequence, prize));
        
        /* Bicéfalo */

        badConsequence = new SpecificBadConsequence("Te faltan manos para tanta cabeza. " +
                         "\n\tPierdes 3 niveles y tus tesoros visibles de las manos", 3,
                         new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo", 20, badConsequence, prize));
        
         // NUEVOS MONSTRUOS CON SECTARIOS
        
        /* El mal indecible impronunciable */
        badConsequence = new SpecificBadConsequence("Pierdes 1 mano visible.", 0,
                         new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, badConsequence, prize, -2));
        
        /* Testigos Oculares */
        badConsequence = new NumericBadConsequence("Pierdes tus tesoros visibles. Jajaja.", 0, Integer.MAX_VALUE, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares", 6, badConsequence, prize, 2));

        /* El gran cthulhu */
        badConsequence = new DeathBadConsequence("Hoy no es tu día de suerte. Mueres.");
        prize = new Prize(2,5);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, badConsequence, prize, 4));

        /* Serpiente Político */
        badConsequence = new NumericBadConsequence("Tu gobierno te recorta 2 niveles", 2, 0, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente Político", 8, badConsequence, prize, -2));

        /* Felpuggoth */
        badConsequence = new SpecificBadConsequence("Pierdes tu casco y tu armadura visible. " +
                         " Pierdes tus manos ocultas", 0,
                         new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.HELMET)), new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth", 2, badConsequence, prize, 5));

        /* Shoggoth */
        badConsequence = new NumericBadConsequence("Pierdes 2 niveles", 2, 0, 0);
        prize = new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth", 16, badConsequence, prize, -4));

        /* Lolitagooth */
        badConsequence = new NumericBadConsequence("Pintalabios negro. Pierdes " +
                         " 2 niveles", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth", 2, badConsequence, prize, 3));
        
    }
    
    private void initCultistCardDeck()
    {
        //cartas de jugador sectario
        unusedCultists = new ArrayList<>();
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n No puedes dejar de ser sectario.", 1));
        unusedCultists.add(new Cultist("+2 por cada sectario en juego."+"\n No puedes dejar de ser sectario.", 2));
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n No puedes dejar de ser sectario.", 1));
        unusedCultists.add(new Cultist("+2 por cada sectario en juego."+"\n No puedes dejar de ser sectario.", 2));
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n No puedes dejar de ser sectario.", 1));
        unusedCultists.add(new Cultist("+1 por cada sectario en juego."+"\n No puedes dejar de ser sectario.", 1));
    }

    private void shuffleTreasures()
    {
        Collections.shuffle(unusedTreasures);
    }
        
    private void shuffleMonsters()
    {
        Collections.shuffle(unusedMonsters);
    }
    private void shuffleCultists()
    {
        Collections.shuffle(unusedCultists);
    }

    public Treasure nextTreasure() //Habría que probarlo para asegurarse de que funciona
    {
        if(unusedTreasures.isEmpty())
        {
            Collections.shuffle(usedTreasures);
            unusedTreasures = (ArrayList<Treasure>) usedTreasures.clone(); 
            usedTreasures.clear();                          
        }                                                   
        Treasure tesoro = unusedTreasures.remove(0);
        usedTreasures.add(tesoro);
        return tesoro;
    }

    public Monster nextMonster()
    {
        if(unusedMonsters.isEmpty())
        {
            Collections.shuffle(usedMonsters);
            unusedMonsters = (ArrayList<Monster>) usedMonsters.clone();
            usedMonsters.clear();                         
        }                                                 
        Monster monstruo = unusedMonsters.remove(0);
        usedMonsters.add(monstruo);
        return monstruo; 
    }
    public Cultist nextCultist()
    {
        return unusedCultists.remove(0);
    }

    public void initCards() // el llamador de estos métodos es this
    {
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.initCultistCardDeck();
        this.shuffleMonsters();
        this.shuffleTreasures();
        this.shuffleCultists();
    }

    public void giveTreasureBack(Treasure t)
    {
        usedTreasures.add(t);
        unusedTreasures.remove(t);
    }

    public void giveMonsterBack(Monster m)
    {
        usedMonsters.add(m);
        unusedMonsters.remove(m);
    }   
}