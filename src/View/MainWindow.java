/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Graph;
import comportamiento.Mensajes;
import comportamiento.Validaciones;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author rms
 */
public class MainWindow extends javax.swing.JFrame {

    /** Creates new form View */
    public MainWindow() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNodes = new javax.swing.JTextField();
        btnGenerateMatrix = new javax.swing.JButton();
        btnCalculateGraph = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMatrix = new javax.swing.JTable();
        cbCycle = new javax.swing.JCheckBox();
        cbTrajectory = new javax.swing.JCheckBox();
        cbSimple = new javax.swing.JCheckBox();
        cbEuler = new javax.swing.JCheckBox();
        cbHamilton = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Grafos");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Grafos");

        jLabel2.setText("No. nodos: ");

        tfNodes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNodesKeyTyped(evt);
            }
        });

        btnGenerateMatrix.setText("Generar");
        btnGenerateMatrix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateMatrixActionPerformed(evt);
            }
        });

        btnCalculateGraph.setText("Calcular");
        btnCalculateGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateGraphActionPerformed(evt);
            }
        });

        tbMatrix.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMatrix.setEnabled(false);
        jScrollPane1.setViewportView(tbMatrix);

        cbCycle.setText("Ciclo");

        cbTrajectory.setText("Trayectoria");

        cbSimple.setText("Simple");

        cbEuler.setText("Euler");

        cbHamilton.setText("Hamilton");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCycle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTrajectory)
                                .addGap(18, 18, 18)
                                .addComponent(cbSimple))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbEuler)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbHamilton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNodes, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGenerateMatrix)
                                .addGap(84, 84, 84)
                                .addComponent(btnCalculateGraph)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNodes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGenerateMatrix)
                    .addComponent(btnCalculateGraph))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCycle)
                    .addComponent(cbTrajectory)
                    .addComponent(cbSimple))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEuler)
                    .addComponent(cbHamilton))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateMatrixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateMatrixActionPerformed
        try {
            int noNodes = Integer.parseInt(tfNodes.getText());
            
            tbMatrix.setEnabled(true);

            DefaultTableModel model = new DefaultTableModel();
            model.setRowCount(noNodes);
            model.setColumnCount(noNodes);

            tbMatrix.setModel(model);
        } catch (NumberFormatException e) {
            Mensajes.falla(this, "Introduce un número de nodos");
        }
    }//GEN-LAST:event_btnGenerateMatrixActionPerformed

    private void tfNodesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNodesKeyTyped
        Validaciones.entero(evt, 1, tfNodes);
    }//GEN-LAST:event_tfNodesKeyTyped

    private void btnCalculateGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateGraphActionPerformed
        TableModel model = tbMatrix.getModel();
        System.out.println("Filas: " + model.getRowCount());
        System.out.println("Columnas: " + model.getColumnCount());
        
        Graph graph = new Graph(model);
        graph.printGraph();
    }//GEN-LAST:event_btnCalculateGraphActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculateGraph;
    private javax.swing.JButton btnGenerateMatrix;
    private javax.swing.JCheckBox cbCycle;
    private javax.swing.JCheckBox cbEuler;
    private javax.swing.JCheckBox cbHamilton;
    private javax.swing.JCheckBox cbSimple;
    private javax.swing.JCheckBox cbTrajectory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMatrix;
    private javax.swing.JTextField tfNodes;
    // End of variables declaration//GEN-END:variables
}
