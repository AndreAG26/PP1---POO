import java.util.*;
import java.util.Random;
/**
 * Write a description of class Tombola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tombola
{
    private   ArrayList<Integer> bolitas; 
    private Random random = new Random();

    /**
     * Constructor for objects of class Tombola
     */
    public Tombola()
    {
        bolitas = new ArrayList();
        random = new Random();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void rellenarTombola()
    {
        for (int i = 1; i <= 75; i++) {
            bolitas.add(i);
        }
    }
    
    public int sacarBolita(){
         if (!bolitas.isEmpty()) {
            int indiceAleatorio = random.nextInt(bolitas.size());
            int numeroAleatorio = bolitas.get(indiceAleatorio);
            bolitas.remove(indiceAleatorio);
            return numeroAleatorio;
        } else {
            return -1; // Otra forma de indicar que no hay bolitas
        }
    }
    
    public int cantidadDeBolitas() {
        return bolitas.size();
    }
}

