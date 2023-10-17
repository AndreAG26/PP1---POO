package proyecto1.logicadenegocios;
import java.io.IOException;
import proyecto1.dao.daoJugador;
import java.util.*;
import javax.swing.JOptionPane;


/**
 * La clase Juego representa la lógica principal del juego de bingo.
 * Contiene métodos para crear cartones, sacar bolitas y verificar
 * diferentes modalidades de bingo.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class Juego {
    private final ArrayList<Carton> Cartones;
    private final Tombola tombola;
    private final ArrayList<Integer> bolitasSacadas; 
    private final List<Jugador> Jugadores;
    private  String configuracion;
    
    
    /**
     * Constructor para la clase Juego.
     * Inicializa las listas de cartones, bolitas sacadas y jugadores.
     */
    public Juego(){
        Cartones = new ArrayList<>();
        tombola = new Tombola();
        bolitasSacadas = new ArrayList<>();
        daoJugador jugadores= new daoJugador();
        Jugadores = jugadores.cargarJugadores();
    }
     /**
     * Crea una cantidad determinada de cartones y los añade a la lista de cartones.
     * 
     * @param n Número de cartones a crear.
     */
    public void crearCartones(int n){
        for( int i = 0; i < n; i++){
            Carton nuevoCarton = new Carton(); 
            nuevoCarton.imprimirCarton();
            Cartones.add(nuevoCarton);
        }
    }
    

    /**
     * Saca una bolita de la tómbola y la añade a la lista de bolitas sacadas.
     */
    public void sacarBolita(){
        int bolita = tombola.sacarBolita();
        System.out.println(bolita);
        bolitasSacadas.add(bolita);
    }
     /**
     * Verifica si alguna de las cartas tiene las cuatro esquinas marcadas.
     *
     * @return true si alguna de las cartas tiene las cuatro esquinas marcadas, false en caso contrario.
     */
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
    /**
  * Devuelve el ID del cartón que tiene las cuatro esquinas marcadas.
  *
  * @return ID del cartón con las cuatro esquinas marcadas o null si ninguno cumple con la condición.
  */
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
   /**
 * Verifica si alguna de las cartas cumple con la modalidad de "bingo en X".
 *
 * @return true si alguna de las cartas cumple con la modalidad, false en caso contrario.
 */
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
    /**
 * Devuelve el ID del cartón que cumple con la modalidad de "bingo en X".
 *
 * @return ID del cartón que cumple con la modalidad o null si ninguno cumple con la condición.
 */
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
    /**
 * Verifica si alguna de las cartas cumple con la modalidad de "bingo en Z".
 *
 * @return true si alguna de las cartas cumple con la modalidad, false en caso contrario.
 */
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
    /**
 * Devuelve el ID del cartón que cumple con la modalidad de "bingo en Z".
 *
 * @return ID del cartón que cumple con la modalidad o null si ninguno cumple con la condición.
 */
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
    /**
 * Verifica si alguna de las cartas está completamente marcada.
 *
 * @return true si alguna de las cartas está completamente marcada, false en caso contrario.
 */
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
    /**
 * Devuelve el ID del cartón que está completamente marcado.
 *
 * @return ID del cartón completamente marcado o null si ninguno cumple con la condición.
 */
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
     /**
 * Busca y devuelve un jugador basado en su número de cédula.
 *
 * @param numeroCedula El número de cédula del jugador a buscar.
 * @return El jugador con el número de cédula proporcionado o null si no se encuentra.
 */
    
    public Jugador buscarJugadorPorCedula(int numeroCedula) {
        for (Jugador jugador : Jugadores) {
            if (jugador.getCedula() == numeroCedula) {
                return jugador; // Devuelve el jugador si se encuentra
            }
        }
        return null; // Si no se encuentra, devuelve null
    }
    /**
 * Asigna una cantidad específica de cartones a un jugador identificado por su número de cédula.
 *
 * @param numeroCedula Número de cédula del jugador al que se le asignarán los cartones.
 * @param cantidad Cantidad de cartones a asignar.
 * @throws IOException Si ocurre un error al enviar el correo.
 */
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
        }

        String[] rutasDeCartones = jugador.obtenerRutasDeCartones();
        String correo = jugador.getCorreo();
        CuentaCorreo cuentaCorreo = new CuentaCorreo("gestorbingos@gmail.com");
        cuentaCorreo.enviarCorreo(correo, rutasDeCartones);

        if (cartonesAgregados < cantidad) {
            JOptionPane.showMessageDialog(null, "No se pudieron asignar la cantidad deseada de cartones debido a que algunos están reservados", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("No se pudieron asignar la cantidad deseada de cartones debido a que algunos están reservados. Se asignaron " + cartonesAgregados + " cartones.");
        } else {
            System.out.println("Se han asignado " + cartonesAgregados + " cartones al jugador.");
        }
    }

    /**
 * Juega hasta que se cumpla la modalidad de "bingo en X".
 *
 * @return ID del cartón que cumple con la modalidad de "bingo en X".
 */
    public String jugarHastaX() {
        while (!verificarBingoEnX() ) {
            sacarBolita();
        }

        return devolverIDX();
    }
    /**
 * Juega hasta que se cumpla la modalidad de "bingo en Z".
 *
 * @return ID del cartón que cumple con la modalidad de "bingo en Z".
 */

    public String jugarHastaZ() {
        while (!verificarBingoEnZ()) {
            sacarBolita();
        }

        return devolverIDZ();
    }
    /**
 * Juega hasta que un cartón esté completamente lleno.
 *
 * @return ID del cartón que está completamente lleno.
 */
    public String jugarHastaLleno(){
        while (!verificarBingoCompleto()) {
            sacarBolita();
        }
        return devolverIDCompleto();
    }
    /**
 * Juega hasta que se cumpla la modalidad de "cuatro esquinas".
 *
 * @return ID del cartón que cumple con la modalidad de "cuatro esquinas".
 */
    public String jugarHastaCuatroEsquinas() {
        
        while (!verificarCuatroEsquinas()) {
            sacarBolita();
        }

        return devolverID4Esquinas();
    }
    /**
 * Encuentra un jugador basado en el ID de un cartón ganador.
 *
 * @param idCartonGanador ID del cartón ganador.
 * @return El jugador que tiene el cartón con el ID proporcionado o null si no se encuentra.
 */
    public Jugador encontrarJugadorPorIDCarton(String idCartonGanador) {
        for (Jugador jugador : Jugadores) {
            if (jugador.tieneCartonConID(idCartonGanador)) {
                return jugador;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }
    /**
 * Obtiene la lista de cartones.
 *
 * @return Lista de cartones.
 */
     public ArrayList<Carton> getCartones() {
        return Cartones;
    }
    /**
 * Obtiene la lista de jugadores.
 *
 * @return Lista de jugadores.
 */
    public List<Jugador> getJugadores() {
        return Jugadores;
    }
/**
 * Establece la configuración del juego.
 *
 * @param configuracion Configuración del juego.
 */
    public void setConfiguracion(String configuracion){
        this.configuracion=configuracion;
    }
    /**
 * Obtiene la configuración del juego.
 *
 * @return Configuración del juego.
 */
    public String getConfiguracion(){
        return configuracion;
    }
    /**
 * Obtiene la tómbola del juego.
 *
 * @return Tómbola del juego.
 */
    public Tombola getTombola() {
        return tombola;
    }
    /**
 * Obtiene la lista de bolitas que han sido sacadas.
 *
 * @return Lista de bolitas sacadas.
 */
    public ArrayList<Integer> getBolitasSacadas() {
        return bolitasSacadas;
    }
}
