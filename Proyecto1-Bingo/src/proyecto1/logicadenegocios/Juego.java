package proyecto1.logicadenegocios;
import java.io.IOException;
import proyecto1.dao.daoJugador;
import java.util.*;


/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego {
    private final ArrayList<Carton> Cartones;
    private final Tombola tombola;
    private final ArrayList<Integer> bolitasSacadas; 
    private final List<Jugador> Jugadores;
    private  String configuracion;
    

    public Juego(){
        Cartones = new ArrayList<>();
        tombola = new Tombola();
        bolitasSacadas = new ArrayList<>();
        daoJugador jugadores= new daoJugador();
        Jugadores = jugadores.cargarJugadores();
    }
    
    public void crearCartones(int n){
        for( int i = 0; i < n; i++){
            Carton nuevoCarton = new Carton(); 
            nuevoCarton.imprimirCarton();
            Cartones.add(nuevoCarton);
        }
    }
    

    
    public void sacarBolita(){
        int bolita = tombola.sacarBolita();
        System.out.println(bolita);
        bolitasSacadas.add(bolita);
    }
    
    public boolean verificarCuatroEsquinas() {
        for (Carton carton : Cartones) {
        // Verificar si las cuatro esquinas coinciden con números en bolitas
            int esquinaSuperiorIzquierda = carton.getFilaB().get(0);
            int esquinaSuperiorDerecha = carton.getFilaB().get(4);
            int esquinaInferiorIzquierda = carton.getFilaO().get(0);
            int esquinaInferiorDerecha = carton.getFilaO().get(4);
        
            if (bolitasSacadas.contains(esquinaSuperiorIzquierda) &&
                bolitasSacadas.contains(esquinaSuperiorDerecha) &&
                bolitasSacadas.contains(esquinaInferiorIzquierda) &&
                bolitasSacadas.contains(esquinaInferiorDerecha)) {
                    return true; // El cartón tiene las cuatro esquinas
            }
        }
        return false; // Ningún cartón tiene las cuatro esquinas
   }
   
   public String devolverID4Esquinas() {
        for (Carton carton : Cartones) {
        // Verificar si las cuatro esquinas coinciden con números en bolitas
            int esquinaSuperiorIzquierda = carton.getFilaB().get(0);
            int esquinaSuperiorDerecha = carton.getFilaB().get(4);
            int esquinaInferiorIzquierda = carton.getFilaO().get(0);
            int esquinaInferiorDerecha = carton.getFilaO().get(4);
        
            if (bolitasSacadas.contains(esquinaSuperiorIzquierda) &&
                bolitasSacadas.contains(esquinaSuperiorDerecha) &&
                bolitasSacadas.contains(esquinaInferiorIzquierda) &&
                bolitasSacadas.contains(esquinaInferiorDerecha)) {
                    return carton.getID(); // El cartón tiene las cuatro esquinas
            }
        }
        return null; // Ningún cartón tiene las cuatro esquinas
   }
   
   public boolean verificarBingoEnX() {
       for (Carton carton : Cartones) {
        // Obtener las filas del cartón
            ArrayList<Integer> filaB = carton.getFilaB();
            ArrayList<Integer> filaI = carton.getFilaI();
            ArrayList<Integer> filaN = carton.getFilaN();
            ArrayList<Integer> filaG = carton.getFilaG();
            ArrayList<Integer> filaO = carton.getFilaO();

        // Verificar si las filas cumplen con la modalidad de "bingo en X"
            if (bolitasSacadas.contains(filaB.get(0)) &&
                bolitasSacadas.contains(filaB.get(4)) &&
                bolitasSacadas.contains(filaI.get(1)) &&
                bolitasSacadas.contains(filaI.get(3)) &&
                bolitasSacadas.contains(filaN.get(2)) &&
                bolitasSacadas.contains(filaG.get(3)) &&
                bolitasSacadas.contains(filaG.get(1)) &&
                bolitasSacadas.contains(filaO.get(0)) &&
                bolitasSacadas.contains(filaO.get(4))) {
                return true; // El cartón cumple con la modalidad de "bingo en X"
            }
        }
        return false; // Ningún cartón cumple con la modalidad de "bingo en X"
    }
    
    public String devolverIDX(){
       for (Carton carton : Cartones) {
        // Obtener las filas del cartón
            ArrayList<Integer> filaB = carton.getFilaB();
            ArrayList<Integer> filaI = carton.getFilaI();
            ArrayList<Integer> filaN = carton.getFilaN();
            ArrayList<Integer> filaG = carton.getFilaG();
            ArrayList<Integer> filaO = carton.getFilaO();

        // Verificar si las filas cumplen con la modalidad de "bingo en X"
            if (bolitasSacadas.contains(filaB.get(0)) &&
                bolitasSacadas.contains(filaB.get(4)) &&
                bolitasSacadas.contains(filaI.get(1)) &&
                bolitasSacadas.contains(filaI.get(3)) &&
                bolitasSacadas.contains(filaN.get(2)) &&
                bolitasSacadas.contains(filaG.get(3)) &&
                bolitasSacadas.contains(filaG.get(1)) &&
                bolitasSacadas.contains(filaO.get(0)) &&
                bolitasSacadas.contains(filaO.get(4))) {
                return carton.getID(); // El cartón cumple con la modalidad de "bingo en X"
            }
        }
        return null; // Ningún cartón cumple con la modalidad de "bingo en X"
    }
    
    public boolean verificarBingoEnZ() {
        for (Carton carton : Cartones) {
            ArrayList<Integer> filaB = carton.getFilaB();
            ArrayList<Integer> filaI = carton.getFilaI();
            ArrayList<Integer> filaN = carton.getFilaN();
            ArrayList<Integer> filaG = carton.getFilaG();
            ArrayList<Integer> filaO = carton.getFilaO();

        // Verificar si las filas cumplen con la modalidad de "bingo en X"
            if (bolitasSacadas.contains(filaB.get(0)) &&
                bolitasSacadas.contains(filaB.get(4)) &&
                bolitasSacadas.contains(filaI.get(0)) &&
                bolitasSacadas.contains(filaI.get(3)) &&
                bolitasSacadas.contains(filaI.get(4)) &&
                bolitasSacadas.contains(filaN.get(0)) &&
                bolitasSacadas.contains(filaN.get(2)) &&
                bolitasSacadas.contains(filaN.get(4)) &&
                bolitasSacadas.contains(filaG.get(0)) &&
                bolitasSacadas.contains(filaG.get(1)) &&
                bolitasSacadas.contains(filaG.get(4)) &&
                bolitasSacadas.contains(filaO.get(0)) &&
                bolitasSacadas.contains(filaO.get(4))) {
                return true; // El cartón cumple con la modalidad de "bingo en X"
            }
        }
        return false; // Ningún cartón cumple con la modalidad de "bingo en X"
    }
    
    public String devolverIDZ() {
        for (Carton carton : Cartones) {
            ArrayList<Integer> filaB = carton.getFilaB();
            ArrayList<Integer> filaI = carton.getFilaI();
            ArrayList<Integer> filaN = carton.getFilaN();
            ArrayList<Integer> filaG = carton.getFilaG();
            ArrayList<Integer> filaO = carton.getFilaO();

        // Verificar si las filas cumplen con la modalidad de "bingo en X"
            if (bolitasSacadas.contains(filaB.get(0)) &&
                bolitasSacadas.contains(filaB.get(4)) &&
                bolitasSacadas.contains(filaI.get(0)) &&
                bolitasSacadas.contains(filaI.get(3)) &&
                bolitasSacadas.contains(filaI.get(4)) &&
                bolitasSacadas.contains(filaN.get(0)) &&
                bolitasSacadas.contains(filaN.get(2)) &&
                bolitasSacadas.contains(filaN.get(4)) &&
                bolitasSacadas.contains(filaG.get(0)) &&
                bolitasSacadas.contains(filaG.get(1)) &&
                bolitasSacadas.contains(filaG.get(4)) &&
                bolitasSacadas.contains(filaO.get(0)) &&
                bolitasSacadas.contains(filaO.get(4))) {
                return carton.getID(); // El cartón cumple con la modalidad de "bingo en X"
            }
        }
        return null; // Ningún cartón cumple con la modalidad de "bingo en X"
    }
    
     public boolean verificarBingoCompleto() {
        for (Carton carton : Cartones) {
            // Obtener las filas del cartón
            ArrayList<Integer> filaB = carton.getFilaB();
            ArrayList<Integer> filaI = carton.getFilaI();
            ArrayList<Integer> filaN = carton.getFilaN();
            ArrayList<Integer> filaG = carton.getFilaG();
            ArrayList<Integer> filaO = carton.getFilaO();

        // Verificar si las filas cumplen con la modalidad de "bingo en X"
            if (bolitasSacadas.contains(filaB.get(0)) &&
                bolitasSacadas.contains(filaB.get(1)) &&
                bolitasSacadas.contains(filaB.get(2)) &&
                bolitasSacadas.contains(filaB.get(3)) &&
                bolitasSacadas.contains(filaB.get(4)) &&
                bolitasSacadas.contains(filaI.get(0)) &&
                bolitasSacadas.contains(filaI.get(1)) &&
                bolitasSacadas.contains(filaI.get(2)) &&
                bolitasSacadas.contains(filaI.get(3)) &&
                bolitasSacadas.contains(filaI.get(4)) &&
                bolitasSacadas.contains(filaN.get(0)) &&
                bolitasSacadas.contains(filaN.get(1)) &&
                bolitasSacadas.contains(filaN.get(2)) &&
                bolitasSacadas.contains(filaN.get(3)) &&
                bolitasSacadas.contains(filaN.get(4)) &&
                bolitasSacadas.contains(filaG.get(0)) &&
                bolitasSacadas.contains(filaG.get(1)) &&
                bolitasSacadas.contains(filaG.get(2)) &&
                bolitasSacadas.contains(filaG.get(3)) &&
                bolitasSacadas.contains(filaG.get(4)) &&
                bolitasSacadas.contains(filaO.get(0)) &&
                bolitasSacadas.contains(filaO.get(1)) &&
                bolitasSacadas.contains(filaO.get(2)) &&
                bolitasSacadas.contains(filaO.get(3)) &&
                bolitasSacadas.contains(filaO.get(4))) {
                return true; // El cartón cumple con la modalidad de "bingo en X"
            }
        }
        return false; // Ningún cartón cumple con la modalidad de "bingo en X"
    }
    
     public String devolverIDCompleto() {
        for (Carton carton : Cartones) {
            // Obtener las filas del cartón
            ArrayList<Integer> filaB = carton.getFilaB();
            ArrayList<Integer> filaI = carton.getFilaI();
            ArrayList<Integer> filaN = carton.getFilaN();
            ArrayList<Integer> filaG = carton.getFilaG();
            ArrayList<Integer> filaO = carton.getFilaO();

        // Verificar si las filas cumplen con la modalidad de "bingo en X"
            if (bolitasSacadas.contains(filaB.get(0)) &&
                bolitasSacadas.contains(filaB.get(1)) &&
                bolitasSacadas.contains(filaB.get(2)) &&
                bolitasSacadas.contains(filaB.get(3)) &&
                bolitasSacadas.contains(filaB.get(4)) &&
                bolitasSacadas.contains(filaI.get(0)) &&
                bolitasSacadas.contains(filaI.get(1)) &&
                bolitasSacadas.contains(filaI.get(2)) &&
                bolitasSacadas.contains(filaI.get(3)) &&
                bolitasSacadas.contains(filaI.get(4)) &&
                bolitasSacadas.contains(filaN.get(0)) &&
                bolitasSacadas.contains(filaN.get(1)) &&
                bolitasSacadas.contains(filaN.get(2)) &&
                bolitasSacadas.contains(filaN.get(3)) &&
                bolitasSacadas.contains(filaN.get(4)) &&
                bolitasSacadas.contains(filaG.get(0)) &&
                bolitasSacadas.contains(filaG.get(1)) &&
                bolitasSacadas.contains(filaG.get(2)) &&
                bolitasSacadas.contains(filaG.get(3)) &&
                bolitasSacadas.contains(filaG.get(4)) &&
                bolitasSacadas.contains(filaO.get(0)) &&
                bolitasSacadas.contains(filaO.get(1)) &&
                bolitasSacadas.contains(filaO.get(2)) &&
                bolitasSacadas.contains(filaO.get(3)) &&
                bolitasSacadas.contains(filaO.get(4))) {
                return carton.getID(); // El cartón cumple con la modalidad de "bingo en X"
            }
        }
        return null; // Ningún cartón cumple con la modalidad de "bingo en X"
    }
    
    public Jugador buscarJugadorPorCedula(int numeroCedula) {
        for (Jugador jugador : Jugadores) {
            if (jugador.getCedula() == numeroCedula) {
                return jugador; // Devuelve el jugador si se encuentra
            }
        }
        return null; // Si no se encuentra, devuelve null
    }
    
    public void asignarCartonesAJugador(int numeroCedula, int cantidad) throws IOException {
        Jugador jugador = buscarJugadorPorCedula(numeroCedula);
        
        if (jugador == null) {
            System.out.println("Jugador no encontrado.");
            return;
        }
        
        if (Cartones.isEmpty()) {
            System.out.println("No hay cartones disponibles para asignar.");
            return;
        }

        int cartonesAgregados = 0; // Contador de cartones agregados

        for (Carton carton : Cartones) {
            if (carton.getEstado() == Carton.EstadoCarton.LIBRE && cartonesAgregados < cantidad) {
                carton.setEstado(Carton.EstadoCarton.RESERVADO);
                jugador.agregarCarton(carton); // Agregar el cartón al jugador
                cartonesAgregados++;
            }
            
            
            if (cartonesAgregados == cantidad) {
                break; // Si hemos agregado la cantidad deseada, salir del bucle
            }

        
            String[] rutasDeCartones = jugador.obtenerRutasDeCartones();
            String correo = jugador.getCorreo();
            CuentaCorreo cuentaCorreo = new CuentaCorreo("gestorbingos@gmail.com");
            cuentaCorreo.enviarCorreo(correo, rutasDeCartones);

            if (cartonesAgregados < cantidad) {
                System.out.println("No se pudieron asignar la cantidad deseada de cartones debido a que algunos están reservados. Se asignaron " + cartonesAgregados + " cartones.");
            } 
            else {
                System.out.println("Se han asignado " + cartonesAgregados + " cartones al jugador.");
            }
        }   
    }
    
    public String jugarHastaCuatroEsquinas() {
        
        while (!verificarCuatroEsquinas()) {
            sacarBolita();
        }

        return devolverID4Esquinas();
    }
    
    public Jugador encontrarJugadorPorIDCarton(String idCartonGanador) {
        for (Jugador jugador : Jugadores) {
            if (jugador.tieneCartonConID(idCartonGanador)) {
                return jugador;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }
    
     public ArrayList<Carton> getCartones() {
        return Cartones;
    }
    
    public List<Jugador> getJugadores() {
        return Jugadores;
    }

    public void setConfiguracion(String configuracion){
        this.configuracion=configuracion;
    }
    
    public String getConfiguracion(){
        return configuracion;
    }
    public Tombola getTombola() {
        return tombola;
    }
    public ArrayList<Integer> getBolitasSacadas() {
        return bolitasSacadas;
    }
}
