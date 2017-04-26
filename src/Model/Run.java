/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;

/**
 * 
 * @author rms
 */
public class Run {

    public static void main(String[] args) throws IOException {
        /*
            A   B   C  
        A   -   1   1
        B   1   -   1
        C   1   1   -
         */
//        String route = "ABCA";
//        Graph aut = new Graph(route.toUpperCase());
//
//        aut.graph.put("A,A", "-");
//        aut.graph.put("A,B", "1");
//        aut.graph.put("A,C", "1");
//
//        aut.graph.put("B,A", "1");
//        aut.graph.put("B,B", "-");
//        aut.graph.put("B,C", "1");
//
//        aut.graph.put("C,A", "1");
//        aut.graph.put("C,B", "1");
//        aut.graph.put("C,C", "-");
//
//        aut.automata();

        /*
            A   B   C   D   E
        A   -   1   1   1   0
        B   1   -   1   1   1
        C   1   1   -   1   0
        D   1   1   1   -   1
        E   0   1   0   1   -
         */
//        String route = "ACDEA";
//        Graph aut = new Graph(route.toUpperCase());
//
//        aut.graph.put("A,A", "-");
//        aut.graph.put("A,B", "1");
//        aut.graph.put("A,C", "1");
//        aut.graph.put("A,D", "1");
//        aut.graph.put("A,E", "1");
//
//        aut.graph.put("B,A", "1");
//        aut.graph.put("B,B", "-");
//        aut.graph.put("B,C", "1");
//        aut.graph.put("B,D", "1");
//        aut.graph.put("B,E", "1");
//
//        aut.graph.put("C,A", "1");
//        aut.graph.put("C,B", "1");
//        aut.graph.put("C,C", "-");
//        aut.graph.put("C,D", "1");
//        aut.graph.put("C,E", "1");
//
//        aut.graph.put("D,A", "1");
//        aut.graph.put("D,B", "1");
//        aut.graph.put("D,C", "1");
//        aut.graph.put("D,D", "-");
//        aut.graph.put("D,E", "1");
//
//        aut.graph.put("E,A", "1");
//        aut.graph.put("E,B", "1");
//        aut.graph.put("E,C", "1");
//        aut.graph.put("E,D", "1");
//        aut.graph.put("E,E", "-");
//
//        aut.automata();

        /*
            A   B   C   D   E
        A   -   1   1   0   0
        B   1   -   1   1   1
        C   1   1   -   1   1
        D   0   1   1   -   1
        E   0   1   1   1   -
         */
//        String route = "ABDCA"; //ABDECA H: Y      ABDCA H: N
//        Graph aut = new Graph(route.toUpperCase());
//
//        aut.graph.put("A,A", "-");
//        aut.graph.put("A,B", "1");
//        aut.graph.put("A,C", "1");
//        aut.graph.put("A,D", "0");
//        aut.graph.put("A,E", "0");
//
//        aut.graph.put("B,A", "1");
//        aut.graph.put("B,B", "-");
//        aut.graph.put("B,C", "1");
//        aut.graph.put("B,D", "1");
//        aut.graph.put("B,E", "1");
//
//        aut.graph.put("C,A", "1");
//        aut.graph.put("C,B", "1");
//        aut.graph.put("C,C", "-");
//        aut.graph.put("C,D", "1");
//        aut.graph.put("C,E", "1");
//
//        aut.graph.put("D,A", "0");
//        aut.graph.put("D,B", "1");
//        aut.graph.put("D,C", "1");
//        aut.graph.put("D,D", "-");
//        aut.graph.put("D,E", "1");
//
//        aut.graph.put("E,A", "0");
//        aut.graph.put("E,B", "1");
//        aut.graph.put("E,C", "1");
//        aut.graph.put("E,D", "1");
//        aut.graph.put("E,E", "-");
//
//        aut.automata();

        /*
            A   B   C   D
        A   -   1   1   0
        B   1   -   1   1
        C   1   1   -   1
        D   0   1   1   -
         */
        String route = "CABDDDC";
        //  ABDCA E:Y     CABDC E:Y              
        //  ABDCDBA E:N   ABDCABA E:N   CABAC E:N   ABDBA E:N
        //  CABDDDC E:N
        Graph aut = new Graph(route.toUpperCase());

        aut.graph.put("A,A", "-");
        aut.graph.put("A,B", "1");
        aut.graph.put("A,C", "1");
        aut.graph.put("A,D", "0");

        aut.graph.put("B,A", "1");
        aut.graph.put("B,B", "-");
        aut.graph.put("B,C", "0");
        aut.graph.put("B,D", "1");

        aut.graph.put("C,A", "1");
        aut.graph.put("C,B", "0");
        aut.graph.put("C,C", "-");
        aut.graph.put("C,D", "1");

        aut.graph.put("D,A", "0");
        aut.graph.put("D,B", "1");
        aut.graph.put("D,C", "1");
        aut.graph.put("D,D", "-");

        aut.automata();
    }

}
