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
public class GraphHash {

    private final HashMap<String, String> graphMatrix = new HashMap<>();
    private final String route;
    private final String initialState;
    private String state;
    private String type;

    public GraphHash(String route) {
        this.route = route;
        this.initialState = route.charAt(0) + "," + route.charAt(1);
        this.state = route.charAt(0) + "," + route.charAt(1);
    }

    public void automata() {
        System.out.println("Route: " + route);
        System.out.println("Initial state: " + state + "\tvalue: " + graphMatrix.get(state) + "\n");

        for (int i = 1; i < route.length(); i++) {
            state = state.charAt(0) + "," + route.charAt(i);
            System.out.println("State " + i + ": " + state + "\t\tvalue: " + graphMatrix.get(state));

            if (graphMatrix.get(state).equals("1")) {
                state = state.charAt(2) + "," + route.charAt(i);
            }
        }

        if (initialState.charAt(0) == state.charAt(2)) {
            type = "Cycle";
        } else {
            type = "Trajectory";
        }

        System.out.println("\nFinal state: " + state + "\tvalue: " + graphMatrix.get(state) + "\nType: " + type);
    }

    public void print() {
        graphMatrix.keySet().forEach((name) -> {
            String key = name;
            String value = graphMatrix.get(name);
            System.out.println(key + " " + value);
        });
    }

    public static void main(String[] args) throws IOException {
        String route = "ACBEA";
        GraphHash aut = new GraphHash(route);

        /*
            A   B   C   D   E
        A   -   1   1   1   0
        B   1   -   1   1   1
        C   1   1   -   1   0
        D   1   1   1   -   1
        E   0   1   0   1   -
         */
        aut.graphMatrix.put("A,A", "-");
        aut.graphMatrix.put("A,B", "1");
        aut.graphMatrix.put("A,C", "1");
        aut.graphMatrix.put("A,D", "1");
        aut.graphMatrix.put("A,E", "0");

        aut.graphMatrix.put("B,A", "1");
        aut.graphMatrix.put("B,B", "-");
        aut.graphMatrix.put("B,C", "1");
        aut.graphMatrix.put("B,D", "1");
        aut.graphMatrix.put("B,E", "1");

        aut.graphMatrix.put("C,A", "1");
        aut.graphMatrix.put("C,B", "1");
        aut.graphMatrix.put("C,C", "-");
        aut.graphMatrix.put("C,D", "1");
        aut.graphMatrix.put("C,E", "0");

        aut.graphMatrix.put("D,A", "1");
        aut.graphMatrix.put("D,B", "1");
        aut.graphMatrix.put("D,C", "1");
        aut.graphMatrix.put("D,D", "-");
        aut.graphMatrix.put("D,E", "1");

        aut.graphMatrix.put("E,A", "-");
        aut.graphMatrix.put("E,B", "1");
        aut.graphMatrix.put("E,C", "1");
        aut.graphMatrix.put("E,D", "1");
        aut.graphMatrix.put("E,E", "-");

        aut.automata();
//        aut.print();
    }

}
