/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import proyecto1.logicadenegocios.ConexionDB;
import proyecto1.logicadenegocios.Jugador;

/**
 * Clase daoJugador que se encarga de las operaciones relacionadas con los jugadores en la base de datos.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class daoJugador {
    ConexionDB cx;
    /**
     * Constructor de la clase daoJugador.
     * Inicializa la conexión a la base de datos.
     */
    public daoJugador(){
        cx=new ConexionDB();
    }
    /**
     * Método que inserta un jugador en la base de datos.
     * 
     * @param jugador Jugador que se desea insertar.
     * @return boolean Retorna true si la inserción fue exitosa, false en caso contrario.
     */
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
    /**
     * Método que carga todos los jugadores desde la base de datos.
     * 
     * @return List Lista de jugadores obtenidos de la base de datos.
     */
    public List<Jugador> cargarJugadores() {
        List<Jugador> jugadores = new ArrayList<>();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            
            connection = cx.conectar(); 

            String query = "SELECT * FROM jugador";
            ps = connection.prepareStatement(query);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                String nombreCompleto = resultSet.getString("nombrecompleto");
                String correo = resultSet.getString("correo");
                int cedula = resultSet.getInt("cédula");

                Jugador jugador = new Jugador(cedula, nombreCompleto, correo);
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja el error adecuadamente
        } finally {
            // Cierra los recursos (ResultSet, PreparedStatement y Connection) en orden inverso
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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

        return jugadores;
    }
    
 
    
}
