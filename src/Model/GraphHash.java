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
    private boolean simple;
    private boolean euler;
    private boolean hamilton;
    private boolean valid;

    public GraphHash(String route) {
        this.route = route;
        this.initialState = route.charAt(0) + "," + route.charAt(1);
        this.state = route.charAt(0) + "," + route.charAt(1);
        this.simple = false;
        this.euler = false;
        this.hamilton = false;
        this.valid = false;
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
            valid = true;
        }

        type = checkType();

        System.out.println("\nFinal state: \t" + state);
        System.out.println("Value: \t\t" + graphMatrix.get(state));
        System.out.println("Type: \t\t" + type);
        System.out.println("Valid: \t\t" + String.valueOf(valid));
        System.out.println("Simple: \t" + String.valueOf(simple));
        if ("Cycle".equals(type)) {
            System.out.println("Euler: \t\t" + String.valueOf(euler));
            System.out.println("Hamilton: \t" + String.valueOf(hamilton));
        }
    }

    /**
    Cycle or Trajectory
    @return 
     */
    private String checkType() {
        if (initialState.charAt(0) == state.charAt(2)) {
            type = "Cycle";
            simple = checkSimple(route.substring(1, route.length() - 1));
            euler = checkEuler();
            hamilton = checkHamilton();
        } else {
            type = "Trajectory";
            simple = checkSimple(route);
        }
        return type;
    }

    /**
    Simple or not
    @return 
     */
    private boolean checkSimple(String route) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : route.toCharArray()) {
            if (map.containsKey(ch)) {
                int val = map.get(ch);
                map.put(ch, val + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int greaterValue = 0;
        for (Integer value : map.values()) {
            if (value > greaterValue) {
                greaterValue = value;
            }
        }
        return greaterValue == 1;
    }

    /**
    Euler or not
    @return 
     */
    private boolean checkEuler() {

        return euler;
    }

    /**
    Hamilton or not
    @return 
     */
    private boolean checkHamilton() {

        return hamilton;
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
