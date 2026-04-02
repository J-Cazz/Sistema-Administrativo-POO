
package com.mycompany.proyectopiapoo;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Container;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class LimpiezaEmpleados extends LimpiezaPadre {
   
    public LimpiezaEmpleados() {
        super.prepararVentana(); // ✅ correcto: dentro del constructor
    }
    public void LimpiaCombos(JComboBox jcombobox,JComboBox jcombobox2,JComboBox jcombobox3){
        jcombobox.removeAllItems();
        jcombobox2.removeAllItems();
        jcombobox3.removeAllItems();
    }
    public void BotonesAdminEmp(JButton jbutton, boolean bol){
        jbutton.setEnabled(bol);
       
        
    }   
     public void Check1ListadoEmpleados(JComboBox jcombobox,boolean bol){
        jcombobox.setSelectedIndex(0);
        jcombobox.setEnabled(bol);
    }  
     public void Check2ListadoEmpleados(JDateChooser jdatechooser1,JDateChooser jdatechooser2,boolean bol){
        jdatechooser1.setDate(new Date());
        jdatechooser2.setDate(new Date());
        jdatechooser1.setEnabled(bol);
        jdatechooser2.setEnabled(bol);  
    }  
     public void CamposAdminEmp(JTextField jtextfield1,JTextField jtextfield2,JTextField jtextfield3,JTextField jtextfield4,JComboBox jcombobox, boolean bol){
        jcombobox.setEnabled(bol);
        jtextfield1.setEnabled(bol);
        jtextfield2.setEnabled(bol);
        jtextfield3.setEnabled(bol);
        jtextfield4.setEnabled(bol);
     }
}
 

