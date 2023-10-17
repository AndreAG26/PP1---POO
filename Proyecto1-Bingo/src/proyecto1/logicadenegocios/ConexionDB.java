/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.logicadenegocios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * La clase ConexionDB se encarga de gestionar la conexión a la base de datos SQLite.
 * Proporciona métodos para conectar y desconectar de la base de datos.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class ConexionDB {
    Connection cx=null;
    /**
     * Establece una conexión con la base de datos SQLite y la retorna.
     * 
     * @return Connection que representa la conexión establecida.
     */
    public Connection conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
            cx=DriverManager.getConnection("jdbc:sqlite:BingoDB.db", null, null);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cx;
    }
     /**
     * Cierra la conexión establecida con la base de datos SQLite.
     */
    public void desconectar (){
        try {
            cx.close();
            System.out.println("BD OFF");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
