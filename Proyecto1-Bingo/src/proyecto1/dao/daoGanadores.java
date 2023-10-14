/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import proyecto1.logicadenegocios.ConexionDB;
import proyecto1.logicadenegocios.Juego;
import proyecto1.logicadenegocios.Jugador;

public class daoGanadores {
    ConexionDB cx;

    public daoGanadores(){
        cx = new ConexionDB();
    }

    public boolean insertGanador(Jugador jugador){
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            // Obtener el ID del último dato insertado
            int idPartida;
            connection = cx.conectar();
            String query = "SELECT idPartida FROM partida ORDER BY idPartida DESC LIMIT 1";
            ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                idPartida = resultSet.getInt("idPartida");
            } else {
                // No se pudo obtener el ID, maneja el error aquí
                System.out.println("No se pudo obtener el ID de la partida insertada.");
                return false;
            }

            // Insertar el ganador
            query = "INSERT INTO ganadores (cedula, idPartida) VALUES (?, ?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, jugador.getCedula());
            ps.setInt(2, idPartida);
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*public static void main(String[] args){
        Jugador jugador= new Jugador();
        daoGanadores dao= new daoGanadores();
        jugador.setCedula(118650791);
        if (dao.insertGanador(jugador)){
            System.out.println("Inserción exitosa");
        }else{
            System.out.println("ERROR");
        }
    }*/
    
}








