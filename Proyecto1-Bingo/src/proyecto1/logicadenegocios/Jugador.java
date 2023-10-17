/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.logicadenegocios;

import java.util.ArrayList;

/**
 * Representa un jugador en el juego de bingo.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class Jugador {
    private Integer cedula;
    private String nombreCompleto, correo;
    private ArrayList<Carton> cartones;
    /**
     * Constructor para crear un nuevo jugador.
     * 
     * @param pCedula Cédula del jugador.
     * @param pNombreCompleto Nombre completo del jugador.
     * @param pCorreo Correo electrónico del jugador.
     */
    public Jugador(Integer pCedula, String pNombreCompleto, String pCorreo){
        setCedula(pCedula);
        setNombreCompleto(pNombreCompleto);
        setCorreo(pCorreo);
        cartones = new ArrayList<>();
    }
    /**
     * Agrega un cartón al jugador.
     * 
     * @param carton Cartón a agregar.
     */
     public void agregarCarton(Carton carton) {
        cartones.add(carton);
    }
    /**
     * Obtiene los IDs de los cartones del jugador.
     * 
     * @return Lista de IDs de cartones.
     */
    public ArrayList<String> obtenerIDCartones() {
        ArrayList<String> IDs = new ArrayList<>();

        for (Carton carton : cartones) {
            IDs.add(carton.getID());
        }

        return IDs;
    }
    /**
     * Obtiene la cédula del jugador.
     * 
     * @return Cédula del jugador.
     */
    public int getCedula() {
        return cedula;
    }
    /**
     * Establece la cédula del jugador.
     * 
     * @param cedula Cédula a establecer.
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    /**
     * Obtiene el nombre completo del jugador.
     * 
     * @return Nombre completo del jugador.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    /**
     * Establece el nombre completo del jugador.
     * 
     * @param nombreCompleto Nombre completo a establecer.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    /**
     * Obtiene el correo electrónico del jugador.
     * 
     * @return Correo electrónico del jugador.
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Establece el correo electrónico del jugador.
     * 
     * @param correo Correo electrónico a establecer.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Verifica si el jugador tiene un cartón con el ID especificado.
     * 
     * @param idCartonGanador ID del cartón a verificar.
     * @return Verdadero si el jugador tiene el cartón, falso en caso contrario.
     */
    public boolean tieneCartonConID(String idCartonGanador) {
        for (Carton carton : cartones) {
            if (carton.getID().equals(idCartonGanador)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Obtiene las rutas de los cartones del jugador.
     * 
     * @return Arreglo de rutas de los cartones.
     */
    public String[] obtenerRutasDeCartones() {
        String[] rutas = new String[cartones.size()]; // Crear un arreglo para las rutas

        for (int i = 0; i < cartones.size(); i++) {
            Carton carton = cartones.get(i); // Obtener el cartón
            String ID = carton.getID(); // Obtener el ID del cartón
            // Construir la ruta de la imagen
            String ruta = "C:/Users/Daniel/Documents/GitHub/PP1---POO/Proyecto1-Bingo/src/Cartones/" + ID + ".jpg";
            
            rutas[i] = ruta; // Agregar la ruta al arreglo
        }
        return rutas; // Devolver el arreglo de rutas

    }
}
