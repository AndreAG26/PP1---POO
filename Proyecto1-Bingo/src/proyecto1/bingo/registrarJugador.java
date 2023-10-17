/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.bingo;

import java.io.File;
import javax.swing.JOptionPane;
import proyecto1.logicadenegocios.ConexionDB;
import proyecto1.logicadenegocios.Jugador;
import proyecto1.dao.daoJugador;


/**
 * Esta clase representa un formulario GUI para registrar un jugador en un juego de Bingo.
 * El formulario permite al usuario ingresar el nombre completo del jugador, la dirección de correo electrónico y el número de identificación (Cédula).
 * Una vez proporcionada la información, el usuario puede hacer clic en el botón "Registrar" para guardar los detalles del jugador.
 * También hay un botón "Regresar" que permite al usuario volver al índice principal.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class registrarJugador extends javax.swing.JFrame {
    
    /**
     * Constructor predeterminado que inicializa los componentes GUI.
     */
    public registrarJugador() {
        initComponents();
    }

    /**
     * Este método es llamado desde el constructor para inicializar el formulario.
     * ADVERTENCIA: NO modifique este código. El contenido de este método siempre es regenerado por el Editor de Formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea1 = new java.awt.TextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cedJugador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nomJugador = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        correoJugador = new javax.swing.JTextField();
        registrarJugadorBT = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Registrar Jugador");

        jLabel2.setText("Nombre completo:");

        cedJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedJugadorActionPerformed(evt);
            }
        });

        jLabel3.setText("Correo electrónico:");

        jLabel4.setText("Cédula:");

        registrarJugadorBT.setText("Registrar");
        registrarJugadorBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarJugadorBTActionPerformed(evt);
            }
        });

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(nomJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(correoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(registrarJugadorBT)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(correoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(cedJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registrarJugadorBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Acción realizada cuando se hace clic en el botón "Registrar".
     * Este método intenta registrar un nuevo jugador guardando sus detalles.
     * 
     * @param evt Objeto ActionEvent que representa el evento de clic en el botón.
     */
    private void registrarJugadorBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarJugadorBTActionPerformed
        // TODO add your handling code here:7
        daoJugador dao = new daoJugador();
        String nombre= nomJugador.getText();
        String correo= correoJugador.getText();
        int cedula=Integer.parseInt(cedJugador.getText());
        try{
            if (nombre.equals("")||correo.equals("")||cedJugador.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Error: No pueden haber espacios vacíos.");
                return;
            }
            
            Jugador jugador= new Jugador(cedula, nombre, correo);
            
            if(dao.insertJugador(jugador)){
                JOptionPane.showMessageDialog(null, "SE AGREGÓ");
            }else{
                JOptionPane.showMessageDialog(null, "ERROR. *Insert DB");
            }
        }catch (Exception e2){
            JOptionPane.showMessageDialog(null, "ERROR");
        }
       
    }//GEN-LAST:event_registrarJugadorBTActionPerformed
    /**
     * Acción realizada cuando se hace clic o se modifica el campo de texto "Cédula".
     * 
     * @param evt Objeto ActionEvent que representa el evento del campo de texto.
     */
    private void cedJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedJugadorActionPerformed
    /**
     * Acción realizada cuando se hace clic en el botón "Regresar".
     * Este método devuelve al usuario al índice principal y elimina cualquier archivo temporal.
     * 
     * @param evt Objeto ActionEvent que representa el evento de clic en el botón.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        index volver = new index();
        volver.setVisible(true);
        this.setVisible(false);        

        // Dirección de la carpeta
        File carpeta = new File("C:/Users/Daniel/Documents/GitHub/PP1---POO/Proyecto1-Bingo/src/Cartones/");

        // Lista de todos los archivos JPG en la carpeta
        File[] archivosJPG = carpeta.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));

        // Si hay archivos JPG, eliminarlos
        if (archivosJPG != null) {
            for (File archivo : archivosJPG) {
                archivo.delete();
            }
        }    
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Método principal para ejecutar el formulario registrarJugador.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
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
            java.util.logging.Logger.getLogger(GenerarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarCartones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cedJugador;
    private javax.swing.JTextField correoJugador;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nomJugador;
    private javax.swing.JButton registrarJugadorBT;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
