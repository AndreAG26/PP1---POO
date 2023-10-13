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
        try {
            connection = cx.conectar();
            // Obtener el ID del último dato insertado
            int idPartida;
            PreparedStatement idPartidaActual = connection.prepareStatement("SELECT idPartida FROM partida ORDER BY idPartida DESC LIMIT 1");
            
            try (ResultSet resultSet = idPartidaActual.executeQuery()) {
                if (resultSet.next()) {
                    idPartida = resultSet.getInt(1);
                } else {
                    // No se pudo obtener el ID, maneja el error aquí
                    System.out.println("No se pudo obtener el ID de la partida insertada.");
                    return false;
                }
            }
            
            // Insertar el ID en la tabla 'numerosCantados'
            PreparedStatement insertNumerosCantadosStatement = connection.prepareStatement("INSERT INTO numerosCantados (idPartida, numero) VALUES (?, ?)");
            insertNumerosCantadosStatement.setInt(1, idPartida);
            insertNumerosCantadosStatement.setInt(2, numeroBolita); 
            insertNumerosCantadosStatement.executeUpdate();
            cx.desconectar();
            return true;
            
        }   catch (SQLException ex) {
            Logger.getLogger(numerosCantados.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    /*public static void main(String[] args){
        Tombola bolita= new Tombola();
        numerosCantados dao= new numerosCantados();
        int numBolita=75;
        if (dao.insertNumero(numBolita)){
            System.out.println("Inserción exitosa");
        }else{
            System.out.println("ERROR");
        }
    }*/
        
        
}
