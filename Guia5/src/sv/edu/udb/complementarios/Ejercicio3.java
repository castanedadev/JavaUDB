/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import sv.edu.udb.desarrollo.FrameUtils;

/**
 *
 * @author Rick
 */
public class Ejercicio3 extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ejercicio3
     */
    public Ejercicio3() {
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

        lblTitulo = new javax.swing.JLabel();
        comboBoxOptions = new javax.swing.JComboBox<>();
        lblImagen = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Guia 5 - Ejercicio 3");

        lblTitulo.setText("Seleccionar una imagen");

        comboBoxOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Opcion 1", "Opcion 2", "Opcion 3" }));
        comboBoxOptions.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxOptionsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(comboBoxOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(lblTitulo)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxOptionsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxOptionsItemStateChanged
        // TODO add your handling code here:
        String prueba;
        prueba = (String) this.comboBoxOptions.getSelectedItem();

        if (prueba.equals("Opcion 1")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/sv/edu/udb/desarrollo/img/apex-1.jpg"));
            lblImagen.setIcon((Icon) FrameUtils.getScaledImage(icon.getImage(), 200, 200));
        }
        if (prueba.equals("Opcion 2")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/sv/edu/udb/desarrollo/img/apex-2.jpg"));
            lblImagen.setIcon((Icon) FrameUtils.getScaledImage(icon.getImage(), 200, 200));
        }
        if (prueba.equals("Opcion 3")) {
            ImageIcon icon = new ImageIcon(getClass().getResource("/sv/edu/udb/desarrollo/img/apex-3.jpg"));
            lblImagen.setIcon((Icon) FrameUtils.getScaledImage(icon.getImage(), 200, 200));
        }
        if (prueba.equals("-")) {
            lblImagen.setIcon(null);
        }
    }//GEN-LAST:event_comboBoxOptionsItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxOptions;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
