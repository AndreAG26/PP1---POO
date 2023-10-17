/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.bingo;

import java.io.File;
import javax.swing.JOptionPane;
import static proyecto1.bingo.enviarCartones.juego;
import proyecto1.logicadenegocios.Juego;
/**
 * Esta clase representa un formulario GUI para generar cartones de bingo.
 * Proporciona una interfaz para que el usuario especifique la cantidad de cartones de bingo que desea generar.
 * Luego, el usuario puede generar la cantidad especificada de cartones de bingo o regresar a la pantalla anterior.
 * Además, la clase proporciona funcionalidad para eliminar cualquier archivo de cartón de bingo existente.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class IniciarJuegoJFrame extends javax.swing.JFrame {

    /**
     * Constructor predeterminado que inicializa los componentes de la GUI.
     */
    public IniciarJuegoJFrame() {
        initComponents();
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        textField1 = new java.awt.TextField();
        Iniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Iniciar juego de bingo");

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Configuración:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jugar en x", "Jugar en z", "Cuatro esquinas", "Cartón lleno" }));

        jLabel3.setText("Premio:");

        textField1.setText("0");

        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(Iniciar)))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(Iniciar)
                .addGap(79, 79, 79)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Controlador de eventos para el campo de texto cartonesAGenerar.
     * Este método se activa cuando el usuario realiza una acción en el campo de texto cartonesAGenerar.
     * Actualmente, este método no contiene ninguna funcionalidad específica.
     * 
     * @param evt El evento de acción.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Controlador de eventos para el botón "Generar".
     * Este método se activa cuando el usuario hace clic en el botón "Generar".
     * Lee la cantidad de cartones de bingo especificada por el usuario, crea la cantidad especificada de cartones de bingo,
     * y luego muestra los cartones de bingo en una nueva ventana.
     * 
     * @param evt El evento de acción.
     */
    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        String valorSeleccionado = (String) jComboBox1.getSelectedItem();
        String textoIngresado = textField1.getText();
        int textoEnInt;
        try{
            textoEnInt=Integer.parseInt(textoIngresado);
            JuegoEnCursoJFrame a = new JuegoEnCursoJFrame();
            a.cargarDatos(juego,valorSeleccionado,textoEnInt);
            a.setVisible(true);
            this.setVisible(false);
        } catch (NumberFormatException  e){
            JOptionPane.showMessageDialog(null, "El premio ingresado no es un número válido" + textoIngresado, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_IniciarActionPerformed
    /**
     * Controlador de eventos para el botón "Regresar".
     * Este método se activa cuando el usuario hace clic en el botón "Regresar".
     * Devuelve al usuario a la pantalla anterior y elimina cualquier archivo de cartón de bingo existente.
     * 
     */
    public Juego cargarDatos(Juego juegoEnCurso){
        return juegoEnCurso;
    }
    
    
    
    
    
    
    /**
     * El método principal que lanza el formulario GUI.
     * 
     * @param args Argumentos de línea de comandos.
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
            java.util.logging.Logger.getLogger(IniciarJuegoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarJuegoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarJuegoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarJuegoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IniciarJuegoJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Iniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private java.awt.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
