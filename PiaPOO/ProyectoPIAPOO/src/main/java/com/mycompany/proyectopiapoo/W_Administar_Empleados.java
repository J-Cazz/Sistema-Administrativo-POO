package com.mycompany.proyectopiapoo;

/*
//  Autor: Melina Sánchez Avila
//  Proyecto: Sistema De Admon de Inventario
//  Clase: W_Administrar_Empleados 
//  ** Modifica y Da de Baja a los Empleados **
//  Version: 1.00      Fecha Creacion: 11/Octubre/2025
*/
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class W_Administar_Empleados extends javax.swing.JInternalFrame {

    Conexion enlace = new Conexion();
    Connection conectado = enlace.conectar();
    LimpiezaEmpleados limpieza = new LimpiezaEmpleados();
    
    public W_Administar_Empleados() {
        initComponents();
        
        limpieza.limpiarCampos(this.getContentPane());
        limpieza.BotonesAdminEmp(B_Modificar, false);
        limpieza.CamposAdminEmp(Nom_Empleado,E_Mail,Telefono_1,Telefono_2,CB_Status,false);
        Texto_busqueda.setEnabled(false);
        CB_opcion.setSelectedIndex(0);
    }

    public void MostrarDatosEmpleado(int opbuscar, String valor){
        
        DefaultTableModel T_Empleados = new DefaultTableModel();
        T_Empleados = new DefaultTableModel();
        Tabla_Empleados.setModel(T_Empleados);

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
        Tabla_Empleados.setModel(T_Empleados);

        String SQLText = null;
    
        if (opbuscar == 0){
            // BUSQUEDA DE TODOS
            SQLText = "SELECT id_empleado,nom_empleado,"
                    + "DATE_FORMAT(fecha_nac_emp, '%d/%b/%Y') AS fecha_nac,"
                    + "CONCAT(calle_emp, ' No. ', Num_Ext_Emp, ', Col. ',Colonia_Emp, ', ',Ciudad_Emp, ', ',Estado_Emp, ' C.P. ',Codigo_Postal_Emp) AS direccion,"
                    + "CONCAT(ROUND(Comision_Emp, 2), '%') AS Comision,CURP_Emp,RFC_Emp,"
                    + "CASE WHEN Sexo_Emp = 'M' THEN 'Masculino' ELSE 'Femenino' END AS Sexo, "
                    + "DATE_FORMAT(Fecha_Contrato_Emp, '%d/%b/%Y') AS fecha_contrato,Status_Emp,E_Mail_Emp,Telefono1_Emp, Telefono2_Emp "
                    + "FROM empleados WHERE Status_Emp = 'Activa'";
        }else {
            //BUSQUEDA POR IDENTIFICACION
            if (opbuscar == 1 && valor != null){
                SQLText = "SELECT id_empleado,nom_empleado,"
                    + "DATE_FORMAT(fecha_nac_emp, '%d/%b/%Y') AS fecha_nac,"
                    + "CONCAT(calle_emp, ' No. ', Num_Ext_Emp, ', Col. ',Colonia_Emp, ', ',Ciudad_Emp, ', ',Estado_Emp, ' C.P. ',Codigo_Postal_Emp) AS direccion,"
                    + "CONCAT(ROUND(Comision_Emp, 2), '%') AS Comision,CURP_Emp,RFC_Emp,"
                    + "CASE WHEN Sexo_Emp = 'M' THEN 'Masculino' ELSE 'Femenino' END AS Sexo, "
                    + "DATE_FORMAT(Fecha_Contrato_Emp, '%d/%b/%Y') AS fecha_contrato,Status_Emp,E_Mail_Emp,Telefono1_Emp, Telefono2_Emp "
                    + "FROM empleados WHERE Id_Empleado = '"+ valor +"' and Status_Emp = 'Activa'";
            } else {
                if (opbuscar == 2 && valor != null){
                    SQLText = "SELECT id_empleado,nom_empleado,"
                    + "DATE_FORMAT(fecha_nac_emp, '%d/%b/%Y') AS fecha_nac,"
                    + "CONCAT(calle_emp, ' No. ', Num_Ext_Emp, ', Col. ',Colonia_Emp, ', ',Ciudad_Emp, ', ',Estado_Emp, ' C.P. ',Codigo_Postal_Emp) AS direccion,"
                    + "CONCAT(ROUND(Comision_Emp, 2), '%') AS Comision,CURP_Emp,RFC_Emp,"
                    + "CASE WHEN Sexo_Emp = 'M' THEN 'Masculino' ELSE 'Femenino' END AS Sexo, "
                    + "DATE_FORMAT(Fecha_Contrato_Emp, '%d/%b/%Y') AS fecha_contrato,Status_Emp,E_Mail_Emp,Telefono1_Emp, Telefono2_Emp "
                    + "FROM empleados WHERE nom_empleado like '%"+ valor +"%' and Status_Emp = 'Activa'";
                }
                
            }
        }
        
        valor = null;
        opbuscar = 0;
        String []datos = new String[13];
        try {
            Statement Leer = conectado.createStatement();
            ResultSet Resultado = Leer.executeQuery(SQLText);
            boolean tieneDatos = false;
            while(Resultado.next()){
                tieneDatos = true; // al menos hay una fila
                datos[0] = Resultado.getString(1);  //ID
                datos[1] = Resultado.getString(2);  //Nombre
                datos[2] = Resultado.getString(3);
                datos[3] = Resultado.getString(4);
                datos[4] = Resultado.getString(5);
                datos[5] = Resultado.getString(6);
                datos[6] = Resultado.getString(7);
                datos[7] = Resultado.getString(8);
                datos[8] = Resultado.getString(9);
                datos[9] = Resultado.getString(10);  //Status
                datos[10] = Resultado.getString(11); //E_Mail
                datos[11] = Resultado.getString(12); //Tel1
                datos[12] = Resultado.getString(13); //Tel2
                T_Empleados.addRow(datos);
            }
            if (!tieneDatos) {
                javax.swing.JOptionPane.showMessageDialog(null, "No Hay Registros con esa Búsqueda\n" + "Por Favor, Intetar de Nuevo!!","AVISO",2);
                limpieza.CamposAdminEmp(Nom_Empleado,E_Mail,Telefono_1,Telefono_2,CB_Status,false);
            }
            Tabla_Empleados.setModel(T_Empleados);
            Tabla_Empleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            Tabla_Empleados.getColumnModel().getColumn(1).setPreferredWidth(200);
            Tabla_Empleados.getColumnModel().getColumn(3).setPreferredWidth(500);
            Tabla_Empleados.getColumnModel().getColumn(10).setPreferredWidth(300);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + ". Error en la Consulta!!","AVISO",2);
        }
    }
    
    public void ActualizarDatos(){
        int fila = Tabla_Empleados.getSelectedRow();
        int id = Integer.parseInt(this.Tabla_Empleados.getValueAt(fila,0).toString());
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Empleados = new javax.swing.JTable();
        P_Busqueda = new javax.swing.JPanel();
        B_Buscar = new javax.swing.JButton();
        CB_opcion = new javax.swing.JComboBox<>();
        Texto_busqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        B_Salir = new javax.swing.JButton();
        P_Info = new javax.swing.JPanel();
        Nom_Empleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Telefono_1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Telefono_2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        E_Mail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CB_Status = new javax.swing.JComboBox<>();
        ID_Emp = new javax.swing.JTextField();
        B_Modificar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administración de Empleados");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
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

        Tabla_Empleados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowindex, int colindex){
                return false;
            }
        };
        Tabla_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tabla_Empleados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        Tabla_Empleados.setEditingColumn(0);
        Tabla_Empleados.setEditingRow(0);
        Tabla_Empleados.setFocusable(false);
        Tabla_Empleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Tabla_Empleados.setShowHorizontalLines(true);
        Tabla_Empleados.setShowVerticalLines(true);
        Tabla_Empleados.getTableHeader().setResizingAllowed(false);
        Tabla_Empleados.getTableHeader().setReorderingAllowed(false);
        Tabla_Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_EmpleadosMouseClicked(evt);
            }
        });
        Tabla_Empleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Tabla_EmpleadosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Tabla_EmpleadosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Empleados);
        Tabla_Empleados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        P_Busqueda.setBackground(new java.awt.Color(204, 204, 255));
        P_Busqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar por . . .(Solo Empleados Activos)", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        B_Buscar.setText("Buscar");
        B_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BuscarActionPerformed(evt);
            }
        });

        CB_opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todos", "Identificación", "Nombre" }));
        CB_opcion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CB_opcionItemStateChanged(evt);
            }
        });
        CB_opcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_opcionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel3.setText("Ingrese Datos:");

        javax.swing.GroupLayout P_BusquedaLayout = new javax.swing.GroupLayout(P_Busqueda);
        P_Busqueda.setLayout(P_BusquedaLayout);
        P_BusquedaLayout.setHorizontalGroup(
            P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_BusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CB_opcion, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(P_BusquedaLayout.createSequentialGroup()
                        .addComponent(Texto_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(B_Buscar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        P_BusquedaLayout.setVerticalGroup(
            P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_BusquedaLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(P_BusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_opcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Buscar))
                .addContainerGap())
        );

        B_Salir.setText("Salir");
        B_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SalirActionPerformed(evt);
            }
        });

        P_Info.setBackground(new java.awt.Color(204, 204, 255));
        P_Info.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar Información ...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        Nom_Empleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Nom_EmpleadoFocusLost(evt);
            }
        });
        Nom_Empleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nom_EmpleadoKeyTyped(evt);
            }
        });

        jLabel1.setText("Nombre Completo:");

        jLabel14.setText("Telefono(1):");

        Telefono_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Telefono_1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Telefono_1KeyTyped(evt);
            }
        });

        jLabel15.setText("Telefono(2):");

        Telefono_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Telefono_2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Telefono_2KeyTyped(evt);
            }
        });

        jLabel16.setText("EMail:");

        E_Mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                E_MailKeyTyped(evt);
            }
        });

        jLabel2.setText("Status:");

        CB_Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activa", "Baja" }));
        CB_Status.setEnabled(false);
        CB_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_StatusActionPerformed(evt);
            }
        });
        CB_Status.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CB_StatusKeyTyped(evt);
            }
        });

        ID_Emp.setBackground(new java.awt.Color(204, 204, 255));
        ID_Emp.setEnabled(false);

        javax.swing.GroupLayout P_InfoLayout = new javax.swing.GroupLayout(P_Info);
        P_Info.setLayout(P_InfoLayout);
        P_InfoLayout.setHorizontalGroup(
            P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_InfoLayout.createSequentialGroup()
                .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_InfoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(P_InfoLayout.createSequentialGroup()
                                .addComponent(Nom_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(ID_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(E_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(P_InfoLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Telefono_2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(Telefono_1))
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CB_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        P_InfoLayout.setVerticalGroup(
            P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(P_InfoLayout.createSequentialGroup()
                .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(P_InfoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Nom_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(ID_Emp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(E_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(Telefono_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, P_InfoLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(CB_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGroup(P_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telefono_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap())
        );

        B_Modificar.setText("Modificar");
        B_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(P_Busqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(B_Modificar)
                        .addGap(18, 18, 18)
                        .addComponent(B_Salir)
                        .addGap(34, 34, 34))
                    .addComponent(P_Info, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P_Busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(P_Info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_Salir)
                    .addComponent(B_Modificar))
                .addGap(16, 16, 16))
        );

        P_Busqueda.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BuscarActionPerformed
        int opcion = 0;
        String valorop = null;
        
        opcion = CB_opcion.getSelectedIndex();
        valorop = Texto_busqueda.getText();
        
        limpieza.limpiarCampos(this.getContentPane());
        Tabla_Empleados.clearSelection(); 
        CB_opcion.setSelectedIndex(opcion);
        limpieza.CamposAdminEmp(Nom_Empleado,E_Mail,Telefono_1,Telefono_2,CB_Status,false);
        MostrarDatosEmpleado(opcion, valorop);
    }//GEN-LAST:event_B_BuscarActionPerformed

    private void CB_opcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_opcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_opcionActionPerformed

    private void CB_opcionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CB_opcionItemStateChanged
        // TODO add your handling code here:
        int opcombo = 0;
        opcombo = CB_opcion.getSelectedIndex();
        Texto_busqueda.setText("");
        if (opcombo ==0){
          Texto_busqueda.setEnabled(false);
        }else {
            Texto_busqueda.setEnabled(true);
        } 
    }//GEN-LAST:event_CB_opcionItemStateChanged

    private void B_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SalirActionPerformed
        DefaultTableModel model = (DefaultTableModel) Tabla_Empleados.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        limpieza.limpiarCampos(this.getContentPane());
        Tabla_Empleados.clearSelection();
        limpieza.BotonesAdminEmp(B_Modificar, false);
        limpieza.CamposAdminEmp(Nom_Empleado,E_Mail,Telefono_1,Telefono_2,CB_Status,false);
        dispose();
    }//GEN-LAST:event_B_SalirActionPerformed

    private void Nom_EmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nom_EmpleadoFocusLost

    }//GEN-LAST:event_Nom_EmpleadoFocusLost

    private void Telefono_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Telefono_1KeyTyped
        Telefono_1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // bloquea todo lo que no sea dígito
                    e.consume();
                }
            }

        });
    }//GEN-LAST:event_Telefono_1KeyTyped

    private void Telefono_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Telefono_2KeyTyped
        Telefono_2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) { // bloquea todo lo que no sea dígito
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_Telefono_2KeyTyped

    private void Tabla_EmpleadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_EmpleadosKeyPressed

    }//GEN-LAST:event_Tabla_EmpleadosKeyPressed

    private void Tabla_EmpleadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Tabla_EmpleadosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Tabla_EmpleadosKeyTyped

    private void Tabla_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_EmpleadosMouseClicked
        // TODO add your handling code here:
        int fila = Tabla_Empleados.getSelectedRow();
        if (fila >0 || fila == 0){
            limpieza.CamposAdminEmp(Nom_Empleado,E_Mail,Telefono_1,Telefono_2,CB_Status,true);
            int id = Integer.parseInt(this.Tabla_Empleados.getValueAt(fila,0).toString());  
            ID_Emp.setText((String) Tabla_Empleados.getValueAt(fila,0));
            Nom_Empleado.setText((String) Tabla_Empleados.getValueAt(fila,1));     
            String status = (String) Tabla_Empleados.getValueAt(fila, 9);
            // Selecciona en el combo el elemento que tenga ese texto
            CB_Status.setSelectedItem(status);
            String email = (String) Tabla_Empleados.getValueAt(fila,10);
            E_Mail.setText(email);
            Telefono_1.setText((String) Tabla_Empleados.getValueAt(fila,11));
            Telefono_2.setText((String) Tabla_Empleados.getValueAt(fila,12));
           // JOptionPane.showMessageDialog(null,"Registro: " + String.valueOf(fila+1) + "  ID Empleado: "+ String.valueOf(id) + " !!","SELECCION ..",1);
            Nom_Empleado.requestFocusInWindow();
        }
        
    }//GEN-LAST:event_Tabla_EmpleadosMouseClicked

    private void B_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ModificarActionPerformed
        // PREGUNTAR SI DESEA MODIFICAR EL REGISTRO
        int fila = Tabla_Empleados.getSelectedRow();
        int id = Integer.parseInt(this.Tabla_Empleados.getValueAt(fila,0).toString());
        int opcion = JOptionPane.showConfirmDialog(
                            null,
                            "Modificar del Registro con ID Empleado " + String.valueOf(id) + " !!\n¿Desea continuar?",
                            "SELECCIÓN",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                        );
        if (opcion == JOptionPane.YES_OPTION) 
        {
            // El usuario presionó "Sí"
            //  JOptionPane.showMessageDialog(null,"Usuario confirmó la acción.","Aviso",2);
            try 
            {
                
                PreparedStatement modificar = conectado.prepareStatement("UPDATE empleados "
                        + "SET nom_empleado = ?, telefono1_emp = ?, telefono2_emp = ?, e_mail_emp = ?, status_emp = ? "
                        + "WHERE id_empleado = ?" );
                modificar.setString(1,Nom_Empleado.getText());
                modificar.setString(2,Telefono_1.getText());
                modificar.setString(3,Telefono_2.getText());
                modificar.setString(4,E_Mail.getText());  
                modificar.setString(5,CB_Status.getSelectedItem().toString()); 
                modificar.setInt(6, id);

                modificar.executeUpdate();
                
                JOptionPane.showMessageDialog(null,". * ✅ Empleado con ID No. " + String.valueOf(id) + " se Modificó con Exito *","AVISO",2);
                
                int op = JOptionPane.showConfirmDialog(
                        null,
                        "¿Desea Modificar otro Empleado?",
                        "Pregunta",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                        );
                if (op == JOptionPane.YES_OPTION) {
                    DefaultTableModel model = (DefaultTableModel) Tabla_Empleados.getModel();
                    model.setRowCount(0);
                    model.setColumnCount(0);
                    Tabla_Empleados.clearSelection();
                    limpieza.limpiarCampos(this.getContentPane());
                    limpieza.BotonesAdminEmp(B_Modificar, false);
                    limpieza.CamposAdminEmp(Nom_Empleado,E_Mail,Telefono_1,Telefono_2,CB_Status,false);
                    Texto_busqueda.setEnabled(false);
                    CB_opcion.setSelectedIndex(0);

                } else { 
                    DefaultTableModel model = (DefaultTableModel) Tabla_Empleados.getModel();
                    model.setRowCount(0);
                    model.setColumnCount(0);
                    limpieza.limpiarCampos(this.getContentPane());
                    Tabla_Empleados.clearSelection();
                    limpieza.BotonesAdminEmp(B_Modificar, false);
                    limpieza.CamposAdminEmp(Nom_Empleado,E_Mail,Telefono_1,Telefono_2,CB_Status,false);
                    dispose();
                }
                // HAY que limpiar ventana y preguntar si desea dar de alta otro
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, "❌ Error al Modificar Empleado!!","AVISO",2);
            }

        } else if (opcion == JOptionPane.NO_OPTION) {
            // El usuario presionó "No"
            //JOptionPane.showMessageDialog(null,"Usuario canceló la acción.","Aviso",2);
        }

    }//GEN-LAST:event_B_ModificarActionPerformed

    private void Nom_EmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nom_EmpleadoKeyTyped
        limpieza.BotonesAdminEmp(B_Modificar, true);
    }//GEN-LAST:event_Nom_EmpleadoKeyTyped

    private void E_MailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E_MailKeyTyped
        limpieza.BotonesAdminEmp(B_Modificar, true);
    }//GEN-LAST:event_E_MailKeyTyped

    private void Telefono_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Telefono_2KeyPressed
       limpieza.BotonesAdminEmp(B_Modificar, true);
    }//GEN-LAST:event_Telefono_2KeyPressed

    private void Telefono_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Telefono_1KeyPressed
       limpieza.BotonesAdminEmp(B_Modificar, true);
    }//GEN-LAST:event_Telefono_1KeyPressed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        DefaultTableModel model = (DefaultTableModel) Tabla_Empleados.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
    }//GEN-LAST:event_formInternalFrameActivated

    private void CB_StatusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CB_StatusKeyTyped
        
    }//GEN-LAST:event_CB_StatusKeyTyped

    private void CB_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_StatusActionPerformed
        limpieza.BotonesAdminEmp(B_Modificar, true);
    }//GEN-LAST:event_CB_StatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Buscar;
    private javax.swing.JButton B_Modificar;
    private javax.swing.JButton B_Salir;
    private javax.swing.JComboBox<String> CB_Status;
    private javax.swing.JComboBox<String> CB_opcion;
    private javax.swing.JTextField E_Mail;
    private javax.swing.JTextField ID_Emp;
    private javax.swing.JTextField Nom_Empleado;
    private javax.swing.JPanel P_Busqueda;
    private javax.swing.JPanel P_Info;
    private javax.swing.JTable Tabla_Empleados;
    private javax.swing.JTextField Telefono_1;
    private javax.swing.JTextField Telefono_2;
    private javax.swing.JTextField Texto_busqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
