/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author rms
 */
public class AutomataMatrix {

    private final String cadena1;
    private final char[] cadena;
    private final int[][] transicion;
    private final int filas, columnas;
    private boolean valida = false;
    private final List<Character> alfabeto;

    /**
    
    @param alfabeto Alfabeto recibido
    @param cadena Cadena recibida
    @param transicion Tabla de transición recibida
     */
    public AutomataMatrix(String alfabeto, String cadena, int[][] transicion) {
        this.cadena1 = cadena;
        this.alfabeto = new ArrayList<>();
        this.cadena = cadena.toCharArray();
        this.transicion = transicion;
        //llenamos alfabeto
        for (int i = 0; i < alfabeto.length(); i++) {
            this.alfabeto.add(alfabeto.charAt(i));
        }
        filas = transicion.length;
        columnas = transicion[0].length;
    }

    /**
    Método para mostrar los datos recibidos e iniciar el procedimiento
     */
    public void imprimir() {
        // Alfabeto
        System.out.println("Alfabeto: " + alfabeto);

        // Cadena
        System.out.println("Cadena: '" + cadena1 + "'");

        // Tabla de transición
        System.out.println("Tabla de transición: ");
        for (int i = 0; i < filas; i++) {   //recorremos filas
            for (int j = 0; j < transicion[i].length; j++) {    //recorremos columnas
                System.out.printf("%4d", transicion[i][j]);
            }
            System.out.println();
        }
    }

    public void automata() {
        // Imprimimos
        imprimir();

        // Variables
        char caracterActual;
        int indice; //indice-columna a la que pertenece en la tabla de transición (alfabeto en la parte de arriba)
        int estado = 0; //empezamos en el estado 0
        int contador = 0;

        // Recorrido de la cadena
        while (contador < cadena.length) {
            caracterActual = cadena[contador]; //obtenemos el caracter a comparar
            System.out.println("Estado actual: [s" + estado + "," + caracterActual + "]");
            if (alfabeto.contains(caracterActual)) { //checamos que el caracter obtenido pertenezca al alfabeto permitido
                indice = alfabeto.indexOf(caracterActual); //(indice de alfabeto = columna) checamos posicion del caracter en el alfabeto
                estado = transicion[estado][indice]; //[fila][columna] de tabla de transición (estado=fila)
                contador++;
            } else {
                System.out.println("El caracter '" + caracterActual + "' no es parte del alfabeto permitido");
                break;
            }
        }

        // Estado final
        System.out.println("Estado final: [s" + estado + "]");

        // Estado de aceptación
        if (transicion[estado][columnas - 1] == 1) { //checamos si el estado en el que termina es aceptado
            valida = true;
        }

        // Cadena válida
        if (valida) {
            System.out.println("La cadena '" + cadena1 + "' es válida");
        } else {
            System.out.println("La cadena '" + cadena1 + "' no es válida");
        }
    }

    public static void main(String[] args) throws IOException {
        String alfabeto = "abc";
        String cadena = "aaabc"; //aaabc = aceptada, aaad = rechazada, ac = rechazada, acbbbab = aceptada
        int transicion[][] = {
            {1, 0, 0, 0},
            {1, 2, 0, 0},
            {2, 2, 2, 1}
        };

        AutomataMatrix aut = new AutomataMatrix(alfabeto, cadena, transicion);
        aut.automata();
    }

}
