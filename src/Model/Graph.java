/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;
import java.util.HashMap;
import javax.swing.table.TableModel;

/**
 * 
 * @author rms
 */
public class Graph {

    private final HashMap<String, Integer> table;
    private TableModel model;
    private final int noColumns;
    private final int noRows;

    public Graph(TableModel model) {
        model = this.model;
        noColumns = model.getColumnCount();
        noRows = model.getRowCount();
        table = new HashMap<>();

        for (int i = 0; i < noColumns; i++) {
            for (int j = 0; j < noRows; j++) {
                table.put(model.getColumnName(i), j);
            }
        }
    }

    public void printGraph() {
        System.out.println(Arrays.asList(table)); // method 1
    }

}
