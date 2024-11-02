package Vistas;

import Modelos.Juego.Jugador;
import Modelos.Tablero.Tablero;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chrisp
 *
 */
public class VistaJuego extends javax.swing.JDialog {

    private Tablero tablero;
    Jugador jugador1;
    Jugador jugador2;

    /**
     * Crea una nueva instancia de View y configura la interfaz gráfica.
     * Inicializa los jugadores, el tablero y el menú.
     */
    public VistaJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Crear Jugadores 
        jugador1 = new Jugador("Jugador 1", 1);
        jugador2 = new Jugador("Jugador 2", 2);
        // Crear tablero
        tablero = new Tablero(this);

        // Crear panel contenedor con borde vacío
        JPanel contenedorTablero = new JPanel(new BorderLayout());
        contenedorTablero.setBorder(new EmptyBorder(80, 80, 80, 80)); // Espacios alrededor
        contenedorTablero.add(tablero, BorderLayout.CENTER);
        add(contenedorTablero, BorderLayout.CENTER);

        // Crear menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuJuego = new JMenu("Juego");
        JMenuItem itemIniciar = new JMenuItem("Iniciar");
        JMenuItem itemAbortar = new JMenuItem("Abortar");
        JMenuItem itemUltimoGanador = new JMenuItem("Último ganador");
        JMenuItem itemAcercaDe = new JMenuItem("Acerca de...");
        JMenuItem itemReiniciar = new JMenuItem("Reiniciar");

        
        itemIniciar.addActionListener((ActionEvent e) -> {
            tablero.iniciarJuego();
        });

        /**
         * Escuchador del JMenuItem Reiniciar. Se ejecuta el JMenuItem de
         * Reiniciar por medio del evento actionPerFormed que activa el método
         * reiniciarJuego()
         */
        itemReiniciar.addActionListener((ActionEvent e) -> {
            tablero.reiniciarJuego();
        });

        /**
         * Escuchador del JMenuItem Reiniciar. Se ejecuta el JMenuItem de
         * Reiniciar por medio del evento actionPerFormed que activa el método
         * abortarJuego()
         */
        itemAbortar.addActionListener((ActionEvent e) -> {
            tablero.abortarJuego();
        });

        /**
         * Escuchador del JMenuItem UltimoGanador. Se ejecuta el JMenuItem de
         * UltimoGanador por medio del evento actionPerFormed que activa el
         * método mostrarUltimoGanador()
         */
        itemUltimoGanador.addActionListener((ActionEvent e) -> {
            tablero.mostrarUltimoGanador();
        });

        /**
         * Escuchador del JMenuItem AcercaDe. Se ejecuta el JMenuItem AcercaDe
         * por medio del evento actionPerFormed que despliega el JDialog con la
         * información de los creadores del juego.
         */
        /**
         * Los JMenuItem son agregados a la opción del JMenuBar "Juego" y
         * seteados en el JMenuBar
         */
        menuJuego.add(itemIniciar);
        menuJuego.add(itemReiniciar);
        menuJuego.add(itemAbortar);
        menuJuego.add(itemUltimoGanador);
        menuJuego.add(itemAcercaDe);
        menuBar.add(menuJuego);
        setJMenuBar(menuBar);

    }

    /**
     * Establece la etiqueta que muestra el contador del turno actual.
     *
     * @param lblContTurno La etiqueta JLabel que muestra el contador del turno.
     */
    public void setLblContTurno(JLabel lblContTurno) {
        this.lblContTurno = lblContTurno;
    }

// En la clase VistaJuego
    /**
     * Obtiene el primer jugador.
     *
     * @return El objeto Jugador correspondiente al primer jugador.
     */
    public Jugador getJugador1() {
        return jugador1;
    }

    /**
     * Obtiene el segundo jugador.
     *
     * @return El objeto Jugador correspondiente al segundo jugador.
     */
    public Jugador getJugador2() {
        return jugador2;
    }

    /**
     * Obtiene la etiqueta que muestra el contador del turno actual.
     *
     * @return La etiqueta JLabel que muestra el contador del turno.
     */
    public JLabel getLblContTurno() {
        return lblContTurno;
    }

    /**
     * Obtiene la etiqueta que muestra el nombre del primer jugador.
     *
     * @return La etiqueta JLabel que muestra el nombre del primer jugador.
     */
    public JLabel getLblNombreJ1() {
        return lblNombreJ1;
    }

    /**
     * Obtiene la etiqueta que muestra el nombre del segundo jugador.
     *
     * @return La etiqueta JLabel que muestra el nombre del segundo jugador.
     */
    public JLabel getLblNombreJ2() {
        return lblNombreJ2;
    }

    /**
     * Actualiza el nombre mostrado en la etiqueta del primer jugador.
     *
     * @param texto El nuevo nombre del primer jugador.
     */
    public void setLblNombreJ1(String texto) {
        lblNombreJ1.setText(texto);
    }

    /**
     * Actualiza el nombre mostrado en la etiqueta del segundo jugador.
     *
     * @param texto El nuevo nombre del segundo jugador.
     */
    public void setLblNombreJ2(String texto) {
        lblNombreJ2.setText(texto);
    }

    /**
     * Obtiene la etiqueta que muestra información del primer jugador.
     *
     * @return La etiqueta JLabel que muestra información del primer jugador.
     */
    public JLabel getLblJugador1() {
        return lblJugador1;
    }

    /**
     * Establece la etiqueta que muestra información del primer jugador.
     *
     * @param lblJugador1 La etiqueta JLabel que muestra información del primer
     * jugador.
     */
    public void setLblJugador1(JLabel lblJugador1) {
        this.lblJugador1 = lblJugador1;
    }

    /**
     * Obtiene la etiqueta que muestra información del segundo jugador.
     *
     * @return La etiqueta JLabel que muestra información del segundo jugador.
     */
    public JLabel getLblJugador2() {
        return lblJugador2;
    }

    /**
     * Establece la etiqueta que muestra información del segundo jugador.
     *
     * @param lblJugador2 La etiqueta JLabel que muestra información del segundo
     * jugador.
     */
    public void setLblJugador2(JLabel lblJugador2) {
        this.lblJugador2 = lblJugador2;
    }

    /**
     *
     * @return lblCirculo
     */
    public JLabel getLblCirculo() {
        return lblCirculo;
    }

    /**
     *
     * @param lblCirculo la etiqueta del JLabel
     */
    public void setLblCirculo(JLabel lblCirculo) {
        this.lblCirculo = lblCirculo;
    }
    
    
    

    /**
     * Obtiene la imagen de la clase "imagenes" llamada icon.
     *
     * @return la imagen de la clase "imagenes" llamada icon.
     */
    /**
     * Método principal que inicia la interfaz gráfica. Crea una instancia de la
     * ventana y la hace visible.
     *
     * @param args Los argumentos de línea de comandos (no utilizados en este
     * caso).
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreJ1 = new javax.swing.JLabel();
        lblNombreJ2 = new javax.swing.JLabel();
        lblJugador1 = new javax.swing.JLabel();
        lblJugador2 = new javax.swing.JLabel();
        pnlTurno = new javax.swing.JPanel();
        lblContTurno = new javax.swing.JLabel();
        lblCirculo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Contador1 = new javax.swing.JLabel();
        Contador2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("¡Bienvenido al increíble juego Othello!");
        setBackground(new java.awt.Color(255, 255, 255));

        lblNombreJ1.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        lblNombreJ2.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        lblJugador1.setFont(new java.awt.Font("Lucida Fax", 0, 16)); // NOI18N

        lblJugador2.setFont(new java.awt.Font("Lucida Fax", 0, 16)); // NOI18N

        pnlTurno.setBackground(new java.awt.Color(240, 240, 240));
        pnlTurno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblContTurno.setFont(new java.awt.Font("Lucida Fax", 1, 16)); // NOI18N

        javax.swing.GroupLayout pnlTurnoLayout = new javax.swing.GroupLayout(pnlTurno);
        pnlTurno.setLayout(pnlTurnoLayout);
        pnlTurnoLayout.setHorizontalGroup(
            pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurnoLayout.createSequentialGroup()
                .addComponent(lblContTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblCirculo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlTurnoLayout.setVerticalGroup(
            pnlTurnoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCirculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTurnoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContTurno, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Iniciar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pila24.png"))); // NOI18N
        jButton2.setText("Opciones");
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pila24.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pila32.png"))); // NOI18N
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addGap(70, 70, 70)
                .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Contador1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(173, 173, 173)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Contador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblNombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombreJ1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblNombreJ2, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(lblJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblJugador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
<<<<<<< Updated upstream
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 467, Short.MAX_VALUE)
=======
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Contador2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(Contador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 458, Short.MAX_VALUE)
>>>>>>> Stashed changes
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     FrmOpciones frm = new FrmOpciones(null, true); 
     frm.setLocationRelativeTo(null);
     frm.setVisible(true);
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     *
     * @param args args del main
     */
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contador1;
    private javax.swing.JLabel Contador2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lblCirculo;
    private javax.swing.JLabel lblContTurno;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblNombreJ1;
    private javax.swing.JLabel lblNombreJ2;
    private javax.swing.JPanel pnlTurno;
    // End of variables declaration//GEN-END:variables

}
