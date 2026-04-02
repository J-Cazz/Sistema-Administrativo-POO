
package com.mycompany.proyectopiapoo;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;

public class LimpiezaPadre extends JFrame {

    // Método recursivo para limpiar todos los campos dentro de un contenedor
    public void limpiarCampos(Container container) {
        for (Component c : container.getComponents()) {

            // Limpiar JTextField
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");

            // Limpiar JTextArea
            } else if (c instanceof JTextArea) {
                ((JTextArea) c).setText("");

            // Limpiar JCheckBox
            } else if (c instanceof JCheckBox) {
                ((JCheckBox) c).setSelected(false);

            // Limpiar JTable
            } else if (c instanceof JTable) {
                ((JTable) c).clearSelection();

            // Limpiar JDateChooser (campo de fecha)
            } else if (c instanceof JDateChooser) {
                ((JDateChooser) c).setDate(null);

            // Si es un contenedor (por ejemplo, JPanel), llamar recursivamente
            } else if (c instanceof Container) {
                limpiarCampos((Container) c);
            }
        }
    }
    // Método que puede ser llamado al abrir la ventana
    protected void prepararVentana() {
        limpiarCampos(this.getContentPane());
    }

    // Método que puede ser llamado al salir de la ventana
    protected void cerrarVentana() {
        limpiarCampos(this.getContentPane());
    }
}