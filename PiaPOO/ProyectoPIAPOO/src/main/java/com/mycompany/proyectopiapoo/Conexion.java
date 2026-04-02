
package com.mycompany.proyectopiapoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection enlazar = null;
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            enlazar = DriverManager.getConnection("jdbc:mysql://localhost/bd_inventario","root", "Jicaj123#");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e + ". ** No fué posible establecer la Conexion **","AVISO",2);
        }
       return enlazar;
    }
    
    
}
