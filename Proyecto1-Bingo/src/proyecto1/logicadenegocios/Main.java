package proyecto1.logicadenegocios;
import proyecto1.bingo.GenerarCartones;

import java.util.*;
import proyecto1.dao.daoJugador;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        Juego juego = new Juego();
        
        juego.crearCartones(10);
    
        
        juego.asignarCartonesAJugador(117870118, 3);
        juego.asignarCartonesAJugador(217870118, 2);
        
         for (Jugador jugador : juego.getJugadores()) {
            System.out.println("Nombre del jugador: " + jugador.getNombreCompleto());
            ArrayList<String> IDsCartones = jugador.obtenerIDCartones();
            System.out.println("ID de los cartones del jugador:");
            for (String ID : IDsCartones) {
                System.out.println(ID);
            }
            System.out.println();
        }
        String idCartonGanador = juego.jugarHastaCuatroEsquinas();
        Jugador jugadorGanador = juego.encontrarJugadorPorIDCarton(idCartonGanador);

        if (jugadorGanador != null) {
            System.out.println("¡El ganador es " + jugadorGanador.getNombreCompleto() + "!");}
        else {
            System.out.println("El Carton no esta asigado");
        }   
       
    }

    /*public static void main(String[] args) {

        GenerarCartones juego= new GenerarCartones();
        juego.setVisible(true);
        juego.setLocationRelativeTo(null);
    }*/
    
}
