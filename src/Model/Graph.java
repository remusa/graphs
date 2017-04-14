/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.table.TableModel;

/**
 * 
 * @author rms
 */
public class Graph {

    public final HashMap<String, String> graphMatrix = new HashMap<>();
    private final TableModel model;
    private final String route;
    private final String initialState;
    private String state;
    private String type;
    private boolean simple;
    private boolean euler;
    private boolean hamilton;
    private final int numberNodes;
    private final int noColumns;
    private final int noRows;

    public Graph(String route) {
        this.route = route;
        this.initialState = route.charAt(0) + "," + route.charAt(1);
        this.state = route.charAt(0) + "," + route.charAt(1);
        this.type = "";
        this.simple = false;
        this.euler = false;
        this.hamilton = false;
        this.model = null;
        this.numberNodes = 0;
        this.noColumns = 0;
        this.noRows = 0;
    }

    public Graph(String route, TableModel model) {
        this.route = route;
        this.initialState = route.charAt(0) + "," + route.charAt(1);
        this.state = route.charAt(0) + "," + route.charAt(1);
        this.type = "";
        this.simple = false;
        this.euler = false;
        this.hamilton = false;
        this.model = model;
        this.numberNodes = numberNodes();
        this.noColumns = model.getColumnCount();
        this.noRows = model.getRowCount();
    }

    public void automata() {
        print();

        for (int i = 1; i < route.length(); i++) {
            state = state.charAt(0) + "," + route.charAt(i);
            System.out.println("State " + i + ": " + state + "\tvalue: " + graphMatrix.get(state));
            if (graphMatrix.get(state).equals("0")) {
                System.out.println("No es una ruta");
                break;
            } else if (graphMatrix.get(state).equals("1")
                    || graphMatrix.get(state).equals("-")) {
                state = state.charAt(2) + "," + route.charAt(i);
            }
        }

        if (graphMatrix.containsKey(state)) {
            type = checkType();

            System.out.println("\n");
            System.out.println("Route: \t\t" + route);
            System.out.println("Initial state: \t" + initialState + "\tvalue: \t" + graphMatrix.get(initialState));
            System.out.println("Final state: \t" + state + "\tvalue: \t" + graphMatrix.get(state));
            System.out.println("Type: \t\t" + type);
            System.out.println("Simple: \t" + String.valueOf(simple));
            if ("Cycle".equals(type)) {
                System.out.println("Euler: \t\t" + String.valueOf(euler));
                System.out.println("Hamilton: \t" + String.valueOf(hamilton));
            }
        } else {
            System.out.println("No es una ruta");
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
    Euler = toca mínimo una vez cada arista
    @return 
     */
    private boolean checkEuler() {
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < route.length(); i++) {
            hash.add(route.charAt(i));
        }
        if (hash.size() % 2 == 0) { //puede ser Euler si el no. de vértices es par
            System.out.println("Can be Euler \tchars: " + hash.size());
            return true;
        } else {
            System.out.println("chars: " + hash.size());
            return false;
        }
    }

    /**
    Hamilton or not
    Hamilton = toca solo una vez cada vértice
    @return 
     */
    private boolean checkHamilton() {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : route.toCharArray()) {
            if (map.containsKey(ch)) {
                int val = map.get(ch);
                map.put(ch, val + 1);
            } else {
                map.put(ch, 1);
            }
        }
        System.out.println("HAMILTON: " + map);
        return hamilton;
    }

    public int numberNodes() {
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < route.length(); i++) {
            hash.add(route.charAt(i));
        }
        return hash.size();
    }

    public void print() {
//        graphMatrix.keySet().forEach((name) -> {
//            String key = name;
//            String value = graphMatrix.get(name);
//            System.out.println(key + " " + value);
//        });
//        System.out.println(Arrays.asList(graphMatrix));
        System.out.println(Collections.singletonList(graphMatrix));
    }
    
    public String getType() {
        return type;
    }

    public boolean isSimple() {
        return simple;
    }

    public boolean isEuler() {
        return euler;
    }

    public boolean isHamilton() {
        return hamilton;
    }

}
