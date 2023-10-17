/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

import proyecto1.logicadenegocios.ConexionDB;
import proyecto1.logicadenegocios.Juego;
import proyecto1.logicadenegocios.Tombola;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;



/**
 * Clase numerosCantados que se encarga de las operaciones relacionadas con los números cantados en la base de datos.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class numerosCantados {
    ConexionDB cx;
    /**
     * Constructor de la clase numerosCantados.
     * Inicializa la conexión a la base de datos.
     */
    public numerosCantados(){
        cx=new ConexionDB();
    }
    /**
     * Método que inserta un número cantado en la base de datos.
     * 
     * @param numeroBolita Número de la bolita que se desea insertar.
     * @return boolean Retorna true si la inserción fue exitosa, false en caso contrario.
     */
    public boolean insertNumero(int numeroBolita){
        
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
            query = "INSERT INTO numerosCantados (idPartida, numero) VALUES (?, ?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, idPartida);
            ps.setInt(2, numeroBolita);
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
    /**
     * Método que obtiene el top 10 de números cantados en la base de datos.
     * 
     * @return List Lista con los números y sus repeticiones.
     */
    public List<Integer> top10(){
        Connection connection = null;
        List<Integer> DataList= new ArrayList<Integer>();
        
        try{
            connection= cx.conectar();
            Statement statement = connection.createStatement();
            String query = "SELECT numero, COUNT (numero) AS repeticiones FROM numerosCantados GROUP BY numero ORDER BY repeticiones DESC LIMIT 10;";
            ResultSet resultSet= statement.executeQuery(query);
            
            while (resultSet.next()){
                int numero = resultSet.getInt("numero");
                int repeticiones = resultSet.getInt("repeticiones");
                DataList.add(numero);
                DataList.add(repeticiones);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
           
        } catch (Exception e){
            e.printStackTrace();
        }
        return DataList;
    }
    

}
     
