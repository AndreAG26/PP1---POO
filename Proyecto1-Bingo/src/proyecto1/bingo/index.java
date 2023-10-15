/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1.bingo;



/**
 *
 * @author Daniel
 */
public class index extends javax.swing.JFrame {

    /**
     * Creates new form index
     */
    public index() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        IniciarJuegoBT = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        generarCartones = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        verCarton = new javax.swing.JMenuItem();
        IniciarJuego = new javax.swing.JMenu();
        EnviarCarton = new javax.swing.JMenu();
        estadisticas = new javax.swing.JMenu();
        wordCloud = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Gestor de Bingos");

        IniciarJuegoBT.setText("Iniciar Juego");
        IniciarJuegoBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarJuegoBTActionPerformed(evt);
            }
        });

        generarCartones.setText("Cartones");

        jMenuItem4.setText("Generar cartones");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        generarCartones.add(jMenuItem4);

        verCarton.setText("Ver cartones");
        verCarton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCartonActionPerformed(evt);
            }
        });
        generarCartones.add(verCarton);

        jMenuBar1.add(generarCartones);
        jMenuBar1.add(IniciarJuego);

        EnviarCarton.setText("Enviar Cartón");
        EnviarCarton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarCartonActionPerformed(evt);
            }
        });
        jMenuBar1.add(EnviarCarton);

        estadisticas.setText("Estadísticas");
        jMenuBar1.add(estadisticas);

        wordCloud.setText("WordCloud");
        jMenuBar1.add(wordCloud);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(143, 143, 143))
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(IniciarJuegoBT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(IniciarJuegoBT)
                .addGap(95, 95, 95))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verCartonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCartonActionPerformed
        verCarton verCartonesForm = new verCarton();
        verCartonesForm.setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_verCartonActionPerformed

    private void EnviarCartonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarCartonActionPerformed
        enviarCartones formEnviarCartones=new enviarCartones();
        formEnviarCartones.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_EnviarCartonActionPerformed

    private void IniciarJuegoBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarJuegoBTActionPerformed
        IniciarJuego.setEnabled(false);
    }//GEN-LAST:event_IniciarJuegoBTActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        GenerarCartones a = new GenerarCartones();
        a.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    
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
    private javax.swing.JMenu EnviarCarton;
    private javax.swing.JMenu IniciarJuego;
    private javax.swing.JButton IniciarJuegoBT;
    private javax.swing.JMenu estadisticas;
    private javax.swing.JMenu generarCartones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JMenuItem verCarton;
    private javax.swing.JMenu wordCloud;
    // End of variables declaration//GEN-END:variables
}
