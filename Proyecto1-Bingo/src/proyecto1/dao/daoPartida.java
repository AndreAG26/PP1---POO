/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import proyecto1.logicadenegocios.ConexionDB;
import proyecto1.logicadenegocios.Juego;


/**
 * Clase daoPartida que se encarga de las operaciones relacionadas con las partidas en la base de datos.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class daoPartida {
    ConexionDB cx;
    /**
     * Constructor de la clase daoPartida.
     * Inicializa la conexión a la base de datos.
     */
    public daoPartida(){
        cx=new ConexionDB();
    }
    /**
     * Método que inserta una partida en la base de datos.
     * 
     * @param configuracion Configuración del juego que se desea insertar.
     * @return boolean Retorna true si la inserción fue exitosa, false en caso contrario.
     */
    public boolean insertPartida(Juego configuracion){
        PreparedStatement ps=null;
        LocalDate date=LocalDate.now();
        LocalTime hora= LocalTime.now();
        
        try {
            ps=cx.conectar().prepareStatement("INSERT INTO partida VALUES(null, ?,?,?)");
            ps.setString(1, configuracion.getConfiguracion());
            ps.setString(2, date.toString());
            ps.setString(3, hora.toString());
            ps.executeUpdate();
            cx.desconectar();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Método que obtiene la frecuencia de configuraciones de partidas en la base de datos.
     * 
     * @return List<String> Lista con la configuración y su frecuencia.
     */
    public List<String> frecuenciaConfiPartidas(){
        Connection connection = null;
        List<String> DataList= new ArrayList<String>();
        
        try{
            connection= cx.conectar();
            Statement statement = connection.createStatement();
            String query = "SELECT configuracion, COUNT(configuracion) AS repeticiones FROM partida GROUP BY configuracion;";
            ResultSet resultSet= statement.executeQuery(query);
            
            while (resultSet.next()){
                String configuracion = resultSet.getString("configuracion");
                String repeticiones = String.valueOf(resultSet.getInt("repeticiones"));
                
                DataList.add(configuracion); System.out.println(configuracion);
                DataList.add(repeticiones); System.out.println(repeticiones);
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
