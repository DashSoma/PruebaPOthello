
package Vistas;

/**
 *
 * @author User
 */
public class VistaAcercaDe extends javax.swing.JDialog {
     
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
        lblEstudiante3 = new javax.swing.JLabel();
        lblEstudiante4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("¡Conoce a los programadores que desarrollaron este juego!");

        pnlInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblEstudiante1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEstudiante1.setText("Daniel Delgado Alvarado");

        lblEstudiante2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEstudiante2.setText("Christian Paniagua Castro");

        lblIconUtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utnIcon.png"))); // NOI18N

        lblEsrudiantes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEsrudiantes.setText("Realizado por los estudiantes de ITI:");

        lblEstudiante3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEstudiante3.setText("Dashly Obando Somarribas");

        lblEstudiante4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblEstudiante4.setText("Felipe Muñoz Rojas");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(lblEstudiante3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(lblEstudiante4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstudiante2)
                            .addComponent(lblEstudiante1)
                            .addComponent(lblEsrudiantes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(lblIconUtn)
                        .addGap(24, 24, 24))))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInfoLayout.createSequentialGroup()
                        .addComponent(lblEsrudiantes)
                        .addGap(18, 18, 18)
                        .addComponent(lblEstudiante1))
                    .addComponent(lblIconUtn, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEstudiante2)
                .addGap(18, 18, 18)
                .addComponent(lblEstudiante3)
                .addGap(18, 18, 18)
                .addComponent(lblEstudiante4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
    private javax.swing.JLabel lblEstudiante3;
    private javax.swing.JLabel lblEstudiante4;
    private javax.swing.JLabel lblIconUtn;
    private javax.swing.JPanel pnlInfo;
    // End of variables declaration//GEN-END:variables
}
