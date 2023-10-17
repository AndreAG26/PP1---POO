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
/**
 * Clase daoGanadores que se encarga de las operaciones relacionadas con los ganadores en la base de datos.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class daoGanadores {
    ConexionDB cx;
    /**
     * Constructor de la clase daoGanadores.
     * Inicializa la conexión a la base de datos.
     */
    public daoGanadores(){
        cx = new ConexionDB();
    }
    /**
     * Método que inserta un ganador en la base de datos.
     * 
     * @param jugador Jugador que ha ganado.
     * @return boolean Retorna true si la inserción fue exitosa, false en caso contrario.
     */
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
    
}








