/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.EulerianCircuit;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author rms
 */
public final class JGraphT extends EulerianCircuit { //EulerianCircuit  HamiltonianCycle

    //~ Constructors ———————————————————
    private JGraphT() {
    } // ensure non-instantiability.

    //~ Methods ———————————————————
    /***
     ** The starting point for the demo.
     **
     ** @param args ignored.
     */
    public static void main(String[] args) {
        UndirectedGraph<String, DefaultEdge> stringGraph = createStringGraph();

        System.out.println("Euler: " + JGraphT.isEulerian(stringGraph) + "\n" + JGraphT.getEulerianCircuitVertices(stringGraph));
//        System.out.println("Hamilton: " + JGraphT.(stringGraph) + "\n" + JGraphT.getEulerianCircuitVertices(stringGraph));

        // note undirected edges are printed as: {<v1>,<v2>}
        System.out.println(stringGraph.toString());
    }

    /***
     ** Craete a toy graph based on String objects.
     **
     ** @return a graph based on String objects.
     */
    private static UndirectedGraph<String, DefaultEdge> createStringGraph() {
        UndirectedGraph<String, DefaultEdge> g
                = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);

        String a = "A";
        String b = "B";
        String c = "C";

        // add the vertices
        g.addVertex(a);
        g.addVertex(b);
        g.addVertex(c);

        // add edges to create a circuit
        g.addEdge(a, b);
        g.addEdge(b, c);
        g.addEdge(c, a);

        return g;
    }
}
