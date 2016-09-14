package GUI;

import Model.Treasure;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Salva
 */
public class TreasureView extends javax.swing.JPanel {

    /**
     * Creates new form TreasureView
     */
    Treasure treasureMode;
    public TreasureView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLNombre = new javax.swing.JLabel();
        jLBonus = new javax.swing.JLabel();
        jLTipo = new javax.swing.JLabel();

        jLNombre.setText("Nombre:");

        jLBonus.setText("Bonus:");

        jLTipo.setText("Tipo de tesoro:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLNombre)
                    .addComponent(jLBonus)
                    .addComponent(jLTipo))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLBonus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLTipo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void setTreasure(Treasure t)
    {
        treasureMode=t;
        jLNombre.setText("Nombre: "+t.getName());
        jLBonus.setText("Bonus: "+ t.getBonus());
        switch (t.getType())
        {
            case ARMOR:
                jLTipo.setText("Tipo: Armadura");
                break;
            case ONEHAND:
                jLTipo.setText("Tipo: Una mano");
                break;
            case BOTHHANDS:
                jLTipo.setText("Tipo: Dos manos");
                break;
            case HELMET:
                jLTipo.setText("Tipo: Casco");
                break;
            case SHOE:
                jLTipo.setText("Tipo: Calzado");
        }
        this.repaint(); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLBonus;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JLabel jLTipo;
    // End of variables declaration//GEN-END:variables
}
