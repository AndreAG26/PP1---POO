import java.util.*;

/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    private ArrayList<Carton> Cartones;
    private Tombola tombola;
    private ArrayList<Integer> bolitasSacadas; 
    
    
    public Juego()
    {
        Cartones = new ArrayList<>();
        tombola = new Tombola();
        bolitasSacadas = new ArrayList<>();
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
    
    
}
