package gui;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.datos;
import servicios.conexion;
import servicios.datosServicios;

public class listar_datos extends javax.swing.JFrame {

    private final datosServicios datos_serv = new datosServicios();
    private List<datos> list_datos;
    
    public listar_datos() {
        initComponents();
        this.cargar_datos_estudiantes();
    }
    
    private void cargar_datos_estudiantes(){
        try{
            this.list_datos = this.datos_serv.list_recuperar(conexion.obtener());
            DefaultTableModel dtm = (DefaultTableModel) jtContenido.getModel();
            dtm.setRowCount(0);
            for(int i = 0; i < this.list_datos.size(); i++){
                dtm.addRow(new Object[]{
                    this.list_datos.get(i).getId(),
                    this.list_datos.get(i).getNombre(),
                    this.list_datos.get(i).getEstatus(),
                    this.list_datos.get(i).getMunicipio(),
                    this.list_datos.get(i).getEstado(),
                    this.list_datos.get(i).getDocumentos(),
                });
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
        }catch(ClassNotFoundException ex){
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtContenido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        b_crear = new javax.swing.JButton();
        b_modif = new javax.swing.JButton();
        b_eliminar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtContenido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Estatus", "Municipio", "Estado", "Documentos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtContenido);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 610, 240);

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jLabel1.setText("ESTUDIANTES");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(30, 30, 240, 16);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 630, 320));

        jToolBar1.setRollover(true);

        b_crear.setText("Crear");
        b_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_crearActionPerformed(evt);
            }
        });
        jToolBar1.add(b_crear);

        b_modif.setText("Modificar");
        b_modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_modifActionPerformed(evt);
            }
        });
        jToolBar1.add(b_modif);

        b_eliminar.setText("Eliminar");
        b_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_eliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(b_eliminar);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 30));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_crearActionPerformed
        // TODO add your handling code here:
        listar_datos.this.dispose();
        guardar_datos vista = new guardar_datos();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_b_crearActionPerformed

    private void b_modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_modifActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jtContenido.getSelectedRow();
        if(fila_seleccionada >= 0){
            listar_datos.this.dispose();
            guardar_datos vista = new guardar_datos(this.list_datos.get(fila_seleccionada));
            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
    }//GEN-LAST:event_b_modifActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try{
            conexion.cerrar();
            System.out.println("Conexión cerrada.");
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void b_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_eliminarActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = jtContenido.getSelectedRow();
        if(fila_seleccionada >= 0){            
            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar este estudiante?", "Advertencia", JOptionPane.YES_NO_OPTION);            
            if(decision == 0){
                try{
                    this.datos_serv.eliminar(conexion.obtener(), this.list_datos.get(fila_seleccionada));
                    this.cargar_datos_estudiantes();
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.");
                }catch(ClassNotFoundException ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(this, "Ha surgido un error y no se ha podido eliminar el registro.");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
        }
    }//GEN-LAST:event_b_eliminarActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listar_datos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_crear;
    private javax.swing.JButton b_eliminar;
    private javax.swing.JButton b_modif;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtContenido;
    // End of variables declaration//GEN-END:variables
}
