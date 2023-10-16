/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1.logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Jugador {
    private Integer cedula;
    private String nombreCompleto, correo;
    private ArrayList<Carton> cartones;

    public Jugador(Integer pCedula, String pNombreCompleto, String pCorreo){
        setCedula(pCedula);
        setNombreCompleto(pNombreCompleto);
        setCorreo(pCorreo);
        cartones = new ArrayList<>();
    }
    
     public void agregarCarton(Carton carton) {
        cartones.add(carton);
    }
    
    public ArrayList<String> obtenerIDCartones() {
        ArrayList<String> IDs = new ArrayList<>();

        for (Carton carton : cartones) {
            IDs.add(carton.getID());
        }

        return IDs;
    }
    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public boolean tieneCartonConID(String idCartonGanador) {
        for (Carton carton : cartones) {
            if (carton.getID().equals(idCartonGanador)) {
                return true;
            }
        }
        return false;
    }
    
    public String[] obtenerRutasDeCartones() {
        String[] rutas = new String[cartones.size()]; // Crear un arreglo para las rutas
    
        for (int i = 0; i < cartones.size(); i++) {
            Carton carton = cartones.get(i); // Obtener el cartón
            String ID = carton.getID(); // Obtener el ID del cartón
            // Construir la ruta de la imagen
            String ruta = "C:/Users/Daniel/Documents/GitHub/PP1---POO/Proyecto1-Bingo/src/Cartones/" + ID + ".jpg";
            rutas[i] = ruta; // Agregar la ruta al arreglo
        }
    
        return rutas; // Devolver el arreglo de rutas
    }
}
