
package com.mycompany.proyectopiapoo;

import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Date;
import javax.swing.JComboBox;

public class W_Empleados extends javax.swing.JInternalFrame {
   
    Conexion enlace = new Conexion();
    Connection conectado = enlace.conectar();
    LimpiezaEmpleados limpieza = new LimpiezaEmpleados();
    
    public W_Empleados() {
        initComponents();
        limpieza.limpiarCampos(this.getContentPane());
        limpieza.LimpiaCombos(CB_Colonia, CB_Ciudad, CB_Estado);
        InicializaCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Id_Empleado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Telefono_1 = new javax.swing.JTextField();
        E_Mail = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Telefono_2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        Comision = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        CURP = new javax.swing.JTextField();
        RFC = new javax.swing.JTextField();
        Nom_Empleado = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Calle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        No_Ext = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CP = new javax.swing.JTextField();
        CB_Ciudad = new javax.swing.JComboBox<>();
        CB_Estado = new javax.swing.JComboBox<>();
        CB_Colonia = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Sexo = new javax.swing.JComboBox<>();
        Fecha_Contrato = new com.toedter.calendar.JDateChooser();
        Fec_Nac = new com.toedter.calendar.JDateChooser();
        Busca_Cp = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        B_Salir = new javax.swing.JToggleButton();
        B_Grabar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Ingreso de Empleados");
        setInheritsPopupMenu(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Requeridos ...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jLabel1.setText("Nombre Completo:");

        jLabel2.setText("No. Empleado:");

        jLabel3.setText("Fecha Ingreso:");

        Id_Empleado.setEditable(false);
        Id_Empleado.setBackground(new java.awt.Color(102, 102, 255));
        Id_Empleado.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Id_Empleado.setForeground(new java.awt.Color(255, 255, 0));
        Id_Empleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Id_Empleado.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("CURP:");

        jLabel5.setText("RFC:");

        jLabel6.setText("Fecha Nac.:");

        Telefono_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Telefono_1KeyTyped(evt);
            }
        });

        jLabel15.setText("Telefono(2):");

        Telefono_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Telefono_2KeyTyped(evt);
            }
        });

        jLabel17.setText("Comision Otorgada:");

        Comision.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(50.0f), Float.valueOf(0.5f)));
        Comision.setEditor(new javax.swing.JSpinner.NumberEditor(Comision, "#0.00"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Telefono_1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(Telefono_2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(Comision, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(Telefono_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Comision)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Telefono_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(E_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Direccion");

        Nom_Empleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Nom_EmpleadoFocusLost(evt);
            }
        });
        Nom_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nom_EmpleadoActionPerformed(evt);
            }
        });

        jLabel14.setText("Telefono(1):");

        jLabel16.setText("EMail:");

        jLabel8.setText("Calle:");

        jLabel13.setText("Estado:");

        No_Ext.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        No_Ext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                No_ExtActionPerformed(evt);
            }
        });
        No_Ext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                No_ExtKeyTyped(evt);
            }
        });

        jLabel10.setText("C.P.:");

        CP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CPKeyTyped(evt);
            }
        });

        CB_Ciudad.setEnabled(false);

        CB_Estado.setEnabled(false);

        jLabel9.setText("No. Ext.:");

        jLabel12.setText("Municipio:");

        jLabel11.setText("Colonia:");

        jLabel18.setText("Sexo:");

        Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        Busca_Cp.setBackground(new java.awt.Color(102, 102, 255));
        Busca_Cp.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        Busca_Cp.setForeground(new java.awt.Color(255, 255, 102));
        Busca_Cp.setText("?");
        Busca_Cp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Busca_Cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Busca_CpActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 0, 0));
        jLabel19.setText("*");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 0, 0));
        jLabel20.setText("*");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 0, 0));
        jLabel21.setText("*");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 0));
        jLabel22.setText("*");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 0));
        jLabel23.setText("*");

        jLabel24.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 0));
        jLabel24.setText("*");

        jLabel25.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 0, 0));
        jLabel25.setText("*");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addComponent(jLabel4))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel5)))
                            .addGap(4, 4, 4))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Calle, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(No_Ext, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(61, 61, 61)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Busca_Cp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CB_Colonia, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CB_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RFC, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel18))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CURP, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Fec_Nac, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Nom_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Fecha_Contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Id_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Id_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Fecha_Contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nom_Empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(CURP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21)
                        .addComponent(jLabel6)
                        .addComponent(jLabel19))
                    .addComponent(Fec_Nac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(RFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)))
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(CP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Busca_Cp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(No_Ext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(CB_Colonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(CB_Ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(CB_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        B_Salir.setText("Salir");
        B_Salir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        B_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SalirActionPerformed(evt);
            }
        });

        B_Grabar.setText("Grabar");
        B_Grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_GrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(B_Grabar)
                .addGap(40, 40, 40)
                .addComponent(B_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_Salir)
                    .addComponent(B_Grabar))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_GrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_GrabarActionPerformed
        // GRABAR INFORMACION
        int numeroExt;
        try {
            
            if (Nom_Empleado.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre del empleado es obligatorio.");
                Nom_Empleado.requestFocusInWindow();
                return;
            }
            if(CURP.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "El CURP del empleado es obligatorio.");
                CURP.requestFocusInWindow();
                return;
            }
            if(RFC.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "El RFC del empleado es obligatorio.");
                RFC.requestFocusInWindow();
                return;
            }        
            if(Sexo.getSelectedIndex() == -1 || Sexo.getSelectedItem() == null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el sexo del empleado");
                Sexo.requestFocusInWindow();
                return;
            }
            if(Fec_Nac.getDate() == null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar fecha de nacimiento");
                Sexo.requestFocusInWindow();
                return;
            }
            if (Calle.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La calle es obligatoria.");
            Calle.requestFocusInWindow();
            return;
            }

            if (CP.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El código postal es obligatorio.");
                CP.requestFocusInWindow();
                return;
            }
            
            //Mas Restricciones
            if (!CP.getText().trim().matches("\\d{5}")) {
                JOptionPane.showMessageDialog(null, "El código postal debe tener 5 números.");
                CP.requestFocusInWindow();
                return;
            }
            
            if(CURP.getText().trim().length() != 18){
                JOptionPane.showMessageDialog(null, "El CURP debe tener 18 caracteres.");
                CURP.requestFocusInWindow();
                return;
            }
            if(RFC.getText().trim().length() < 12 || RFC.getText().trim().length() > 13){
                JOptionPane.showMessageDialog(null, "El RFC debe tener 12 o 13 caracteres.");
                RFC.requestFocusInWindow();
                return;
            }
            
            //Fecha
           java.util.Date fechaNac = Fec_Nac.getDate();
           java.util.Date hoy = new java.util.Date();

            // No puede ser futura
            if (fechaNac.after(hoy)) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser posterior a hoy.");
                Fec_Nac.requestFocusInWindow();
                return;
            }

            // Calcular edad
            java.util.Calendar calNac = java.util.Calendar.getInstance();
            calNac.setTime(fechaNac);

            java.util.Calendar calHoy = java.util.Calendar.getInstance();
            int edad = calHoy.get(java.util.Calendar.YEAR) - calNac.get(java.util.Calendar.YEAR);

            // Ajustar si aún no ha cumplido años este año
            if (calHoy.get(java.util.Calendar.DAY_OF_YEAR) < calNac.get(java.util.Calendar.DAY_OF_YEAR)) {
                edad--;
            }

            // Validar rango de edad
            if (edad < 15) {
                JOptionPane.showMessageDialog(null, "El empleado debe tener al menos 15 años.");
                Fec_Nac.requestFocusInWindow();
                return;
            }

            if (edad > 90) {
                JOptionPane.showMessageDialog(null, "El empleado no puede tener más de 90 años.");
                Fec_Nac.requestFocusInWindow();
                return;
            }
            
            
            try {
                String textoNoExt = No_Ext.getText().trim();
                numeroExt = textoNoExt.isEmpty() ? 0 : Integer.parseInt(textoNoExt);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "⚠️ El número exterior debe ser numérico.");
                return;
            }
        
            java.util.Date fechaCon = Fecha_Contrato.getDate();
            
            PreparedStatement guardar = conectado.prepareStatement("INSERT INTO bd_inventario.empleados "
                    + "(Id_Empleado, Nom_Empleado, Calle_Emp, Num_Ext_Emp, Fecha_Nac_Emp, Codigo_Postal_Emp,"
                    + "Colonia_Emp, Ciudad_Emp, Estado_Emp, Telefono1_Emp,Telefono2_Emp, Comision_Emp,"
                    + "CURP_Emp, RFC_Emp, E_Mail_Emp, Fecha_Contrato_Emp, Status_Emp,Sexo_Emp ) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            int folio = LeerNumEmpleado();
     
            guardar.setInt(1,folio);
            
            guardar.setString(2,Nom_Empleado.getText());
            guardar.setString(3,Calle.getText());
            guardar.setInt(4, numeroExt);
            guardar.setDate(5, fechaNac != null ? new java.sql.Date(fechaNac.getTime()) : null);  
            guardar.setString(6,CP.getText());
            guardar.setString(7,CB_Colonia.getSelectedItem().toString());
            guardar.setString(8,CB_Ciudad.getSelectedItem().toString());
            guardar.setString(9,CB_Estado.getSelectedItem().toString());
            guardar.setString(10,Telefono_1.getText());
            guardar.setString(11,Telefono_2.getText());
            guardar.setDouble(12, ((Number) Comision.getValue()).doubleValue());       
            guardar.setString(13,CURP.getText());
            guardar.setString(14,RFC.getText());
            guardar.setString(15,E_Mail.getText());   
            guardar.setDate(16, fechaCon != null ? new java.sql.Date(fechaCon.getTime()) : null);
            guardar.setString(17,"Activa");
            guardar.setString(18, Sexo.getSelectedItem().toString());
                   
            guardar.executeUpdate();
            Id_Empleado.setText(Integer.toString(folio));
            JOptionPane.showMessageDialog(null,". * ✅ Empleado con ID No. " + String.valueOf(folio) + " se registró correctamente *","AVISO",2);
            
            int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Desea agregar otro empleado?\nSi selecciona 'Sí' se limpiarán los campos",
            "Agregar otro empleado",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
            );
            if (opcion == JOptionPane.YES_OPTION) {
            // El usuario presionó "Sí" - Limpiar todos los campos
                limpieza.limpiarCampos(this.getContentPane());
                limpieza.LimpiaCombos(CB_Colonia, CB_Ciudad, CB_Estado);
                InicializaCampos();
                
            } else {
                // El usuario presionó "No" - Cerrar ventana
                limpieza.limpiarCampos(this.getContentPane());
                limpieza.LimpiaCombos(CB_Colonia, CB_Ciudad, CB_Estado);
                InicializaCampos();
                dispose();
            }
            // HAY que limpiar ventana y preguntar si desea dar de alta otro
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,e + "❌ Error al Registrar Empleado!!","AVISO",2);
        }
    } 
    
    private void InicializaCampos() {
        Sexo.setSelectedIndex(0);
        Fec_Nac.setDate(null);
        Fecha_Contrato.setDate(new Date());
        Comision.setValue(0);  
        Nom_Empleado.requestFocusInWindow();
    }//GEN-LAST:event_B_GrabarActionPerformed

   public int LeerNumEmpleado() {
    int folioInt = 0; // valor por defecto
    
    String SQLText = "SELECT id_empleado + 1 FROM empleados ORDER BY id_empleado DESC LIMIT 1";
    String folioStr ;
    
    try (Statement Leer = conectado.createStatement();
    ResultSet Resultado = Leer.executeQuery(SQLText)) 
    {
        if (Resultado.next()) {
            // Sí hay datos en la consulta
            folioStr = Resultado.getString(1);
        } else {
            // No hay datos → folio por defecto = 100
            folioStr = "100";
        }

        try 
        {
            folioInt = Integer.parseInt(folioStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e + ". Error al convertir folio a entero.", "AVISO", JOptionPane.WARNING_MESSAGE);
        }

    } catch (SQLException e) 
    {
        JOptionPane.showMessageDialog(null, e + ". Error en la consulta SQL.", "AVISO", JOptionPane.WARNING_MESSAGE);
    }

    
    return folioInt; // devuelve el folio
}

    
    
    private void No_ExtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_No_ExtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_No_ExtActionPerformed

    private void B_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SalirActionPerformed
        limpieza.limpiarCampos(this.getContentPane());
        limpieza.LimpiaCombos(CB_Colonia, CB_Ciudad, CB_Estado);  
        InicializaCampos();
        dispose();     
    }//GEN-LAST:event_B_SalirActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameClosed

    private void Busca_CpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Busca_CpActionPerformed
       
        
        limpieza.LimpiaCombos(CB_Colonia, CB_Ciudad, CB_Estado);
       
        try {
                String cp = CP.getText().trim();

                if (cp.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Por favor ingresa un código postal.","AVISO",2);
                    return;
                }
                //Hacer la Peticion de la URL
                URL url_colonias = new URL("https://api.tau.com.mx/dipomex/v1/codigo_postal?cp=" + cp);

                // CP Trayendo Colonias
                HttpURLConnection conn_col = (HttpURLConnection)url_colonias.openConnection();
                conn_col.setRequestMethod("GET");
                conn_col.setRequestProperty("APIKEY", "4a810246e5679f4b869f49453fd30c2547000b27");
                   
                // Verificar si la respuesta HTTP fue exitosa
                int status = conn_col.getResponseCode();
                if (status != 200) {
                    JOptionPane.showMessageDialog(this, "El Código Postal No Existe. Favor de Dar Otro.","AVISO",2);
                    CP.setText("");
                    CP.requestFocusInWindow(); 
                    return;
                }
                BufferedReader reader_col = new BufferedReader(new InputStreamReader(conn_col.getInputStream()));
                StringBuilder response_col = new StringBuilder();
                String line_col;
                while ((line_col = reader_col.readLine()) != null){
                    response_col.append(line_col);
                }
                reader_col.close();

                JSONObject jsonObject = new JSONObject(response_col.toString());

                JSONObject datos = jsonObject.getJSONObject("codigo_postal");
                JSONArray Arreglo_Colonias = datos.getJSONArray("colonias");
                String estado = datos.getString("estado");
                String municipio = datos.getString("municipio");

                // 6. Agregar colonias al JComboBox
                for (int i = 0; i < Arreglo_Colonias.length(); i++) {
                    String Nom_colonia = Arreglo_Colonias.getString(i);
                    CB_Colonia.addItem(Nom_colonia);         
                }
                CB_Ciudad.addItem(municipio);
                CB_Estado.addItem(estado);

                conn_col.disconnect();
            }catch (Exception e){
                e.printStackTrace();
            }
      
    }//GEN-LAST:event_Busca_CpActionPerformed

    private void Nom_EmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Nom_EmpleadoFocusLost
  
    }//GEN-LAST:event_Nom_EmpleadoFocusLost

    private void No_ExtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_No_ExtKeyTyped
       // PARA QUE SOLO DE NUMEROS
        No_Ext.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) { // bloquea todo lo que no sea dígito
                e.consume();
            }
        }
        });
    }//GEN-LAST:event_No_ExtKeyTyped

    private void CPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CPKeyTyped
       // PARA QUE SOLO DE NUMEROS
        CP.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) { // bloquea todo lo que no sea dígito
                e.consume();
            }
        }
        });
    }//GEN-LAST:event_CPKeyTyped

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

    private void Nom_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nom_EmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nom_EmpleadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Grabar;
    private javax.swing.JToggleButton B_Salir;
    private javax.swing.JButton Busca_Cp;
    private javax.swing.JComboBox<String> CB_Ciudad;
    private javax.swing.JComboBox<String> CB_Colonia;
    private javax.swing.JComboBox<String> CB_Estado;
    private javax.swing.JTextField CP;
    private javax.swing.JTextField CURP;
    private javax.swing.JTextField Calle;
    private javax.swing.JSpinner Comision;
    private javax.swing.JTextField E_Mail;
    private com.toedter.calendar.JDateChooser Fec_Nac;
    private com.toedter.calendar.JDateChooser Fecha_Contrato;
    private javax.swing.JTextField Id_Empleado;
    private javax.swing.JTextField No_Ext;
    private javax.swing.JTextField Nom_Empleado;
    private javax.swing.JTextField RFC;
    private javax.swing.JComboBox<String> Sexo;
    private javax.swing.JTextField Telefono_1;
    private javax.swing.JTextField Telefono_2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    private Object getTextField() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void limpiacombox(JComboBox<String> CB_Colonia, JComboBox<String> CB_Ciudad, JComboBox<String> CB_Estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
