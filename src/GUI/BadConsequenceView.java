/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.BadConsequence;
import Model.SpecificBadConsequence;
import Model.NumericBadConsequence;
import Model.DeathBadConsequence;
import Model.TreasureKind;
import java.util.ArrayList;

/**
 *
 * @author xehartnort
 */
public class BadConsequenceView extends javax.swing.JPanel {

    
    private BadConsequence badConsequenceModel;
    /**
     * Creates new form BadConsequenceView
     */
    public BadConsequenceView() {
        initComponents();
    }
    
    public void setBadConsequence(BadConsequence b)
    {
        badConsequenceModel=b;
        level.setVisible(false);
        nTreasuresV.setVisible(false);
        nTreasuresH.setVisible(false);
        dead.setVisible(false);
        specificVisibleTreasures.setVisible(false);
        specificVisibleTreasures.setText("");
        specificHiddenTreasures.setVisible(false);
        specificHiddenTreasures.setText("");
        if(badConsequenceModel instanceof SpecificBadConsequence)
        {
            ArrayList<TreasureKind> ts = ((SpecificBadConsequence)badConsequenceModel).getSpecificVisibleTreasures();
            String text="";
            for(TreasureKind t :ts)
            {
                switch (t)
                {
                    case ARMOR:
                        text +="Armadura, ";
                        break;
                    case ONEHAND:
                        text += "Una Mano, ";
                        break;
                    case BOTHHANDS:
                        text += "Dos manos, ";
                        break;
                    case HELMET:
                        text += "Casco, ";
                        break;
                    case SHOE:
                        text += "Calzado, ";
                }
            }
            specificVisibleTreasures.setText(text);
            text="";
            ts = ((SpecificBadConsequence)badConsequenceModel).getSpecificHiddenTreasures();
            for(TreasureKind t :ts)
            {
                switch (t)
                {
                    case ARMOR:
                        text +="Armadura, ";
                        break;
                    case ONEHAND:
                        text += "Una Mano, ";
                        break;
                    case BOTHHANDS:
                        text += "Dos manos, ";
                        break;
                    case HELMET:
                        text += "Casco, ";
                        break;
                    case SHOE:
                        text += "Calzado, ";
                }
            }
            specificHiddenTreasures.setText(text);
            specificHiddenTreasures.setVisible(true);
            specificVisibleTreasures.setVisible(true);
        }
        else if (badConsequenceModel instanceof NumericBadConsequence)
        {
            nTreasuresV.setText(Integer.toString(((NumericBadConsequence)badConsequenceModel).getNVisibleTreasures()));
            nTreasuresV.setVisible(true);
            nTreasuresH.setText(Integer.toString(((NumericBadConsequence)badConsequenceModel).getNHiddenTreasures()));
            nTreasuresH.setVisible(true);
        }
        else
        {
            dead.setVisible(true);
        }
        level.setText(Integer.toString(badConsequenceModel.getLevels()));
        this.text.setText(badConsequenceModel.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextPane();
        level = new javax.swing.JLabel();
        nTreasuresV = new javax.swing.JLabel();
        nTreasuresH = new javax.swing.JLabel();
        dead = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        specificVisibleTreasures = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        specificHiddenTreasures = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createTitledBorder("BadConsequence"));

        jScrollPane2.setViewportView(text);

        level.setText("Perdida de nivel:");

        nTreasuresV.setText("Numero de T. Visibles");

        nTreasuresH.setText("Numero de T. Ocultos");

        dead.setText("Mata");

        specificVisibleTreasures.setColumns(20);
        specificVisibleTreasures.setRows(5);
        jScrollPane1.setViewportView(specificVisibleTreasures);

        specificHiddenTreasures.setColumns(20);
        specificHiddenTreasures.setRows(5);
        jScrollPane3.setViewportView(specificHiddenTreasures);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nTreasuresV)
                            .addComponent(level)
                            .addComponent(nTreasuresH)
                            .addComponent(dead))
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel1))
                            .addComponent(level))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTreasuresV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTreasuresH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dead)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Mal Royo");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dead;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel level;
    private javax.swing.JLabel nTreasuresH;
    private javax.swing.JLabel nTreasuresV;
    private javax.swing.JTextArea specificHiddenTreasures;
    private javax.swing.JTextArea specificVisibleTreasures;
    private javax.swing.JTextPane text;
    // End of variables declaration//GEN-END:variables
}