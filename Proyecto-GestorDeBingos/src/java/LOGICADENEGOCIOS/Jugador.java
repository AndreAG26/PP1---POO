/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICADENEGOCIOS;

/**
 *
 * @author Dell
 */
public class Jugador {
    int cedula;
    String nombreCompleto, correo;

    public Jugador(){
       
    }
    
    public Jugador(int cedula, String nombre, String correo){
       setCedula(cedula);
       setNombreCompleto(nombre);
       setCorreo(correo);
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
}
