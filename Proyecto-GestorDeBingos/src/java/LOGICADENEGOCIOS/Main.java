package LOGICADENEGOCIOS;

import java.util.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        Tombola tombola = new Tombola();
        tombola.rellenarTombola();
        Carton carton = new Carton();
        
        System.out.println("Cantidad de bolitas en la tombola: " + tombola.cantidadDeBolitas());
        
        int numeroSacado = tombola.sacarBolita();
        System.out.println("Número sacado de la tómbola: " + numeroSacado);
        
        System.out.println("Cantidad de bolitas en la tombola: " + tombola.cantidadDeBolitas());
        
        numeroSacado = tombola.sacarBolita();
        System.out.println("Número sacado de la tómbola: " + numeroSacado);
        
        System.out.println("Cantidad de bolitas en la tombola: " + tombola.cantidadDeBolitas());
        
        // Llena las filas automáticamente en el constructor
        ArrayList<Integer> filaB = carton.getFilaB();
        ArrayList<Integer> filaI = carton.getFilaI();
        ArrayList<Integer> filaN = carton.getFilaN();
        ArrayList<Integer> filaG = carton.getFilaG();
        ArrayList<Integer> filaO = carton.getFilaO();

        System.out.println("Cartón creado:");
        System.out.println("Fila B: " + filaB);
        System.out.println("Fila I: " + filaI);
        System.out.println("Fila N: " + filaN);
        System.out.println("Fila G: " + filaG);
        System.out.println("Fila O: " + filaO);
        
        carton.imprimirCarton();
    }
}
