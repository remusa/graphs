/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.TableModel;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author rms
 */
public final class Graph {

    public HashMap<String, String> graph;
    private ArrayList<String> path;
    private final TableModel model;
    private final String route;
    private final String initialState;
    private String finalState;
    private String state;
    private String type;
    private String result;
    private boolean valid;
    private boolean simple;
    private boolean euler;
    private boolean hamilton;
    private int numberNodes;
    private final int noColumns;
    private final int noRows;

    public Graph(String route) {
        this.graph = new HashMap<>();
        this.path = new ArrayList<>();
        this.route = route;
        this.initialState = route.charAt(0) + "," + route.charAt(1);
        this.state = route.charAt(0) + "," + route.charAt(1);
        this.type = "";
        this.result = "";
        this.valid = true;
        this.simple = false;
        this.euler = false;
        this.hamilton = false;
        this.model = null;
        this.numberNodes = numberNodes();
        this.noColumns = 0;
        this.noRows = 0;
    }

    public Graph(String route, TableModel model) {
        this.graph = new HashMap<>();
        this.path = new ArrayList<>();
        this.route = route;
        this.initialState = route.charAt(0) + "," + route.charAt(1);
        this.finalState = "";
        this.state = route.charAt(0) + "," + route.charAt(1);
        this.type = "";
        this.result = "";
        this.valid = true;
        this.simple = false;
        this.euler = false;
        this.hamilton = false;
        this.model = model;
        this.numberNodes = numberNodes();
        this.noColumns = model.getColumnCount();
        this.noRows = model.getRowCount();
        this.graph = convertTabletoMap();
    }

    public HashMap<String, String> convertTabletoMap() {
        HashMap<String, String> hash = new HashMap<>();
        int charCode = 65; //A
        for (int i = 0; i < noRows; i++) {
            for (int j = 0; j < noColumns; j++) {
                hash.put(Character.toString((char) (charCode + i)) + "," + model.getColumnName(j), (String) model.getValueAt(i, j));
            }
        }
        return hash;
    }

    public void automata() {
        numberNodes = numberNodes();

        System.out.println("Nodes: " + numberNodes);
        System.out.println("Graph: ");
        print(graph);
        result = "";
        
        for (int i = 1; i < route.length(); i++) {
            state = state.charAt(0) + "," + route.charAt(i);
            System.out.println("State " + i + ": \t" + state + "\tvalue: " + graph.get(state));
            
            path.add(state);
            finalState = state;
            
            result += "State " + i + ": \t" + state + "\tvalue: " + graph.get(state) + "\n";

            if (graph.get(state).equals("1") || graph.get(state).equals("-")) {
                state = state.charAt(2) + "," + route.charAt(i - 1);
            } else 
                if (graph.get(state).equals("0")) {
                System.out.println("No es una ruta");
                result += "No es una ruta";
                valid = false;
                break;
            }
        }

        if (isValid()) {
            
            System.out.print("\nPath: " + Arrays.asList(path) + "\n");

            if (graph.containsKey(state)) {
                type = checkType();

                result += "\n\nRoute: \t" + route + "\n"
//                        + "Initial state: \t" + initialState + "\tvalue: " + graph.get(initialState) + "\n"
//                        + "Final state: \t" + state + "\tvalue: " + graph.get(state) + "\n"
                        + "Type: \t" + type + "\n"
                        + "Simple: \t" + String.valueOf(simple) + "\n";

                System.out.println("\nRoute: \t\t" + route);
                System.out.println("Initial state: \t" + initialState + "\tvalue: \t" + graph.get(initialState));
                System.out.println("Final state: \t" + state + "\tvalue: \t" + graph.get(state));
                System.out.println("Type: \t\t" + type);
                System.out.println("Simple: \t" + String.valueOf(simple));

                if ("Cycle".equals(type)) {
                    result += "Euler: \t" + String.valueOf(euler) + "\n"
                            + "Hamilton: \t" + String.valueOf(hamilton) + "\n";

                    System.out.println("Euler: \t\t" + String.valueOf(euler));
                    System.out.println("Hamilton: \t" + String.valueOf(hamilton));
                }
            } else {
                System.out.println("No es una ruta");
                result += "No es una ruta";
            }
        }

    }

    /**
     * Cycle or Trajectory
     *
     * @return
     */
    private String checkType() {
        if (initialState.charAt(0) == finalState.charAt(2)) {
            type = "Cycle";
            simple = checkSimple(route.substring(0, route.length() - 1));
            euler = checkEuler();
            hamilton = checkHamilton(route.substring(0, route.length() - 1));
        } else {
            type = "Trajectory";
            simple = checkSimple(route);
        }
        return type;
    }

    /**
     * Simple
     *
     * @return
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
     * Euler cycle (path)
     * Visits every edge exactly once
     *
     * @return
     */
    private boolean checkEuler() {
        boolean pathEuler = false;

        if (numberNodes % 2 == 0) { //even number of vertices

            //check unique edges
            HashSet<String> uniqueEdges = new HashSet<>();
            for (HashMap.Entry<String, String> key : graph.entrySet()) { //get unique edges
                String keyInverted = key.getKey().charAt(2) + "," + key.getKey().charAt(0);
                if (!uniqueEdges.contains(keyInverted) //no inverted key
                        && key.getValue().equals("1")) { //no equal values
                    uniqueEdges.add(key.getKey());
                }
            }

            //check the nodes traversed by the path
            HashSet<Character> nodesPath = new HashSet<>();
            int counter = 0;
            
            for (String key : path) {
                String keyInverted = key.charAt(2) + "," + key.charAt(0);
                if (uniqueEdges.contains(key)
                        || uniqueEdges.contains(keyInverted)) {
                    counter++;
                    nodesPath.add(key.charAt(0));
                    nodesPath.add(key.charAt(2));
                }
            }

            System.out.println("Counter: \t" + counter);
            System.out.println("Nodes: \t" + nodesPath);

            if (counter == uniqueEdges.size()
                    && nodesPath.size() == numberNodes) {
                return true;
            }

        }
        return pathEuler;
    }

    /**
     * Hamiltonian cycle
     * Visits each vertex exactly once
     *
     * @return
     */
    private boolean checkHamilton(String route) {
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < route.length(); i++) {
            hash.add(route.charAt(i));
        }

        int greaterValue = 0;
        if (hash.size() == numberNodes) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch : route.toCharArray()) {
                if (map.containsKey(ch)) {
                    int val = map.get(ch);
                    map.put(ch, val + 1);
                } else {
                    map.put(ch, 1);
                }
            }

            for (Integer value : map.values()) {
                if (value > greaterValue) {
                    greaterValue = value;
                }
            }
            return hamilton = greaterValue == 1;
        }
        return false;
    }

    public int numberNodes() {
        HashSet<Character> hash = new HashSet<>();
        for (HashMap.Entry<String, String> key : graph.entrySet()) {
            char node = key.getKey().charAt(0);
            hash.add(node);
        }
        return hash.size();
    }

    public void print(HashMap<String, String> map) {
//        map.keySet().forEach((name) -> {
//            String key = name;
//            String value = map.get(name);
//            System.out.println(key + " " + value);
//        });
//        System.out.println(Arrays.asList(map));
        System.out.println(Collections.singletonList(map));
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

    public String getResult() {
        return result;
    }

    public boolean isValid() {
        return valid;
    }

}
