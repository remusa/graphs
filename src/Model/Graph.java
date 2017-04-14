/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.table.TableModel;

/**
 * 
 * @author rms
 */
public class Graph {

    private TableModel model;
    private String route;
    private int noColumns;
    private int noRows;
    private int numberNodes;
    private HashMap<String, Integer> table;

    public Graph(String route, TableModel model) {
        this.model = model;
        this.noColumns = model.getColumnCount();
        this.noRows = model.getRowCount();
        this.table = new HashMap<>();
        this.route = route;
        this.numberNodes = numberNodes();

//        for (int i = 0; i < noColumns; i++) {
//            for (int j = 0; j < noRows; j++) {
//                table.put(model.getColumnName(i), j);
//            }
//        }
    }

    public int numberNodes() {
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < getRoute().length(); i++) {
            hash.add(getRoute().charAt(i));
        }
        return hash.size();
    }

    public void printGraph() {
        System.out.println(Arrays.asList(getTable())); // method 1
    }

    /**
     * @return the model
     */
    public TableModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(TableModel model) {
        this.model = model;
    }

    /**
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * @return the noColumns
     */
    public int getNoColumns() {
        return noColumns;
    }

    /**
     * @param noColumns the noColumns to set
     */
    public void setNoColumns(int noColumns) {
        this.noColumns = noColumns;
    }

    /**
     * @return the noRows
     */
    public int getNoRows() {
        return noRows;
    }

    /**
     * @param noRows the noRows to set
     */
    public void setNoRows(int noRows) {
        this.noRows = noRows;
    }

    /**
     * @return the numberNodes
     */
    public int getNumberNodes() {
        return numberNodes;
    }

    /**
     * @param numberNodes the numberNodes to set
     */
    public void setNumberNodes(int numberNodes) {
        this.numberNodes = numberNodes;
    }

    /**
     * @return the table
     */
    public HashMap<String, Integer> getTable() {
        return table;
    }

    /**
     * @param table the table to set
     */
    public void setTable(HashMap<String, Integer> table) {
        this.table = table;
    }

}
