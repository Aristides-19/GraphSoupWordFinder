package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jesus
 */
public class Reader {
    
    public static String read(String nombreArchivo){
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            StringBuilder contenido = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            String contenidoCompleto = contenido.toString();
            System.out.println("Contenido del archivo:\n" + contenidoCompleto);
            return contenidoCompleto;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return null;
    }
    
    public static String[] separate(String texto){
        String[] lineas = texto.split("\n");
        return lineas;
    }
}
