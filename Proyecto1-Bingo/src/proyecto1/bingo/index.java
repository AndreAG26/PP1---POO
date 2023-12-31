/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.bingo;

import java.io.File;
import javax.swing.JOptionPane;



/**
 * La clase <code>index</code> representa la ventana principal de la aplicación de bingo.
 * Esta interfaz gráfica de usuario (GUI) permite a los usuarios iniciar un juego de bingo,
 * registrar jugadores y acceder a estadísticas relacionadas con el juego.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class index extends javax.swing.JFrame {

    /**
     * Constructor que inicializa la ventana principal de la aplicación.
     */
    public index() {
        initComponents();
    }

    /**
     * Método generado automáticamente para inicializar los componentes de la GUI.
     * NOTA: No se debe modificar este código. El contenido de este método siempre
     * es regenerado por el editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        IniciarJuegoBT = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        IniciarJuego = new javax.swing.JMenu();
        estadisticas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        wordCloud = new javax.swing.JMenu();
        BTNregistrarJugador = new javax.swing.JMenu();
        registrar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Gestor de Bingos");

        IniciarJuegoBT.setText("Iniciar Juego");
        IniciarJuegoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarJuegoBTActionPerformed(evt);
            }
        });

        jMenuBar1.add(IniciarJuego);

        estadisticas.setText("Estadísticas");

        jMenuItem2.setText("Top 10 números cantados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        estadisticas.add(jMenuItem2);

        jMenuItem3.setText("Frecuencia histórica de partidas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        estadisticas.add(jMenuItem3);

        jMenuBar1.add(estadisticas);

        wordCloud.setText("WordCloud");
        jMenuBar1.add(wordCloud);

        BTNregistrarJugador.setText("Jugador");
        BTNregistrarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNregistrarJugadorActionPerformed(evt);
            }
        });

        registrar.setText("Registar");
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        BTNregistrarJugador.add(registrar);

        jMenuBar1.add(BTNregistrarJugador);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(IniciarJuegoBT))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(IniciarJuegoBT)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que se ejecuta al presionar el botón "Iniciar Juego".
     * Inicia un nuevo juego de bingo y muestra la ventana para generar cartones.
     * 
     * @param evt Evento del botón.
     */
    private void IniciarJuegoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarJuegoBTActionPerformed
        
        // La carpeta no está vacía
        GenerarCartones a = new GenerarCartones();
        a.setVisible(true);
        this.setVisible(false);  
        IniciarJuego.setEnabled(false);
        
    }//GEN-LAST:event_IniciarJuegoBTActionPerformed
    /**
     * Método que se ejecuta al seleccionar la opción "Registrar" en el menú "Jugador".
     * Muestra la ventana para registrar un nuevo jugador.
     * 
     * @param evt Evento del menú.
     */
    private void BTNregistrarJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNregistrarJugadorActionPerformed
        
    }//GEN-LAST:event_BTNregistrarJugadorActionPerformed
    /**
     * Método que se ejecuta al seleccionar la opción "Registrar" en el menú "Jugador".
     * Muestra la ventana para registrar un nuevo jugador.
     * 
     * @param evt Evento del menú.
     */
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        registrarJugador a = new registrarJugador();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_registrarActionPerformed
    /**
     * Método que se ejecuta al seleccionar la opción "Top 10 números cantados" en el menú "Estadísticas".
     * Muestra una ventana con los 10 números más cantados en el juego.
     * 
     * @param evt Evento del menú.
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Top10Numeros a = new Top10Numeros();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    /**
     * Método que se ejecuta al seleccionar la opción "Frecuencia histórica de partidas" en el menú "Estadísticas".
     * Muestra una ventana con la frecuencia histórica de las partidas jugadas.
     * 
     * @param evt Evento del menú.
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrecuenciaConfiPartidas a = new FrecuenciaConfiPartidas();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    
    /**
     * Método principal que inicia la aplicación.
     * 
     * @param args Argumentos de la línea de comandos.
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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu BTNregistrarJugador;
    private javax.swing.JMenu IniciarJuego;
    private javax.swing.JButton IniciarJuegoBT;
    private javax.swing.JMenu estadisticas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem registrar;
    private javax.swing.JMenu wordCloud;
    // End of variables declaration//GEN-END:variables
}
