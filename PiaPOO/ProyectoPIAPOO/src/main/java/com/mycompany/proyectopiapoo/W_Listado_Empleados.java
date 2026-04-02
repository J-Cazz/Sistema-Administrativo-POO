package com.mycompany.proyectopiapoo;
/*
//  Autor: Melina Sánchez Avila
//  Proyecto: Sistema De Admon de Inventario
//  Clase: W_Listado_Empleados 
//  ** Lista los Empleados de acuerdo al filtro y los exporta a Archivos CSV, TXT, Excel **
//  Version: 1.00      Fecha Creacion: 11/Octubre/2025
*/
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class W_Listado_Empleados extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
    Connection conectado = enlace.conectar();
    LimpiezaEmpleados limpieza = new LimpiezaEmpleados();  
    
    public W_Listado_Empleados() {  
        initComponents();
        limpieza.limpiarCampos(this.getContentPane()); 
        InicializaCampos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        P_Busqueda = new javax.swing.JPanel();
        B_Buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CB_opcion = new javax.swing.JComboBox<>();
        Fecha1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        Fecha2 = new com.toedter.calendar.JDateChooser();
        ChB_status = new javax.swing.JCheckBox();
        ChB_fechas = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        T_ListadoEmpleados = new javax.swing.JTable();
        B_Exportar = new javax.swing.JButton();
        B_Salir = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Empleados");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        P_Busqueda.setBackground(new java.awt.Color(204, 204, 255));
        P_Busqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtrar por . . .", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        B_Buscar.setText("Buscar");
        B_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Status de Empleado:");

        jLabel2.setText("Rango de Fechas");

        CB_opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Baja", " ", " " }));
        CB_opcion.setEnabled(false);

        Fecha1.setEnabled(false);

        jLabel4.setText("A:");

        Fecha2.setEnabled(false);

        ChB_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChB_statusActionPerformed(evt);
            }
        });
        ChB_status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ChB_statusKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ChB_statusKeyTyped(evt);
            }
        });

        ChB_fechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChB_fechasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout P_BusquedaLayout = new javax.swing.GroupLayout(P_Busqueda);
        P_Busqueda.setLayout(P_BusquedaLayout);
        P_BusquedaLayout.setHorizontalGroup(
            P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_BusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_BusquedaLayout.createSequentialGroup()
                        .addComponent(ChB_status)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(P_BusquedaLayout.createSequentialGroup()
                        .addComponent(ChB_fechas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_BusquedaLayout.createSequentialGroup()
                        .addComponent(Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CB_opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(B_Buscar)
                .addGap(75, 75, 75))
        );
        P_BusquedaLayout.setVerticalGroup(
            P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_BusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(P_BusquedaLayout.createSequentialGroup()
                        .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(CB_opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ChB_status))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ChB_fechas))))
                            .addComponent(Fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, P_BusquedaLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(B_Buscar)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        T_ListadoEmpleados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowindex, int colindex){
                return false;
            }
        };
        T_ListadoEmpleados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        T_ListadoEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_ListadoEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(T_ListadoEmpleados);

        B_Exportar.setText("Exportar..");
        B_Exportar.setEnabled(false);
        B_Exportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ExportarActionPerformed(evt);
            }
        });

        B_Salir.setText("Salir");
        B_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(P_Busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B_Exportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_Salir)
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(P_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_Exportar)
                    .addComponent(B_Salir))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BuscarActionPerformed
       String opstatus = null;
       String SQLWhere = null;
       String f1 = null;
       String f2 = null;
       
       T_ListadoEmpleados.clearSelection();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
       
       if (Fecha1.getDate() != null) {
            f1 = sdf.format(Fecha1.getDate());
        }
        if (Fecha2.getDate() != null) {
            f2 = sdf.format(Fecha2.getDate());
        }    
       if (ChB_status.isSelected() && !ChB_fechas.isSelected()) 
       { //Si el status esta marcado y las fechas no
           opstatus = CB_opcion.getSelectedItem().toString();
           SQLWhere = " WHERE status_emp = '" + opstatus + "'" ;
       }
       if (ChB_status.isSelected() && ChB_fechas.isSelected()) 
        { //Si el status esta marcado y las fechas tambien
            opstatus = CB_opcion.getSelectedItem().toString();
            SQLWhere = " WHERE status_emp = '" + opstatus + "' AND Fecha_Contrato_Emp between " + f1 + " AND " + f2 ;
         }
        if (!ChB_status.isSelected() && ChB_fechas.isSelected()) 
        {  //Si el Status no y las fechas si
            SQLWhere = " WHERE Fecha_Contrato_Emp between " + f1 + " AND " + f2 ;
        }
        if (!ChB_status.isSelected() && !ChB_fechas.isSelected())
        {   //Ninguno 
            SQLWhere="";
        }
        
        java.util.Date fecha1 = Fecha1.getDate();
        java.util.Date fecha2 = Fecha2.getDate();      
        // La fecha 1 no puede ser mayor a fecha 2
        if (fecha1.after(fecha2)) {
            JOptionPane.showMessageDialog(null, "El Rango de Fechas es Incorrecto\n" + "     Favor de corregirlo!!","AVISO",2);
            Fecha1.requestFocusInWindow();
            return;
        }
            
        DefaultTableModel T_Empleados = new DefaultTableModel();  
        T_ListadoEmpleados.setModel(T_Empleados);

        T_Empleados.addColumn("ID");
        T_Empleados.addColumn("Nombre Completo");
        T_Empleados.addColumn("F. Nac.");
        T_Empleados.addColumn("Direccion");
        T_Empleados.addColumn("Comisión");
        T_Empleados.addColumn("CURP");
        T_Empleados.addColumn("RFC");
        T_Empleados.addColumn("Sexo");
        T_Empleados.addColumn("F. Ing.");
        T_Empleados.addColumn("Status");
        T_Empleados.addColumn("E_Mail");
        T_Empleados.addColumn("Tel. 1");
        T_Empleados.addColumn("Tel. 2");
        T_ListadoEmpleados.setModel(T_Empleados);
        
        String SQLText = "SELECT id_empleado,nom_empleado,"
                    + "DATE_FORMAT(fecha_nac_emp, '%d/%b/%Y') AS fecha_nac,"
                    + "CONCAT(calle_emp, ' No. ', Num_Ext_Emp, ', Col. ',Colonia_Emp, ', ',Ciudad_Emp, ', ',Estado_Emp, ' C.P. ',Codigo_Postal_Emp) AS direccion,"
                    + "CONCAT(ROUND(Comision_Emp, 2), '%') AS Comision,CURP_Emp,RFC_Emp,"
                    + "CASE WHEN Sexo_Emp = 'M' THEN 'Masculino' ELSE 'Femenino' END AS Sexo, "
                    + "DATE_FORMAT(Fecha_Contrato_Emp, '%d/%b/%Y') AS fecha_contrato,Status_Emp,E_Mail_Emp,Telefono1_Emp, Telefono2_Emp "
                    + "FROM empleados " + SQLWhere;

        String []datos = new String[13];
        try {
            Statement Leer = conectado.createStatement();
            ResultSet Resultado = Leer.executeQuery(SQLText);
            boolean tieneDatos = false;
            while(Resultado.next()){
                tieneDatos = true; // al menos hay una fila
                datos[0] = Resultado.getString(1);  //ID
                datos[1] = Resultado.getString(2);  //Nombre
                datos[2] = Resultado.getString(3);  //Fec Nac
                datos[3] = Resultado.getString(4);  //Direccion
                datos[4] = Resultado.getString(5);  //Comision
                datos[5] = Resultado.getString(6);  //Curp
                datos[6] = Resultado.getString(7);  //RFC
                datos[7] = Resultado.getString(8);  //Sexo
                datos[8] = Resultado.getString(9);  //Fecha Ingreso
                datos[9] = Resultado.getString(10);  //Status
                datos[10] = Resultado.getString(11); //E_Mail
                datos[11] = Resultado.getString(12); //Tel1
                datos[12] = Resultado.getString(13); //Tel2
                T_Empleados.addRow(datos);
            }
            if (!tieneDatos) {
                javax.swing.JOptionPane.showMessageDialog(null, "No Hay Registros con ese Flitro\n" + "Por Favor, Intetar de Nuevo!!","AVISO",2);
                B_Exportar.setEnabled(false);
            }else{
                B_Exportar.setEnabled(true);
            }
            T_ListadoEmpleados.setModel(T_Empleados);
            T_ListadoEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            T_ListadoEmpleados.getColumnModel().getColumn(3).setPreferredWidth(500);
            T_ListadoEmpleados.getColumnModel().getColumn(10).setPreferredWidth(300);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + ". Error en la Consulta!!","AVISO",2);
        }
    }//GEN-LAST:event_B_BuscarActionPerformed
    

public void exportarTablaCSV(JTable tabla, String rutaArchivo) {
    try {
        TableModel modelo = tabla.getModel();
        FileWriter archivo = new FileWriter(rutaArchivo);
        PrintWriter pw = new PrintWriter(archivo);

        // Escribir encabezados
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            pw.print(modelo.getColumnName(i));
            if (i != modelo.getColumnCount() - 1) {
                pw.print(",");
            }
        }
        pw.println();

        // Escribir filas
        for (int i = 0; i < modelo.getRowCount(); i++) {
            for (int j = 0; j < modelo.getColumnCount(); j++) {
                Object valor = modelo.getValueAt(i, j);
                // Escapar comas en los datos
                String celda = valor != null ? valor.toString().replace(",", " ") : "";
                pw.print(celda);
                if (j != modelo.getColumnCount() - 1) {
                    pw.print(",");
                }
            }
            pw.println();
        }

        pw.close();
        archivo.close();

        javax.swing.JOptionPane.showMessageDialog(null, " ** Exportación Completada **\n" + rutaArchivo);

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(null, "¡¡ Error al Exportar !! \n" + e.getMessage());
    }
}

    private void InicializaCampos() {
        T_ListadoEmpleados.setRowSelectionAllowed(false);
        T_ListadoEmpleados.setColumnSelectionAllowed(false);
        T_ListadoEmpleados.clearSelection();
        B_Exportar.setEnabled(false);
        CB_opcion.setSelectedIndex(0);
        Fecha1.setDate(new Date());
        Fecha2.setDate(new Date());
    }      
    
    private void B_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SalirActionPerformed
        DefaultTableModel model = (DefaultTableModel) T_ListadoEmpleados.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);

        // Limpia selección y campos
        B_Exportar.setEnabled(false);
        T_ListadoEmpleados.clearSelection();
        limpieza.limpiarCampos(this.getContentPane());
        limpieza.Check1ListadoEmpleados(CB_opcion,false);
        limpieza.Check2ListadoEmpleados(Fecha1,Fecha2,false);

        // Cierra el InternalFrame
        dispose();      
    }//GEN-LAST:event_B_SalirActionPerformed

    private void ChB_statusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChB_statusKeyPressed

    }//GEN-LAST:event_ChB_statusKeyPressed

    private void ChB_statusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChB_statusKeyTyped
       
    }//GEN-LAST:event_ChB_statusKeyTyped

    private void ChB_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChB_statusActionPerformed

        if (!ChB_status.isSelected()){
            limpieza.Check1ListadoEmpleados(CB_opcion,false);
        }else{
            limpieza.Check1ListadoEmpleados(CB_opcion,true);
        }
    }//GEN-LAST:event_ChB_statusActionPerformed

    private void ChB_fechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChB_fechasActionPerformed
         if (!ChB_fechas.isSelected()){
            limpieza.Check2ListadoEmpleados(Fecha1,Fecha2,false);
        }else{
            limpieza.Check2ListadoEmpleados(Fecha1,Fecha2,true);
        }
    }//GEN-LAST:event_ChB_fechasActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        DefaultTableModel model = (DefaultTableModel) T_ListadoEmpleados.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
       
    }//GEN-LAST:event_formInternalFrameClosed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
 
    }//GEN-LAST:event_formInternalFrameClosing

    private void B_ExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ExportarActionPerformed
        //javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        //int seleccion = chooser.showSaveDialog(this);

        JFileChooser chooser = new JFileChooser();

        // Filtrar para CSV, TXT y Excel
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
            "Archivos CSV, TXT, Excel", "csv", "txt", "xls", "xlsx");
        chooser.setFileFilter(filtro);

        int seleccion = chooser.showSaveDialog(this); 

        if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().getAbsolutePath();
            // Agregar extensión .csv si no existe
           if (!ruta.toLowerCase().endsWith(".csv") &&
                !ruta.toLowerCase().endsWith(".txt") &&
                !ruta.toLowerCase().endsWith(".xls")) {

                // Por ejemplo, agregar CSV por defecto
                ruta += ".xls";
            }
            exportarTablaCSV(T_ListadoEmpleados, ruta);
        }
        // Preguntar si desea realizar otra consulta
        int opcion = javax.swing.JOptionPane.showConfirmDialog(this,
                "¿Desea Hacer otra Consulta?",
                "Pregunta",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (opcion == javax.swing.JOptionPane.YES_OPTION) {
            // Limpiar tabla y campos
            DefaultTableModel model = (DefaultTableModel) T_ListadoEmpleados.getModel();
            model.setRowCount(0);
            model.setColumnCount(0);
            B_Exportar.setEnabled(false);
            limpieza.limpiarCampos(this.getContentPane());
            limpieza.Check1ListadoEmpleados(CB_opcion, false);
            limpieza.Check2ListadoEmpleados(Fecha1, Fecha2, false);

        } else {
            // Salir de la ventana
            dispose();
        }
    }//GEN-LAST:event_B_ExportarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Buscar;
    private javax.swing.JButton B_Exportar;
    private javax.swing.JButton B_Salir;
    private javax.swing.JComboBox<String> CB_opcion;
    private javax.swing.JCheckBox ChB_fechas;
    private javax.swing.JCheckBox ChB_status;
    private com.toedter.calendar.JDateChooser Fecha1;
    private com.toedter.calendar.JDateChooser Fecha2;
    private javax.swing.JPanel P_Busqueda;
    private javax.swing.JTable T_ListadoEmpleados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
