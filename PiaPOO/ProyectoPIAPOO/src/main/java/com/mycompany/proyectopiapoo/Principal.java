
package com.mycompany.proyectopiapoo;


import java.sql.Connection;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {
    
    Conexion enlace = new Conexion();
    Connection conectado = enlace.conectar();
    
        
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Principal.class.getName());

    public Principal() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        this.M_Operaciones.setVisible(false);
        this.MI_IngProv.setVisible(false);
        this.MI_IngMerc.setVisible(false);
        this.MI_IngArt.setVisible(false);
        this.MI_IngIns.setVisible(false);
        this.MI_AdmArt.setVisible(false);
        this.MI_AdmIns.setVisible(false);
        this.MI_AdmMerc.setVisible(false);
        this.MI_AdmProv.setVisible(false);
        this.MR_Calculo.setVisible(false);
        this.MR_Compras.setVisible(false);
        this.MR_ListadoArt.setVisible(false);
        this.MR_ListadoArtSol.setVisible(false);
        this.MR_Saldos.setVisible(false);
        this.MR_TotalVtaArt.setVisible(false);
        this.MR_TotalVtaFec.setVisible(false);
        this.Separa1.setVisible(false);
        this.Separa2.setVisible(false);
        this.Separa3.setVisible(false);
        this.Separa4.setVisible(false);
        this.Separa5.setVisible(false);
 
        this.Separa7.setVisible(false);
        
          

    }

    public void probar_conexion()
    {
        if (conectado == null){
            JOptionPane.showMessageDialog(null, "Conexión Fallida", "AVISO",2);
        }else {
            JOptionPane.showMessageDialog(null, "Conexión Establecida Satisfactoriamente","AVISO",1);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MI_IngEmp = new javax.swing.JMenuItem();
        MI_AdmEmp = new javax.swing.JMenuItem();
        Separa1 = new javax.swing.JPopupMenu.Separator();
        MI_IngProv = new javax.swing.JMenuItem();
        MI_AdmProv = new javax.swing.JMenuItem();
        Separa2 = new javax.swing.JPopupMenu.Separator();
        MI_IngMerc = new javax.swing.JMenuItem();
        MI_AdmMerc = new javax.swing.JMenuItem();
        Separa3 = new javax.swing.JPopupMenu.Separator();
        MI_IngIns = new javax.swing.JMenuItem();
        MI_AdmIns = new javax.swing.JMenuItem();
        Separa4 = new javax.swing.JPopupMenu.Separator();
        MI_IngArt = new javax.swing.JMenuItem();
        MI_AdmArt = new javax.swing.JMenuItem();
        Separa5 = new javax.swing.JPopupMenu.Separator();
        Separa6 = new javax.swing.JPopupMenu.Separator();
        MI_Salir = new javax.swing.JMenuItem();
        M_Operaciones = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ML_ListadoEmpleados = new javax.swing.JMenuItem();
        Separa7 = new javax.swing.JPopupMenu.Separator();
        MR_ListadoArt = new javax.swing.JMenuItem();
        MR_TotalVtaFec = new javax.swing.JMenuItem();
        MR_TotalVtaArt = new javax.swing.JMenuItem();
        MR_ListadoArtSol = new javax.swing.JMenuItem();
        MR_Saldos = new javax.swing.JMenuItem();
        MR_Calculo = new javax.swing.JMenuItem();
        MR_Compras = new javax.swing.JMenuItem();
        ME_Evaluar = new javax.swing.JMenu();
        ME_Conexion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Administrativo");

        Escritorio.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setName("Sistema Administrativo"); // NOI18N

        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Personales Esther\\Sanchez Avila Melina\\FCFM\\Quinto Semestre\\system_file_manager_16954.png")); // NOI18N
        jMenu1.setText("Informacion");

        MI_IngEmp.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MI_IngEmp.setText("Ingresar Empleados");
        MI_IngEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_IngEmpActionPerformed(evt);
            }
        });
        jMenu1.add(MI_IngEmp);

        MI_AdmEmp.setText("Administrar Empleados");
        MI_AdmEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_AdmEmpActionPerformed(evt);
            }
        });
        jMenu1.add(MI_AdmEmp);
        jMenu1.add(Separa1);

        MI_IngProv.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MI_IngProv.setText("Ingresar Proveedores");
        MI_IngProv.setEnabled(false);
        MI_IngProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_IngProvActionPerformed(evt);
            }
        });
        jMenu1.add(MI_IngProv);

        MI_AdmProv.setText("Administrar Preveedores");
        MI_AdmProv.setEnabled(false);
        jMenu1.add(MI_AdmProv);
        jMenu1.add(Separa2);

        MI_IngMerc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MI_IngMerc.setText("Ingresar Mercados");
        MI_IngMerc.setEnabled(false);
        jMenu1.add(MI_IngMerc);

        MI_AdmMerc.setText("Administrar Mercados");
        MI_AdmMerc.setEnabled(false);
        jMenu1.add(MI_AdmMerc);
        jMenu1.add(Separa3);

        MI_IngIns.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MI_IngIns.setText("Ingresar Insumos");
        MI_IngIns.setEnabled(false);
        MI_IngIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_IngInsActionPerformed(evt);
            }
        });
        jMenu1.add(MI_IngIns);

        MI_AdmIns.setText("Administrar Insumos");
        MI_AdmIns.setEnabled(false);
        jMenu1.add(MI_AdmIns);
        jMenu1.add(Separa4);

        MI_IngArt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MI_IngArt.setText("Ingresar Articulos");
        MI_IngArt.setEnabled(false);
        MI_IngArt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_IngArtActionPerformed(evt);
            }
        });
        jMenu1.add(MI_IngArt);

        MI_AdmArt.setText("Administrar Articulos");
        MI_AdmArt.setEnabled(false);
        jMenu1.add(MI_AdmArt);
        jMenu1.add(Separa5);
        jMenu1.add(Separa6);

        MI_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_DOWN_MASK));
        MI_Salir.setText("Salir");
        MI_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_SalirActionPerformed(evt);
            }
        });
        jMenu1.add(MI_Salir);

        jMenuBar1.add(jMenu1);

        M_Operaciones.setBorder(null);
        M_Operaciones.setIcon(new javax.swing.ImageIcon("C:\\Personales Esther\\Sanchez Avila Melina\\FCFM\\Quinto Semestre\\System_Binary_35450.png")); // NOI18N
        M_Operaciones.setText("Operaciones");

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem8.setText("Saldos Diarios");
        jMenuItem8.setEnabled(false);
        M_Operaciones.add(jMenuItem8);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem6.setText("Ventas");
        jMenuItem6.setEnabled(false);
        M_Operaciones.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem7.setText("Compras");
        jMenuItem7.setEnabled(false);
        M_Operaciones.add(jMenuItem7);
        M_Operaciones.add(jSeparator3);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItem9.setText("Control Inventarios");
        jMenuItem9.setEnabled(false);
        M_Operaciones.add(jMenuItem9);

        jMenuBar1.add(M_Operaciones);

        jMenu3.setBorder(null);
        jMenu3.setIcon(new javax.swing.ImageIcon("C:\\Personales Esther\\Sanchez Avila Melina\\FCFM\\Quinto Semestre\\TextoPlano_35449.png")); // NOI18N
        jMenu3.setText("Listados");
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });

        ML_ListadoEmpleados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        ML_ListadoEmpleados.setText("Listado de Empleados");
        ML_ListadoEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ML_ListadoEmpleadosActionPerformed(evt);
            }
        });
        jMenu3.add(ML_ListadoEmpleados);
        jMenu3.add(Separa7);

        MR_ListadoArt.setText("Listado de Articulos");
        MR_ListadoArt.setEnabled(false);
        jMenu3.add(MR_ListadoArt);

        MR_TotalVtaFec.setText("Total Venta/Fecha");
        MR_TotalVtaFec.setEnabled(false);
        jMenu3.add(MR_TotalVtaFec);

        MR_TotalVtaArt.setText("Total Venta/Articulo");
        MR_TotalVtaArt.setEnabled(false);
        jMenu3.add(MR_TotalVtaArt);

        MR_ListadoArtSol.setText("Listado de Articulos A Solicitar");
        MR_ListadoArtSol.setEnabled(false);
        MR_ListadoArtSol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MR_ListadoArtSolActionPerformed(evt);
            }
        });
        jMenu3.add(MR_ListadoArtSol);

        MR_Saldos.setText("Saldos por Pagar");
        MR_Saldos.setEnabled(false);
        jMenu3.add(MR_Saldos);

        MR_Calculo.setText("Calculo de Comisiones");
        MR_Calculo.setEnabled(false);
        jMenu3.add(MR_Calculo);

        MR_Compras.setText("Compras Pendientes de Recepcion");
        MR_Compras.setEnabled(false);
        jMenu3.add(MR_Compras);

        jMenuBar1.add(jMenu3);

        ME_Evaluar.setBorder(null);
        ME_Evaluar.setIcon(new javax.swing.ImageIcon("C:\\Personales Esther\\Sanchez Avila Melina\\FCFM\\Quinto Semestre\\system_applications_apple_writing_13033.png")); // NOI18N
        ME_Evaluar.setText("Evaluar");

        ME_Conexion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_DOWN_MASK));
        ME_Conexion.setText("Conexion");
        ME_Conexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ME_ConexionActionPerformed(evt);
            }
        });
        ME_Evaluar.add(ME_Conexion);

        jMenuBar1.add(ME_Evaluar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MI_IngProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_IngProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_IngProvActionPerformed

    private void MR_ListadoArtSolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MR_ListadoArtSolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MR_ListadoArtSolActionPerformed

    private void MI_IngEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_IngEmpActionPerformed
        // ABRIR VENTANA DE EMPLEADOS:
        for (java.awt.Component comp : Escritorio.getComponents()){
           if (comp instanceof W_Empleados){
               comp.setVisible(true);
               comp.requestFocus();
               return;
           }
       }
        W_Empleados verventana = new W_Empleados();
        Escritorio.add(verventana);
        int x = (Escritorio.getWidth() - verventana.getWidth())/2;
        int y = (Escritorio.getHeight()- verventana.getHeight())/2;
        verventana.setLocation(x, y);
        verventana.show();    
    }//GEN-LAST:event_MI_IngEmpActionPerformed

   
    
    private void ME_ConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ME_ConexionActionPerformed
        // CHECAR SI SE PUEDE CONECTAR
        probar_conexion();
    }//GEN-LAST:event_ME_ConexionActionPerformed

    private void MI_IngInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_IngInsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_IngInsActionPerformed

    private void MI_IngArtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_IngArtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MI_IngArtActionPerformed

    private void MI_AdmEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_AdmEmpActionPerformed
       for (java.awt.Component comp : Escritorio.getComponents()){
           if (comp instanceof W_Administar_Empleados){
               comp.setVisible(true);
               comp.requestFocus();
               return;
           }
       }
        W_Administar_Empleados verventanaadmin = new W_Administar_Empleados();
        Escritorio.add(verventanaadmin);
        int x = (Escritorio.getWidth() - verventanaadmin.getWidth())/2;
        int y = (Escritorio.getHeight()- verventanaadmin.getHeight())/2;
        verventanaadmin.setLocation(x, y);
        verventanaadmin.show();
        
        
    }//GEN-LAST:event_MI_AdmEmpActionPerformed

    private void MI_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_SalirActionPerformed
    System.exit(0);        
    }//GEN-LAST:event_MI_SalirActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed

        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void ML_ListadoEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ML_ListadoEmpleadosActionPerformed
        for (java.awt.Component comp : Escritorio.getComponents()){
           if (comp instanceof W_Listado_Empleados){
               comp.setVisible(true);
               comp.requestFocus();
               return;
           }
       }
        W_Listado_Empleados verventanaadmin = new W_Listado_Empleados();
        Escritorio.add(verventanaadmin);
        int x = (Escritorio.getWidth() - verventanaadmin.getWidth())/2;
        int y = (Escritorio.getHeight()- verventanaadmin.getHeight())/2;
        verventanaadmin.setLocation(x, y);
        verventanaadmin.show();
    }//GEN-LAST:event_ML_ListadoEmpleadosActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Escritorio;
    private javax.swing.JMenuItem ME_Conexion;
    private javax.swing.JMenu ME_Evaluar;
    private javax.swing.JMenuItem MI_AdmArt;
    private javax.swing.JMenuItem MI_AdmEmp;
    private javax.swing.JMenuItem MI_AdmIns;
    private javax.swing.JMenuItem MI_AdmMerc;
    private javax.swing.JMenuItem MI_AdmProv;
    private javax.swing.JMenuItem MI_IngArt;
    private javax.swing.JMenuItem MI_IngEmp;
    private javax.swing.JMenuItem MI_IngIns;
    private javax.swing.JMenuItem MI_IngMerc;
    private javax.swing.JMenuItem MI_IngProv;
    private javax.swing.JMenuItem MI_Salir;
    private javax.swing.JMenuItem ML_ListadoEmpleados;
    private javax.swing.JMenuItem MR_Calculo;
    private javax.swing.JMenuItem MR_Compras;
    private javax.swing.JMenuItem MR_ListadoArt;
    private javax.swing.JMenuItem MR_ListadoArtSol;
    private javax.swing.JMenuItem MR_Saldos;
    private javax.swing.JMenuItem MR_TotalVtaArt;
    private javax.swing.JMenuItem MR_TotalVtaFec;
    private javax.swing.JMenu M_Operaciones;
    private javax.swing.JPopupMenu.Separator Separa1;
    private javax.swing.JPopupMenu.Separator Separa2;
    private javax.swing.JPopupMenu.Separator Separa3;
    private javax.swing.JPopupMenu.Separator Separa4;
    private javax.swing.JPopupMenu.Separator Separa5;
    private javax.swing.JPopupMenu.Separator Separa6;
    private javax.swing.JPopupMenu.Separator Separa7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

    private void generarReporte() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
