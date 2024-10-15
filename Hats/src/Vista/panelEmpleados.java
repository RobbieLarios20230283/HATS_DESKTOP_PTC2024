/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Controlador.ctrlEmpleados;
import Modelo.Empleados;


/**
 *
 * @author Admin
 */
public class panelEmpleados extends javax.swing.JPanel {

    /**
     * Creates new form panelEmpleados
     */
    public panelEmpleados() {
        initComponents();
        
        Empleados modelo = new Empleados();
        panelEmpleados vista = this;
        ctrlEmpleados Controlador = new ctrlEmpleados(modelo, vista);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombrePerfilEmp = new javax.swing.JTextField();
        txtTelefonoEmp = new javax.swing.JTextField();
        txtCorreoEmp = new javax.swing.JTextField();
        txtfechanaEmp = new javax.swing.JTextField();
        txtDireccionEmp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbEmpleados = new javax.swing.JTable();
        btnActualizarEmp = new javax.swing.JButton();
        btnEliminarEmp = new javax.swing.JButton();
        btnLimiparEmp = new javax.swing.JButton();
        txtNombreEmp = new javax.swing.JTextField();
        txtDuiEmp = new javax.swing.JTextField();
        txtContraseñaEmp = new javax.swing.JTextField();

        setBackground(new java.awt.Color(212, 244, 235));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombrePerfilEmp.setText("jTextField1");
        txtNombrePerfilEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtNombrePerfilEmp.setMinimumSize(new java.awt.Dimension(71, 22));
        txtNombrePerfilEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombrePerfilEmpActionPerformed(evt);
            }
        });
        add(txtNombrePerfilEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 224, 42));

        txtTelefonoEmp.setText("jTextField2");
        txtTelefonoEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtTelefonoEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoEmpActionPerformed(evt);
            }
        });
        add(txtTelefonoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 220, 40));

        txtCorreoEmp.setText("jTextField3");
        txtCorreoEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtCorreoEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 220, 40));

        txtfechanaEmp.setText("jTextField4");
        txtfechanaEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtfechanaEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 224, 42));

        txtDireccionEmp.setText("jTextField6");
        txtDireccionEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtDireccionEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 224, 42));

        jtbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtbEmpleados);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 309, 971, 373));

        btnActualizarEmp.setBackground(new java.awt.Color(188, 234, 213));
        btnActualizarEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnActualizarEmp.setText("Actualizar");
        add(btnActualizarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, 110, 40));

        btnEliminarEmp.setBackground(new java.awt.Color(188, 234, 213));
        btnEliminarEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarEmp.setText("Eliminar");
        btnEliminarEmp.setPreferredSize(new java.awt.Dimension(89, 27));
        add(btnEliminarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 110, 40));

        btnLimiparEmp.setBackground(new java.awt.Color(188, 234, 213));
        btnLimiparEmp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLimiparEmp.setText("Limpiar");
        btnLimiparEmp.setPreferredSize(new java.awt.Dimension(89, 27));
        add(btnLimiparEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 110, 40));

        txtNombreEmp.setText("jTextField1");
        txtNombreEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtNombreEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 220, 40));

        txtDuiEmp.setText("jTextField1");
        txtDuiEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtDuiEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 224, 42));

        txtContraseñaEmp.setText("jTextField2");
        txtContraseñaEmp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add(txtContraseñaEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 224, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombrePerfilEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombrePerfilEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePerfilEmpActionPerformed

    private void txtTelefonoEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoEmpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarEmp;
    public javax.swing.JButton btnEliminarEmp;
    public javax.swing.JButton btnLimiparEmp;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbEmpleados;
    public javax.swing.JTextField txtContraseñaEmp;
    public javax.swing.JTextField txtCorreoEmp;
    public javax.swing.JTextField txtDireccionEmp;
    public javax.swing.JTextField txtDuiEmp;
    public javax.swing.JTextField txtNombreEmp;
    public javax.swing.JTextField txtNombrePerfilEmp;
    public javax.swing.JTextField txtTelefonoEmp;
    public javax.swing.JTextField txtfechanaEmp;
    // End of variables declaration//GEN-END:variables
}
