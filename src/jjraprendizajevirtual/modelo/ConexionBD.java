/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jjraprendizajevirtual.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jjraprendizajevirtual.utilidades.Constantes;

public class ConexionBD {
    public static final String URI_CONEXION = "jdbc:mysql://"
            + Constantes.HOSTNAME + ":"
            + Constantes.PUERTO + "/"
            + Constantes.NOMBRE_BD +
            "?allowPublicKeyRetrieval=true&useSSL=false";
    
    public static Connection obtenerConexion(){
        Connection conexion = null;
        try {
            Class.forName(Constantes.DRIVER);
            conexion = (Connection) DriverManager.getConnection(URI_CONEXION,
                    Constantes.USUARIO,
                    Constantes.PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error de conexión con BD: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        return conexion;
    }
}
