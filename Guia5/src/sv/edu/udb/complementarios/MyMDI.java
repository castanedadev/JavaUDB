/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.complementarios;

/**
 *
 * @author Rick
 */
public class MyMDI extends javax.swing.JFrame {

    /**
     * Creates new form MyMDI
     */
    public MyMDI() {
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

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jMenuComplementarios = new javax.swing.JMenu();
        menuItemMostrarImagen = new javax.swing.JMenuItem();
        menuItemCalculadoraBasica = new javax.swing.JMenuItem();
        jMenuEjemplos = new javax.swing.JMenu();
        menuItemEj1 = new javax.swing.JMenuItem();
        menuItemEj2 = new javax.swing.JMenuItem();
        menuItemEj3 = new javax.swing.JMenuItem();
        menuItemEj4 = new javax.swing.JMenuItem();
        menuItemEj5 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenuComplementarios.setText("Complementarios");

        menuItemMostrarImagen.setText("Mostrar Imagen");
        menuItemMostrarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMostrarImagenActionPerformed(evt);
            }
        });
        jMenuComplementarios.add(menuItemMostrarImagen);

        menuItemCalculadoraBasica.setText("Calculadora Basica");
        menuItemCalculadoraBasica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCalculadoraBasicaActionPerformed(evt);
            }
        });
        jMenuComplementarios.add(menuItemCalculadoraBasica);

        menuBar.add(jMenuComplementarios);

        jMenuEjemplos.setText("Ejemplos Clase");

        menuItemEj1.setText("Ejemplo 1");
        menuItemEj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEj1ActionPerformed(evt);
            }
        });
        jMenuEjemplos.add(menuItemEj1);

        menuItemEj2.setText("Ejemplo 2");
        menuItemEj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEj2ActionPerformed(evt);
            }
        });
        jMenuEjemplos.add(menuItemEj2);

        menuItemEj3.setText("Ejemplo 3");
        menuItemEj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEj3ActionPerformed(evt);
            }
        });
        jMenuEjemplos.add(menuItemEj3);

        menuItemEj4.setText("Ejemplo 4");
        jMenuEjemplos.add(menuItemEj4);

        menuItemEj5.setText("Ejemplo 5");
        menuItemEj5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEj5ActionPerformed(evt);
            }
        });
        jMenuEjemplos.add(menuItemEj5);

        menuBar.add(jMenuEjemplos);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemMostrarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMostrarImagenActionPerformed
        // TODO add your handling code here:
        InternalFrameMostrarImagenes frameImg = new InternalFrameMostrarImagenes();
        desktopPane.add(frameImg);
        frameImg.show();
    }//GEN-LAST:event_menuItemMostrarImagenActionPerformed

    private void menuItemCalculadoraBasicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCalculadoraBasicaActionPerformed
        // TODO add your handling code here:
        InternalFrameCalculadora frameCalc = new InternalFrameCalculadora();
        desktopPane.add(frameCalc);
        frameCalc.show();
    }//GEN-LAST:event_menuItemCalculadoraBasicaActionPerformed

    private void menuItemEj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEj1ActionPerformed
        Ejercicio1 ej1 =  new Ejercicio1();
        desktopPane.add(ej1);
        ej1.show();
    }//GEN-LAST:event_menuItemEj1ActionPerformed

    private void menuItemEj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEj2ActionPerformed
        // TODO add your handling code here:
        Ejercicio2 ej2 =  new Ejercicio2();
        desktopPane.add(ej2);
        ej2.show();
    }//GEN-LAST:event_menuItemEj2ActionPerformed

    private void menuItemEj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEj3ActionPerformed
        Ejercicio3 ej3 =  new Ejercicio3();
        desktopPane.add(ej3);
        ej3.show();
    }//GEN-LAST:event_menuItemEj3ActionPerformed

    private void menuItemEj5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEj5ActionPerformed
        Ejercicio5 ej5 =  new Ejercicio5();
        desktopPane.add(ej5);
        ej5.show();
    }//GEN-LAST:event_menuItemEj5ActionPerformed

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
            java.util.logging.Logger.getLogger(MyMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyMDI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyMDI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenuComplementarios;
    private javax.swing.JMenu jMenuEjemplos;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemCalculadoraBasica;
    private javax.swing.JMenuItem menuItemEj1;
    private javax.swing.JMenuItem menuItemEj2;
    private javax.swing.JMenuItem menuItemEj3;
    private javax.swing.JMenuItem menuItemEj4;
    private javax.swing.JMenuItem menuItemEj5;
    private javax.swing.JMenuItem menuItemMostrarImagen;
    // End of variables declaration//GEN-END:variables

}
