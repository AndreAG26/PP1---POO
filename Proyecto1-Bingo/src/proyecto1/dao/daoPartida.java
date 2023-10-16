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
 *
 * @author Dell
 */
public class daoPartida {
    ConexionDB cx;

    public daoPartida(){
        cx=new ConexionDB();
    }

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
        
    /**
     *
     * @param args
     */
    /*public static void main(String[] args){
        Juego partida= new Juego();
        daoPartida dao = new daoPartida();
        /*Map<String, Integer> datos= new HashMap<>();
        partida.setConfiguracion("Cartón lleno");
        if (dao.insertPartida(partida)){
            System.out.println("Inserción exitosa");
        }else{
            System.out.println("ERROR");
        }
        dao.frecuenciaConfiPartidas();
    }*/
        
}
