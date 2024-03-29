/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 *
 * @author Salva
 */
public class PlayerNamesCapture extends javax.swing.JDialog {

    /**
     * Creates new form PlayerNamesCapture
     */
    private ArrayList<String> names = new ArrayList(3); // almacen nombre de los jugadores
    public PlayerNamesCapture(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.addWindowListener (new WindowAdapter() 
        {
            @Override
            public void windowClosing (WindowEvent e) 
            {
                System.exit(0);
            }
        }); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLPlayer1 = new javax.swing.JLabel();
        jLPlayer2 = new javax.swing.JLabel();
        jLPlayer3 = new javax.swing.JLabel();
        jTFPlayer1 = new javax.swing.JTextField();
        jTFPlayer2 = new javax.swing.JTextField();
        jTFPlayer3 = new javax.swing.JTextField();
        jBPlay = new javax.swing.JButton();
        jBCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLPlayer1.setText("Player 1");

        jLPlayer2.setText("Player 2");

        jLPlayer3.setText("Player 3");

        jBPlay.setText("Play");
        jBPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBPlayMouseClicked(evt);
            }
        });

        jBCancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLPlayer1)
                        .addGap(18, 18, 18)
                        .addComponent(jTFPlayer1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLPlayer3)
                        .addGap(18, 18, 18)
                        .addComponent(jTFPlayer3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLPlayer2)
                        .addGap(18, 18, 18)
                        .addComponent(jTFPlayer2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBPlay)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancel)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPlayer1)
                    .addComponent(jTFPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPlayer2)
                    .addComponent(jTFPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPlayer3)
                    .addComponent(jTFPlayer3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBPlay)
                    .addComponent(jBCancel))
                .addGap(102, 102, 102))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBPlayMouseClicked
        names.add(jTFPlayer1.getText());
        names.add(jTFPlayer2.getText());
        names.add(jTFPlayer3.getText());
        this.dispose();
    }//GEN-LAST:event_jBPlayMouseClicked

    /**
     * @param args the command line arguments
     */
    public ArrayList<String> getNames() 
    {
        this.setVisible(true);
        return names;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBPlay;
    private javax.swing.JLabel jLPlayer1;
    private javax.swing.JLabel jLPlayer2;
    private javax.swing.JLabel jLPlayer3;
    private javax.swing.JTextField jTFPlayer1;
    private javax.swing.JTextField jTFPlayer2;
    private javax.swing.JTextField jTFPlayer3;
    // End of variables declaration//GEN-END:variables
}
