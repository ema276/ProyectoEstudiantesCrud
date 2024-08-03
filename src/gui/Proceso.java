package gui;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Proceso extends javax.swing.JFrame {

    public Proceso() {
        initComponents();
        this.setLocationRelativeTo(null);
        arrancar();
    }
    
    public void arrancar(){
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1; i<=100;i++){
                    try {
                        barra.setValue(i);
                        lblPorcentaje.setText(i+"%");
                        Thread.sleep(35);
                        if (i == 100){
                            listar_datos ld = new listar_datos();
                            ld.setVisible(true);
                            setVisible(false);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        hilo.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barra = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 680, 60));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("CARGANDO SISTEMA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 200, -1));

        lblPorcentaje.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblPorcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPorcentaje.setText("0%");
        getContentPane().add(lblPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 75, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proceso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proceso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPorcentaje;
    // End of variables declaration//GEN-END:variables
}
