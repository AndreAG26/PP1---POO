/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICADENEGOCIOS;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class ConexionDB {
    Connection cx=null;

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

    public void desconectar (){
        try {
            cx.close();
            System.out.println("BD OFF");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    public static void main(String[] args){
        ConexionDB cx=new ConexionDB();
        cx.conectar();
        cx.desconectar();
    }*/
}
