package cbases.Paneles;

import cbases.*;

public class PanelTable extends javax.swing.JPanel {
    
     InterfazGrafica ig = new InterfazGrafica();
   
    public PanelTable() {
        initComponents();
       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTAlumnos = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 0, 255));
        setAlignmentX(0.0F);
        setAlignmentY(0.0F);

        jTAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void jTAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAlumnosMouseClicked
        // Guardar los valores de la tabla en cada variable
//        nombreRecogido=jTAlumnos.getValueAt(jTAlumnos.getSelectedRow(), 0);
//        notaRecogido=jTAlumnos.getValueAt(jTAlumnos.getSelectedRow(), 1);
//        refRecogido=jTAlumnos.getValueAt(jTAlumnos.getSelectedRow(), 2);
    }//GEN-LAST:event_jTAlumnosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTAlumnos;
    // End of variables declaration//GEN-END:variables
}
