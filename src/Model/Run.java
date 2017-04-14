/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;

/**
 * 
 * @author rms
 */
public class Run {

    public static void main(String[] args) throws IOException {
        String route = "ABBBC";
        Graph aut = new Graph(route);

        /*
            A   B   C  
        A   -   1   1
        B   1   -   1
        C   1   1   -
         */
        aut.graphMatrix.put("A,A", "-");
        aut.graphMatrix.put("A,B", "1");
        aut.graphMatrix.put("A,C", "1");

        aut.graphMatrix.put("B,A", "1");
        aut.graphMatrix.put("B,B", "-");
        aut.graphMatrix.put("B,C", "1");

        aut.graphMatrix.put("C,A", "1");
        aut.graphMatrix.put("C,B", "1");
        aut.graphMatrix.put("C,C", "-");

        aut.automata();

//        String route = "ACDEA";
//        Graph aut = new Graph(route);
//
//        /*
//            A   B   C   D   E
//        A   -   1   1   1   0
//        B   1   -   1   1   1
//        C   1   1   -   1   0
//        D   1   1   1   -   1
//        E   0   1   0   1   -
//         */
//        aut.graphMatrix.put("A,A", "-");
//        aut.graphMatrix.put("A,B", "1");
//        aut.graphMatrix.put("A,C", "1");
//        aut.graphMatrix.put("A,D", "1");
//        aut.graphMatrix.put("A,E", "1+");
//
//        aut.graphMatrix.put("B,A", "1");
//        aut.graphMatrix.put("B,B", "-");
//        aut.graphMatrix.put("B,C", "1");
//        aut.graphMatrix.put("B,D", "1");
//        aut.graphMatrix.put("B,E", "1");
//
//        aut.graphMatrix.put("C,A", "1");
//        aut.graphMatrix.put("C,B", "1");
//        aut.graphMatrix.put("C,C", "-");
//        aut.graphMatrix.put("C,D", "1");
//        aut.graphMatrix.put("C,E", "1+");
//
//        aut.graphMatrix.put("D,A", "1");
//        aut.graphMatrix.put("D,B", "1");
//        aut.graphMatrix.put("D,C", "1");
//        aut.graphMatrix.put("D,D", "-");
//        aut.graphMatrix.put("D,E", "1");
//
//        aut.graphMatrix.put("E,A", "1+");
//        aut.graphMatrix.put("E,B", "1");
//        aut.graphMatrix.put("E,C", "1+");
//        aut.graphMatrix.put("E,D", "1");
//        aut.graphMatrix.put("E,E", "-");
//
//        aut.automata();
    }

}
