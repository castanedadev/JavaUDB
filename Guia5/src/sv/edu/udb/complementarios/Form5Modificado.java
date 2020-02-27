/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rick
 */
public class Form5Modificado extends javax.swing.JFrame {

    DefaultTableModel dftm;

    /**
     * Creates new form Form5
     */
    public Form5Modificado() {
        initComponents();
        Object[][] datos = {
            {
                String.valueOf("Ricardo"), String.valueOf("Castaneda"),
                String.valueOf("Golf"), Integer.parseInt("10"), TRUE
            },
            {
                String.valueOf("Jose"), String.valueOf("Hernandez"),
                String.valueOf("Swimming"), Integer.parseInt("3"), TRUE
            },
            {
                String.valueOf("El"), String.valueOf("Hopper"),
                String.valueOf("Swimming"), Integer.parseInt("3"), FALSE
            }
        };

        String[] columnas = {"Nombre", "Apellido", "Pasatiempo", "Años de practica", "Soltero(a)"};

        dftm = new DefaultTableModel(datos, columnas);
        jTableDemo.setModel(dftm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lblPasatiempo = new javax.swing.JLabel();
        txtPasatiempo = new javax.swing.JTextField();
        txtPractica = new javax.swing.JTextField();
        lblPractica = new javax.swing.JLabel();
        chkBoxSoltero = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDemo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JTable - Demo");

        lblNombre.setText("Nombre");

        txtNombre.setEnabled(false);

        lblApellido.setText("Apellido");

        txtApellido.setEnabled(false);

        lblPasatiempo.setText("Pasatiempo");

        txtPasatiempo.setEnabled(false);

        txtPractica.setEnabled(false);

        lblPractica.setText("Años de practica");

        chkBoxSoltero.setText("Soltero(a)?");
        chkBoxSoltero.setEnabled(false);

        jTableDemo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableDemo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDemoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDemo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPasatiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPractica, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPractica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPasatiempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(chkBoxSoltero, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre)
                    .addComponent(lblPasatiempo)
                    .addComponent(txtPasatiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkBoxSoltero))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPractica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPractica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableDemoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDemoMouseClicked
        // TODO add your handling code here:
        int rowNumber = jTableDemo.getSelectedRow();

        txtNombre.setEditable(true);
        txtNombre.setEnabled(true);
        txtNombre.setText(jTableDemo.getValueAt(rowNumber, 0).toString());

        txtApellido.setEditable(true);
        txtApellido.setEnabled(true);
        txtApellido.setText(jTableDemo.getValueAt(rowNumber, 1).toString());

        txtPasatiempo.setEditable(true);
        txtPasatiempo.setEnabled(true);
        txtPasatiempo.setText(jTableDemo.getValueAt(rowNumber, 2).toString());

        txtPractica.setEditable(true);
        txtPractica.setEnabled(true);
        txtPractica.setText(jTableDemo.getValueAt(rowNumber, 3).toString());

        chkBoxSoltero.setEnabled(true);
        chkBoxSoltero.setSelected(Boolean.parseBoolean(jTableDemo.getValueAt(rowNumber, 4).toString()));
    }//GEN-LAST:event_jTableDemoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form5Modificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form5Modificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form5Modificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form5Modificado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Form5Modificado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chkBoxSoltero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDemo;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPasatiempo;
    private javax.swing.JLabel lblPractica;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPasatiempo;
    private javax.swing.JTextField txtPractica;
    // End of variables declaration//GEN-END:variables
}
