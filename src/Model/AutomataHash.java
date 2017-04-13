/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.util.HashMap;

/**
 * 
 * @author rms
 */
public class AutomataHash {

    private String estadoActual;
    private final String cadena;
    private boolean valida;
    private static final HashMap<String, String> transiciones = new HashMap<>();
    private static final HashMap<String, Integer> estadosFinales = new HashMap<>();

    public AutomataHash(String cad) {
        this.cadena = cad;
        estadoActual = "s0";
        valida = false;
    }

    public void automata() {
        for (int i = 0; i < cadena.length(); i++) {
            String transicion = estadoActual + "," + Character.toString(cadena.charAt(i));
            if (transiciones.containsKey(transicion)) {
                estadoActual = transiciones.get(transicion);
                valida = true;
            }
        }

        if (valida) {
            if (estadosFinales.get(estadoActual) == 1) {
                System.out.println("La cadena '" + cadena + "' es válida");
            } else {
                System.out.println("La cadena '" + cadena + "' no es válida");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // Tabla de transición
        AutomataHash.transiciones.put("s0,a", "s1");
        AutomataHash.transiciones.put("s0,b", "s0");
        AutomataHash.transiciones.put("s0,c", "s0");

        AutomataHash.transiciones.put("s1,a", "s1");
        AutomataHash.transiciones.put("s1,b", "s2");
        AutomataHash.transiciones.put("s1,c", "s0");

        AutomataHash.transiciones.put("s2,a", "s2");
        AutomataHash.transiciones.put("s2,b", "s2");
        AutomataHash.transiciones.put("s2,c", "s2");

        // Estados finales
        AutomataHash.estadosFinales.put("s0", 0);
        AutomataHash.estadosFinales.put("s1", 0);
        AutomataHash.estadosFinales.put("s2", 1);

//        System.out.print("Introduce una cadena: ");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String cadena = br.readLine();
        String cadena = "acbbbab"; //aaabc = aceptada, aaad = rechazada, ac = rechazada, acbbbab = aceptada

        AutomataHash aut = new AutomataHash(cadena);
        aut.automata();

    }

}
