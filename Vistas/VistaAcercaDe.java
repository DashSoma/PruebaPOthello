
package Vistas;

/**
 *
 * @author Christian Paniagua y Reyman Barquero 
 */
public class VistaAcercaDe extends javax.swing.JDialog {
    
    /**
     * @param modal modal 
     * @param parent padre de él 
     */
     
    public VistaAcercaDe(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
       this.setLocationRelativeTo(this);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInfo = new javax.swing.JPanel();
        lblEstudiante1 = new javax.swing.JLabel();
        lblEstudiante2 = new javax.swing.JLabel();
        lblIconUtn = new javax.swing.JLabel();
        lblEsrudiantes = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("¡Conoce a los programadores que desarrollaron este juego!");

        pnlInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblEstudiante1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEstudiante1.setText("Reyman Barquero Ramírez");

        lblEstudiante2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEstudiante2.setText("Christian Paniagua Castro ");

        lblIconUtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utnIcon.png"))); // NOI18N

        lblEsrudiantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEsrudiantes.setText("Realizado por los estudiantes de ITI");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstudiante1)
                            .addComponent(lblEstudiante2))
                        .addGap(42, 42, 42)
                        .addComponent(lblIconUtn))
                    .addComponent(lblEsrudiantes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblEsrudiantes)
                .addGap(27, 27, 27)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(lblEstudiante1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEstudiante2))
                    .addComponent(lblIconUtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   /**
    * 
    * @param args agrs del main 
    */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblEsrudiantes;
    private javax.swing.JLabel lblEstudiante1;
    private javax.swing.JLabel lblEstudiante2;
    private javax.swing.JLabel lblIconUtn;
    private javax.swing.JPanel pnlInfo;
    // End of variables declaration//GEN-END:variables
}
