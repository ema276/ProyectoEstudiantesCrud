package gui;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.datos;
import servicios.conexion;
import servicios.datosServicios;

public class guardar_datos extends javax.swing.JFrame {

    private final datosServicios datos_serv = new datosServicios();
    private final datos dat;
    
    public guardar_datos() {
        this.dat = new datos();
        initComponents();
    }
    
    public guardar_datos(datos p_dat){
        this.dat = p_dat;
        initComponents();
        txtNombre.setText(this.dat.getNombre());
        txtEstatus.setText(this.dat.getEstatus());
        txtMunicipio.setText(this.dat.getMunicipio());
        txtEstado.setText(this.dat.getEstado());
        txtDocumentos.setText(this.dat.getDocumentos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        b_guardar = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();
        txtMunicipio = new javax.swing.JTextField();
        txtDocumentos = new javax.swing.JTextField();
        txtEstatus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 60, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 250, -1));

        jLabel2.setText("Estatus");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 50, -1));

        jLabel3.setText("Documentos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 80, -1));

        b_guardar.setText("Guardar");
        b_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(b_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        b_cancel.setText("Cancelar");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(b_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 80, 30));
        getContentPane().add(txtMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, -1));
        getContentPane().add(txtDocumentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 250, -1));
        getContentPane().add(txtEstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 250, -1));

        jLabel5.setText("Municipio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 70, 20));

        jLabel6.setText("Estado");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));
        getContentPane().add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 250, -1));

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setText("Estudiante");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 120, 40));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setText("Registro del ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 120, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_guardarActionPerformed
        // TODO add your handling code here:
        if(this.validar()){
            this.guardar();
        }else{
            JOptionPane.showMessageDialog(this, "Hay campos incompletos.");
        }
    }//GEN-LAST:event_b_guardarActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        // TODO add your handling code here:
        guardar_datos.this.dispose();
        listar_datos vista = new listar_datos();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_b_cancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try{
            conexion.cerrar();
            System.out.println("Conexión cerrada.");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private boolean validar(){
        boolean validado = true;
        String nombre = txtNombre.getText();
        String estatus = txtEstatus.getText();
        String municipio = txtMunicipio.getText();
        String estado = txtEstado.getText();
        String documentos = txtDocumentos.getText();
        if(!nombre.trim().equals("") && !estatus.trim().equals("") && !municipio.trim().equals("")
                && !estado.trim().equals("") && !documentos.trim().equals("")){
            validado = true;
        }else{
            validado = false;
        }
        return validado;
    }
    
    private void guardar(){
        String nombre = txtNombre.getText();
        String estatus = txtEstatus.getText();
        String municipio = txtMunicipio.getText();
        String estado = txtEstado.getText();
        String documentos = txtDocumentos.getText();
        this.dat.setNombre(nombre);
        this.dat.setEstatus(estatus);
        this.dat.setMunicipio(municipio);
        this.dat.setEstado(estado);
        this.dat.setDocumentos(documentos);
        try{
            this.datos_serv.guardar(conexion.obtener(), this.dat);
            guardar_datos.this.dispose();
            listar_datos vista = new listar_datos();
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido guardar el registro.");
        }
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guardar_datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtDocumentos;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstatus;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
