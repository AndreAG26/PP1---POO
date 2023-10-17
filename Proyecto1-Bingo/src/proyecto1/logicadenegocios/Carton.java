package proyecto1.logicadenegocios;

import java.util.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * La clase Carton representa un cartón de bingo con sus respectivas filas y números.
 * Cada cartón tiene un identificador único y cinco filas correspondientes a las letras B, I, N, G, O.
 * Además, cada cartón tiene un estado que puede ser RESERVADO o LIBRE.
 * 
 * @author Daniel Arce, Andrea Alemán y Joustin Montenegro
 * @version 16/10/2023
 */
public final class Carton
{
    private final String idCarton;
    private final ArrayList<Integer> filaB;
    private final ArrayList<Integer> filaI;
    private final ArrayList<Integer> filaN;
    private final ArrayList<Integer> filaG;
    private final ArrayList<Integer> filaO;
    private EstadoCarton estado; // Campo de estado como una enumeración

    /**
     * Enumeración que representa los estados posibles de un cartón.
     */
    public enum EstadoCarton {
        RESERVADO, LIBRE
    }
    /**
     * Constructor por defecto de la clase Carton.
     * Inicializa el cartón con un identificador único y rellena las filas con números aleatorios.
     */
    public Carton() {
        idCarton = generarIdentificador() ;
        filaB = new ArrayList<>();
        filaI = new ArrayList<>();
        filaN = new ArrayList<>();
        filaG = new ArrayList<>();
        filaO = new ArrayList<>();
        
        rellenarFilaB();
        rellenarFilaI();
        rellenarFilaN();
        rellenarFilaG();
        rellenarFilaO();
        
        estado = EstadoCarton.LIBRE;
    }
    /**
     * Rellena la fila B con cinco números aleatorios entre 1 y 15.
     */
    public void rellenarFilaB() {
        // Crea una instancia de Random para generar números aleatorios
        Random random = new Random();

        // Llena la filaB con 5 números aleatorios del 1 al 15
        Set<Integer> numerosGenerados = new HashSet<>();

        while (numerosGenerados.size() < 5) {
            int numeroAleatorio = random.nextInt(15) + 1; // Genera un número entre 1 y 15
            if (numerosGenerados.add(numeroAleatorio)) {
                // Agrega el número a la filaB solo si no se ha generado previamente
                filaB.add(numeroAleatorio);
            }
        }
    }
    
    public void rellenarFilaI() {
         // Crea una instancia de Random para generar números aleatorios
         Random random = new Random();
        Set<Integer> numerosGenerados = new HashSet<>();

        while (numerosGenerados.size() < 5) {
            int numeroAleatorio = random.nextInt(15) + 16; // Genera un número entre 16 y 30
            if (numerosGenerados.add(numeroAleatorio)) {
                // Agrega el número a la filaB solo si no se ha generado previamente
                filaI.add(numeroAleatorio);
            }
        }
    }
    
    public void rellenarFilaN() {
        // Crea una instancia de Random para generar números aleatorios
        Random random = new Random();
        
        Set<Integer> numerosGenerados = new HashSet<>();

        while (numerosGenerados.size() < 5) {
            int numeroAleatorio = random.nextInt(15) + 31; // Genera un número entre 31 y 45
            if (numerosGenerados.add(numeroAleatorio)) {
                // Agrega el número a la filaB solo si no se ha generado previamente
                filaN.add(numeroAleatorio);
            }
        }
    }
    
    public void rellenarFilaG() {
        // Crea una instancia de Random para generar números aleatorios
        Random random = new Random();
        
        Set<Integer> numerosGenerados = new HashSet<>();

        while (numerosGenerados.size() < 5) {
            int numeroAleatorio = random.nextInt(15) + 46; // Genera un número entre 1 y 15
            if (numerosGenerados.add(numeroAleatorio)) {
                // Agrega el número a la filaB solo si no se ha generado previamente
                filaG.add(numeroAleatorio);
            }
        }
    }
    
     public void rellenarFilaO() {
        // Crea una instancia de Random para generar números aleatorios
        Random random = new Random();
         Set<Integer> numerosGenerados = new HashSet<>();

        while (numerosGenerados.size() < 5) {
            int numeroAleatorio = random.nextInt(15) + 61; // Genera un número entre 1 y 15
            if (numerosGenerados.add(numeroAleatorio)) {
                // Agrega el número a la filaB solo si no se ha generado previamente
                filaO.add(numeroAleatorio);
            }
        }
    }
    /**
     * Genera un identificador único para el cartón compuesto por tres letras seguidas de tres números.
     * @return String que representa el identificador único.
     */
    public static String generarIdentificador() {
        // Caracteres alfanuméricos permitidos
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        Random random = new Random();
        StringBuilder identificador = new StringBuilder();

        // Genera las tres letras al principio
        for (int i = 0; i < 3; i++) {
            int indice = random.nextInt(letras.length());
            identificador.append(letras.charAt(indice));
        }

        // Genera los tres números a continuación
        for (int i = 0; i < 3; i++) {
            int indice = random.nextInt(numeros.length());
            identificador.append(numeros.charAt(indice));
        }

        return identificador.toString();
    }
    /**
     * Imprime el cartón en una imagen con las filas y números correspondientes.
     */
    public void imprimirCarton(){
        BufferedImage image = new BufferedImage(700, 700, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        
        // Establecer un fondo blanco
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 700, 700);

        // Definir una fuente y color para el texto
        g.setFont(new Font("Arial", Font.PLAIN, 50));
        g.setColor(Color.BLACK);

        // Dibujar las filas en la imagen
        int x = 100;
        int y = 70;

        String[] letras = {" B", " I", " N", " G", " O"};
        
        for( int i = 0; i < 5; i++){
            g.drawString(letras[i], x + i * 100, y);
        }
        
        y += 100;
        
        for (int i = 0; i < 5; i++) {
            // Dibujar solo los números de cada fila
            g.drawString(filaB.get(i).toString(), x, y + i * 100);
            g.drawString(filaI.get(i).toString(), x + 100, y + i * 100);
            g.drawString(filaN.get(i).toString(), x + 200, y + i * 100);
            g.drawString(filaG.get(i).toString(), x + 300, y + i * 100);
            g.drawString(filaO.get(i).toString(), x + 400, y + i * 100);
            
        }
        
        
        for (int i = 0; i <= 5; i++) {
            x = 80; // Posición en el eje x
            int startY = 20; // Coordenada inicial en el eje y
            int endY = 590; // Coordenada final en el eje y
             // Configurar el grosor de la línea
            float grosorLinea = 4.0f; // Grosor de la línea en píxeles
            BasicStroke stroke = new BasicStroke(grosorLinea);
            g.setStroke(stroke);
            
            if( i == 0 || i == 5){
                endY = 690;
            }

            g.setColor(Color.BLACK);
            g.drawLine(x + i * 100, startY, x + i * 100, endY);
        }
        
        y = 20;
        int startX = 80; // Coordenada inicial en el eje x
        int endX = 580; // Coordenada final en el eje x
        g.setColor(Color.BLACK);
        g.drawLine(startX, y, endX, y);
        
        for (int i = 0; i <= 6; i++) {
             y = 90;
             g.setColor(Color.BLACK);
             g.drawLine(startX, y + i * 100, endX, y + i * 100);
            }
            
        String ID = idCarton;
        g.drawString(ID, 228, 650);
        
        // Ruta compu Andrea: "C:/Users/Dell/Documents/GitHub/PP1---POO/Proyecto1-Bingo/src/Cartones/"
        // Ruta compu Daniel: "C:/Users/Daniel/Documents/GitHub/PP1---POO/Proyecto1-Bingo/src/Cartones/"
        
        try {
            ImageIO.write(image, "jpg", new File("C:/Users/Daniel/Documents/GitHub/PP1---POO/Proyecto1-Bingo/src/Cartones/"+ ID + ".jpg"));
        } catch (IOException e) {
        }

        g.dispose();
    }
    
    public ArrayList<Integer> getFilaB() {
        return filaB;
    }
    
    public ArrayList<Integer> getFilaI() {
        return filaI;
    }
    
    public ArrayList<Integer> getFilaN(){
        return filaN;
    }
    
    public ArrayList<Integer> getFilaG(){
        return filaG;
    }
    
    public ArrayList<Integer> getFilaO(){
        return filaO;
    }
    
    public String getID(){
        return idCarton;
    }
    
    public EstadoCarton getEstado() {
        return estado;
    }

    public void setEstado(EstadoCarton estado) {
        this.estado = estado;
    }

}






