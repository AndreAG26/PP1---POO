package proyecto1.logicadenegocios;

import java.util.*;
import java.util.Random;
import proyecto1.dao.numerosCantados;
/**
 * Representa una tómbola en el juego de bingo, que contiene bolitas numeradas.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public class Tombola
{
    private final   ArrayList<Integer> bolitas; 
    private Random random = new Random();

    /**
     * Constructor que inicializa una tómbola con bolitas numeradas.
     */
    public Tombola()
    {
        bolitas = new ArrayList();
        rellenarTombola();
    }

    /**
     * Rellena la tómbola con bolitas numeradas del 1 al 75.
     */
    public void rellenarTombola()
    {
        for (int i = 1; i <= 75; i++) {
            bolitas.add(i);
        }
    }
    /**
     * Saca una bolita de la tómbola de forma aleatoria y la registra como cantada.
     * 
     * @return El número de la bolita sacada. Si no hay bolitas, devuelve -1.
     */
    public int sacarBolita(){
         random = new Random();
         if (!bolitas.isEmpty()) {
            int indiceAleatorio = random.nextInt(bolitas.size());
            int numeroAleatorio = bolitas.get(indiceAleatorio);
            bolitas.remove(indiceAleatorio);
            numerosCantados bolita= new numerosCantados();
            bolita.insertNumero(numeroAleatorio);
            return numeroAleatorio;
        } else {
            return -1; // Otra forma de indicar que no hay bolitas
        }
    }
    /**
     * Obtiene la cantidad de bolitas que quedan en la tómbola.
     * 
     * @return Cantidad de bolitas restantes.
     */
    public int cantidadDeBolitas() {
        return bolitas.size();
    }
}

