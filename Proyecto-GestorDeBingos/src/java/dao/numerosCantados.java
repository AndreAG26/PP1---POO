/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import LOGICADENEGOCIOS.ConexionDB;
import LOGICADENEGOCIOS.Juego;
import LOGICADENEGOCIOS.Tombola;

import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Dell
 */
public class numerosCantados {
    ConexionDB cx;

    public numerosCantados(){
        cx=new ConexionDB();
    }

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
    
    /*public static void main(String[] args){
        numerosCantados dao= new numerosCantados();
        int numBolita=75;
        if (dao.insertNumero(numBolita)){
            System.out.println("Inserción exitosa");
        }else{
            System.out.println("ERROR");
        }
    }*/
}
     
