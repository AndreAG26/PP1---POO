/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.bingo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import static proyecto1.bingo.enviarCartones.juego;
import proyecto1.logicadenegocios.Carton;
import proyecto1.logicadenegocios.Juego;
import proyecto1.logicadenegocios.Jugador;

/**
 * Esta clase representa una ventana de juego de bingo en curso.
 * La ventana muestra información sobre el tipo de juego, el premio, 
 * los números cantados, el total de cartones y el total de jugadores.
 * También proporciona funcionalidades para cantar un número y terminar el juego.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class JuegoEnCursoJFrame extends javax.swing.JFrame {

    /**
     * Constructor por defecto que inicializa los componentes de la ventana.
     */
    public JuegoEnCursoJFrame() {
        initComponents();
    }
    
    
    public static Juego juego;
    
    /**
     * Carga los datos del juego en curso en la ventana.
     * 
     * @param juegoEnCurso El juego en curso.
     * @param tipoJuego El tipo de juego (por ejemplo, "Jugar en x").
     * @param premio El premio del juego.
     * @return El juego en curso actualizado.
     */
    public Juego cargarDatos(Juego juegoEnCurso,String tipoJuego, int premio){
        
        jLabel2.setText(tipoJuego);
        jLabel4.setText(""+premio);
        ArrayList<Carton> cartonesTotales = juegoEnCurso.getCartones();
        int total=cartonesTotales.size();
        String totalString = String.valueOf(total);
        List<Jugador> jugadoresTotales = juegoEnCurso.getJugadores();
        int totalJUG=jugadoresTotales.size();
        String JG = String.valueOf(totalJUG);
        totalCartones.setText(totalString);
        totalJugadores.setText(JG);
        juego=juegoEnCurso;
        return juegoEnCurso;
    }

    /**
     * Este método inicializa los componentes de la GUI del formulario.
     * Establece el diseño, etiquetas, campos de texto y botones.
     * Este método es generado automáticamente por el Editor de Formularios y no debe ser modificado.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantarNumero = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalCartones = new javax.swing.JLabel();
        totalJugadores = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bolitasSacadas = new javax.swing.JTextArea();
        terminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Tipo de juego:");

        jLabel2.setText(" ");

        jLabel3.setText("Premio:");

        jLabel4.setText(" ");

        cantarNumero.setText("Jugar!");
        cantarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantarNumeroActionPerformed(evt);
            }
        });

        jLabel5.setText("Números cantados:");

        jLabel7.setText("Total cartones:");

        jLabel8.setText("Total de jugadores:");

        totalCartones.setText(" ");

        totalJugadores.setText(" ");

        bolitasSacadas.setColumns(20);
        bolitasSacadas.setRows(5);
        jScrollPane1.setViewportView(bolitasSacadas);

        terminar.setText("Terminar");
        terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(cantarNumero)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalCartones, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(terminar)
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addComponent(cantarNumero)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(totalCartones)
                    .addComponent(totalJugadores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(terminar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que se ejecuta cuando se presiona el botón "Jugar!".
     * Dependiendo del tipo de juego, determina el ganador y muestra los números cantados.
     * 
     * @param evt Evento de acción.
     */
    private void cantarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantarNumeroActionPerformed
        String modoJuego = jLabel2.getText(); // Obtener el texto del jLabel2

        if (null != modoJuego) switch (modoJuego) {
            case "Jugar en x" -> {
                String idCartonGanador = juego.jugarHastaX();
                Jugador jugadorGanador = juego.encontrarJugadorPorIDCarton(idCartonGanador);
                ArrayList<Integer> bolitas = juego.getBolitasSacadas();
                String bolitasString = String.valueOf(bolitas);
                bolitasSacadas.setEditable(false);
                bolitasSacadas.setWrapStyleWord(true);
                bolitasSacadas.setLineWrap(true);
                bolitasSacadas.setText(bolitasString);
                if (jugadorGanador != null) {
                    JOptionPane.showMessageDialog(null,"¡El ganador es " + jugadorGanador.getNombreCompleto() + "! Con el cartón con código "+idCartonGanador);}
                else {
                    JOptionPane.showMessageDialog(null, "El Carton no esta asigado" );
                    
                }  
            }
            case "Jugar en z" -> {
                String idCartonGanador = juego.jugarHastaZ();
                Jugador jugadorGanador = juego.encontrarJugadorPorIDCarton(idCartonGanador);
                ArrayList<Integer> bolitas = juego.getBolitasSacadas();
                String bolitasString = String.valueOf(bolitas);
                bolitasSacadas.setEditable(false);
                bolitasSacadas.setWrapStyleWord(true);
                bolitasSacadas.setLineWrap(true);
                bolitasSacadas.setText(bolitasString);
                if (jugadorGanador != null) {
                    JOptionPane.showMessageDialog(null,"¡El ganador es " + jugadorGanador.getNombreCompleto() + "! Con el cartón con código "+idCartonGanador);}
                else {
                    JOptionPane.showMessageDialog(null, "El Carton no esta asigado" );
                }
            }
            case "Cuatro esquinas" -> {
                String idCartonGanador = juego.jugarHastaCuatroEsquinas();
                Jugador jugadorGanador = juego.encontrarJugadorPorIDCarton(idCartonGanador);
                ArrayList<Integer> bolitas = juego.getBolitasSacadas();
                String bolitasString = String.valueOf(bolitas);
                bolitasSacadas.setEditable(false);
                bolitasSacadas.setWrapStyleWord(true);
                bolitasSacadas.setLineWrap(true);
                bolitasSacadas.setText(bolitasString);
                if (jugadorGanador != null) {
                    JOptionPane.showMessageDialog(null,"¡El ganador es " + jugadorGanador.getNombreCompleto() + "! Con el cartón con código "+idCartonGanador);}
                else {
                    JOptionPane.showMessageDialog(null, "El Carton no esta asigado" );
                }
            }
            case "Cartón lleno" -> {
                String idCartonGanador = juego.jugarHastaLleno();
                Jugador jugadorGanador = juego.encontrarJugadorPorIDCarton(idCartonGanador);
                ArrayList<Integer> bolitas = juego.getBolitasSacadas();
                String bolitasString = String.valueOf(bolitas);
                bolitasSacadas.setEditable(false);
                bolitasSacadas.setWrapStyleWord(true);
                bolitasSacadas.setLineWrap(true);
                bolitasSacadas.setText(bolitasString);
                if (jugadorGanador != null) {
                    JOptionPane.showMessageDialog(null,"¡El ganador es " + jugadorGanador.getNombreCompleto() + "! Con el cartón con código "+idCartonGanador);}
                else {
                    JOptionPane.showMessageDialog(null, "El Carton no esta asigado" );
                }
            }
        }

        

        
    }//GEN-LAST:event_cantarNumeroActionPerformed
    /**
     * Método que se ejecuta cuando se presiona el botón "Terminar".
     * Cierra la ventana actual y regresa al índice. También elimina archivos temporales.
     * 
     * @param evt Evento de acción.
     */
    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
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
    }//GEN-LAST:event_terminarActionPerformed

    /**
     * Método principal para ejecutar la ventana.
     * 
     * @param args Argumentos de línea de comando.
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
            java.util.logging.Logger.getLogger(JuegoEnCursoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoEnCursoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoEnCursoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoEnCursoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JuegoEnCursoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea bolitasSacadas;
    private javax.swing.JButton cantarNumero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton terminar;
    private javax.swing.JLabel totalCartones;
    private javax.swing.JLabel totalJugadores;
    // End of variables declaration//GEN-END:variables
}
