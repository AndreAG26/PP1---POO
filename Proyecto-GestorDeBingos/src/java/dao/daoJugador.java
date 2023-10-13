/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;

import LOGICADENEGOCIOS.ConexionDB;
import LOGICADENEGOCIOS.Jugador;

/**
 *
 * @author Dell
 */
public class daoJugador {
    ConexionDB cx;

    public daoJugador(){
        cx=new ConexionDB();
    }

    public boolean insertJugador(Jugador jugador){
    
        PreparedStatement ps = null;
        Connection connection = null;

        try {
            connection = cx.conectar();

            // Verificar si ya existe un jugador con la misma cédula
            PreparedStatement checkStatement = connection.prepareStatement("SELECT 1 FROM jugador WHERE cédula = ?");
            checkStatement.setInt(1, jugador.getCedula());
            ResultSet resultSet= checkStatement.executeQuery();

            if (resultSet.next()) {
                // Ya existe un jugador con la misma cédula, no se puede insertar
                cx.desconectar();
                return false;
                
            } else {
                // No existe un jugador con la misma cédula, procede a insertar
                ps = connection.prepareStatement("INSERT INTO jugador (nombreCompleto, correo, cédula) VALUES (?,?,?)");
                ps.setString(1, jugador.getNombreCompleto());
                ps.setString(2, jugador.getCorreo());
                ps.setInt(3, jugador.getCedula());
                ps.executeUpdate();
                cx.desconectar();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /*
    public static void main(String[] args){
        Jugador jugador= new Jugador();
        daoJugador dao = new daoJugador();
        jugador.setNombreCompleto("Damaris Montero");
        jugador.setCorreo("damarisg3168@gmail.com");
        jugador.setCedula(118659874);
        if (dao.insertJugador(jugador)){
            System.out.println("Inserción exitosa");
        }else{
            System.out.println("ERROR");
        }
    }*/
}
