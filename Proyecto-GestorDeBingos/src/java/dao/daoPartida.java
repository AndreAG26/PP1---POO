/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import LOGICADENEGOCIOS.ConexionDB;
import LOGICADENEGOCIOS.Juego;



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
        
    /**
     *
     * @param args
     */
    /*public static void main(String[] args){
        Juego partida= new Juego();
        daoPartida dao = new daoPartida();
        partida.setConfiguracion("Cartón lleno");
        if (dao.insertPartida(partida)){
            System.out.println("Inserción exitosa");
        }else{
            System.out.println("ERROR");
        }
    }*/
        
}
