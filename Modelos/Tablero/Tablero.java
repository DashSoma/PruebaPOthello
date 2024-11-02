package Modelos.Tablero;

import Modelos.Juego.Ficha;
import Modelos.Juego.Jugador;
import Vistas.VistaJuego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class Tablero extends JPanel {

    public static final int tamaño = 12;
    private static final int vacio = 0;

    private int contadorJugador1 = 0; // Para el jugador negro
    private int contadorJugador2 = 0; // Para el jugador blanco
    public boolean juegoEnProgreso = false;
    private int[][] tablero;
    public int filaSeleccionada;
    public int columnaSeleccionada;

    Ficha ficha = new Ficha();

    Jugador jugador = new Jugador();
    String jugador1 = jugador.getJugador1();
    String jugador2 = jugador.getJugador2();
    int jugadorActual = jugador.getJugadorActual();

    VistaJuego view;

    public String ultimoGanador = "";

    public Tablero(VistaJuego view) {
        this.view = view;
        tablero = new int[tamaño][tamaño];
        jugadorActual = ficha.getNegro();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                filaSeleccionada = e.getY() / obtenerTamañoCelda();
                columnaSeleccionada = e.getX() / obtenerTamañoCelda();
                if (esMovimientoValido(filaSeleccionada, columnaSeleccionada)) {
                    hacerMovimiento(filaSeleccionada, columnaSeleccionada);
                    if (jugadorActual == ficha.getNegro()) {
                        jugadorActual = ficha.getBlanco();
                    } else {
                        jugadorActual = ficha.getNegro();
                    }
                    // Actualizar el turno en la interfaz
                    actualizarTurno();
                    repaint();

                    // Verificar si no hay movimientos válidos para el siguiente jugador
                    if (tablaLlena() || ambosJugadoresSinMovimientos()) {
                        // Mostrar mensaje si el tablero está lleno o no hay más movimientos válidos
                        mostrarGanador(jugador.getJugador1(), jugador.getJugador2());
                    } else {
                    }
                }

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tamañoCelda = obtenerTamañoCelda();

        for (filaSeleccionada = 0; filaSeleccionada < Tablero.tamaño; filaSeleccionada++) {
            for (columnaSeleccionada = 0; columnaSeleccionada < Tablero.tamaño; columnaSeleccionada++) {
                g.setColor(new Color(9, 161, 24));
                // Dibuja los cuadros
                g.fillRect(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);
                g.setColor(new Color(0, 0, 0));
                // Dibuja los bordes
                g.drawRect(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);

                // Dibuja los círculos dependiendo del estado del tablero
                if (tablero[filaSeleccionada][columnaSeleccionada] == ficha.getNegro()) {
                    g.setColor(new Color(255, 255, 255));
                    g.fillOval(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);
                } else if (tablero[filaSeleccionada][columnaSeleccionada] == ficha.getBlanco()) {
                    g.setColor(new Color(0, 0, 0));
                    g.fillOval(columnaSeleccionada * tamañoCelda, filaSeleccionada * tamañoCelda, tamañoCelda, tamañoCelda);
                    g.drawString("Jugador 1 (Negro): " + contadorJugador1, 10, 20);
                    g.drawString("Jugador 2 (Blanco): " + contadorJugador2, 10, 40);
                }
            }
        }
    }

    public int obtenerTamañoCelda() {
        return Math.min(getWidth(), getHeight()) / tamaño;
    }

    private void mostrarGanador(String jugador1, String jugador2) {
        int fichasJugador1 = 0;
        int fichasJugador2 = 0;

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                if (tablero[i][j] == ficha.getNegro()) {
                    fichasJugador1++;
                } else if (tablero[i][j] == ficha.getBlanco()) {
                    fichasJugador2++;
                }
            }
        }

        String mensaje;
        if (fichasJugador1 > fichasJugador2) {
            mensaje = "Ganó " + jugador1 + " con " + fichasJugador1 + " fichas.";
            ultimoGanador = jugador1;
        } else if (fichasJugador2 > fichasJugador1) {
            mensaje = "Ganó " + jugador2 + " con " + fichasJugador2 + " fichas.";
            ultimoGanador = jugador2;
        } else {
            mensaje = "Empate. Ambos jugadores tienen " + fichasJugador1 + " fichas.";
            ultimoGanador = "Empate";
        }

        // Finalizar el juego
        juegoEnProgreso = false;
        JOptionPane.showMessageDialog(view, mensaje);
        reestablecerVariables();
    }

    public boolean esMovimientoValido(int filaSeleccionada, int columnaSeleccionada) {
        if (tablero[filaSeleccionada][columnaSeleccionada] != vacio) {
            return false;
        }
        return puedeInvertir(filaSeleccionada, columnaSeleccionada, true);
    }

    private boolean puedeInvertir(int filaSeleccionada, int columnaSeleccionada, boolean movimientoActual) {
        boolean puedeInvertir = false;
        //Vector con posibles direcciones 
        int[] direcciones = {-1, 0, 1};
        //Bucle que revisa el vector direcciones para determinar posibles movimientos 
        for (int dFila : direcciones) {
            for (int dColumna : direcciones) {
                if (dFila == 0 && dColumna == 0) {
                    continue;
                }
                int r = filaSeleccionada + dFila;
                int c = columnaSeleccionada + dColumna;
                boolean encontroFichaOponente = false;
                while (r >= 0 && r < tamaño && c >= 0 && c < tamaño) {
                    if (tablero[r][c] == vacio) {
                        break;
                    }
                    if (tablero[r][c] == jugadorActual) {
                        if (encontroFichaOponente) {
                            if (movimientoActual) {
                                invertir(filaSeleccionada, columnaSeleccionada, dFila, dColumna);
                            }
                            puedeInvertir = true;
                        }
                        break;
                    }
                    encontroFichaOponente = true;
                    r += dFila;
                    c += dColumna;
                }
            }
        }
        return puedeInvertir;
    }

    private void invertir(int fila, int columnaSeleccionada, int dFila, int dColumna) {
        int r = fila + dFila;
        int c = columnaSeleccionada + dColumna;
        while (tablero[r][c] != jugadorActual) {
            tablero[r][c] = jugadorActual;
            r += dFila;
            c += dColumna;
        }
    }

    public boolean hacerMovimiento(int filaSeleccionada, int columnaSeleccionada) {
        tablero[filaSeleccionada][columnaSeleccionada] = jugadorActual;
        puedeInvertir(filaSeleccionada, columnaSeleccionada, false);
        return true;
    }

    public void mostrarTabla() {
        // Iniciar juego
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
        // Colocar fichas iniciales
        tablero[5][5] = ficha.getBlanco();
        tablero[5][6] = ficha.getNegro();
        tablero[6][5] = ficha.getNegro();
        tablero[6][6] = ficha.getBlanco();
        repaint();
    }

    public boolean tablaLlena() {
        // Verificar si la matriz está llena
        for (filaSeleccionada = 0; filaSeleccionada < tamaño; filaSeleccionada++) {
            for (columnaSeleccionada = 0; columnaSeleccionada < tamaño; columnaSeleccionada++) {
                if (tablero[filaSeleccionada][columnaSeleccionada] == vacio) {
                    return false; // La matriz no está llena
                }
            }
        }
        return true;
    }

    private boolean ambosJugadoresSinMovimientos() {
        return !movimientosDisponibles(ficha.getNegro()) && !movimientosDisponibles(ficha.getBlanco());
    }

    private boolean movimientosDisponibles(int jugador) {
        for (int fila = 0; fila < tamaño; fila++) {
            for (int columna = 0; columna < tamaño; columna++) {
                if (tablero[fila][columna] == vacio && puedeInvertir(fila, columna, false)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void tableroBorrado() {
        // Iniciar juego
        jugadorActual = ficha.getNegro();
        tablero = new int[tamaño][tamaño];
        repaint();
    }

    public void actualizarTurno() {
        if (view.getLblContTurno() != null) {
            // Declara y asigna lblCirculo a una variable
            JLabel lblCirculo = view.getLblCirculo();

            // Determina el nombre del jugador cuyo turno es el actual
            String nombreJugadorActual;
            if (jugadorActual == ficha.getNegro()) {
                nombreJugadorActual = view.getLblNombreJ1().getText();
                lblCirculo.setIcon(new ImageIcon(ClassLoader.getSystemResource("imagenes/circuloBlanco.png")));
            } else {
                nombreJugadorActual = view.getLblNombreJ2().getText();
                lblCirculo.setIcon(new ImageIcon(ClassLoader.getSystemResource("imagenes/circuloNegro.png")));
            }
            // Actualiza el texto de lblContTurno sin incluir lblCirculo
            view.getLblContTurno().setText("Turno de: " + nombreJugadorActual);
        }
    }

    public void reestablecerVariables() {
        view.getLblJugador1().setText("");
        view.getLblJugador2().setText("");
        view.setLblNombreJ1("");
        view.setLblNombreJ2("");
        view.getLblContTurno().setText("");
        view.getLblCirculo().setIcon(null);
        tableroBorrado();
    }

    public void iniciarJuego() {

        // Verifica si el juego ya está en progreso
        if (juegoEnProgreso) {
            JOptionPane.showMessageDialog(view, "Partida en juego. Si deseas iniciar otra, haz clic en reiniciar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Sale del método sin hacer nada
        }

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField txtJugador1 = new JTextField(10);
        JTextField txtJugador2 = new JTextField(10);

        panel.add(new JLabel("Ingrese el nombre del Jugador 1:"));
        panel.add(txtJugador1);
        panel.add(Box.createVerticalStrut(10)); // Espacio vertical entre los campos
        panel.add(new JLabel("Ingrese el nombre del Jugador 2:"));
        panel.add(txtJugador2);

        int result = JOptionPane.showConfirmDialog(view, panel, "Presiona 'ok' para iniciar la rifa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            jugador1 = txtJugador1.getText();
            jugador2 = txtJugador2.getText();
        } else {
            return;
        }

        view.getLblJugador1().setText("Jugador 1:");
        view.getLblJugador2().setText("Jugador 2:");

        // Verifica si los nombres están disponibles
        if (jugador1 == null || jugador1.trim().isEmpty() || jugador2 == null || jugador2.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por favor, ingresa los nombres de ambos jugadores.", "Error", JOptionPane.ERROR_MESSAGE);
            reestablecerVariables();
            return;
        }
        // Validación del nombre: no debe exceder 10 caracteres
        if (jugador1.length() > 10) {
            JOptionPane.showMessageDialog(view, "El nombre del Jugador 1 no puede tener más de 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            reestablecerVariables();
            return;
        }
        if (jugador2.length() > 10) {
            JOptionPane.showMessageDialog(view, "El nombre del Jugador 2 no puede tener más de 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
            reestablecerVariables();
            return;
        }
        // Inicialización aleatoria del jugador
        int jugadorInicial = (int) (Math.random() * 2);
        if (jugadorInicial == 0) {
            JOptionPane.showMessageDialog(view, "Inicia el Jugador: " + jugador1
                    + "\nEl segundo jugador es: " + jugador2, "¡Inician las fichas negras!", JOptionPane.INFORMATION_MESSAGE);
            view.getLblJugador1().getText();
            view.setLblNombreJ1(jugador1);
            view.getLblJugador2().getText();
            view.setLblNombreJ2(jugador2);
            jugadorActual = ficha.getNegro();
        } else {
            JOptionPane.showMessageDialog(view, "Inicia el Jugador: " + jugador2
                    + "\nEl segundo jugador es: " + jugador.jugador1, "¡Inician las fichas negras!", JOptionPane.INFORMATION_MESSAGE);
            view.getLblJugador1().getText();
            view.setLblNombreJ1(jugador2);
            view.getLblJugador2().getText();
            view.setLblNombreJ2(jugador1);
            jugadorActual = ficha.getBlanco();
        }

        // Etiquetas de los jugadores en partida
        mostrarTabla();
        actualizarTurno();
        // Marca que el juego ha comenzado
        juegoEnProgreso = true;
    }

    public void reiniciarJuego() {

        if (!juegoEnProgreso) {
            JOptionPane.showMessageDialog(null, "¡No hay ninguna partida en progreso para reiniciar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Sale del método sin hacer nada
        }

        // Confirmación para reiniciar el juego
        int respuesta = JOptionPane.showConfirmDialog(
                null,
                "¿Deseas reiniciar el juego?",
                "Confirmar el reinicio",
                JOptionPane.YES_NO_OPTION
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            // Reiniciar el estado del juego
            juegoEnProgreso = false;
            repaint();
            reestablecerVariables();
            iniciarJuego();
        }
    }

    public void abortarJuego() {

        if (!juegoEnProgreso) {
            JOptionPane.showMessageDialog(null, "¡Esta opción solo está habilitada cuando una partida está en juego!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return; // Sale del método sin hacer nada
        }

        // Confirmación para abortar el juego
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Deseas abortar el juego?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            String ganador, perdedor;
            jugador1 = view.getLblNombreJ1().getText();
            jugador2 = view.getLblNombreJ2().getText();
            if (jugadorActual == ficha.getNegro()) {
                perdedor = "      " + jugador1 + ". te has rendido\n";
                ultimoGanador = jugador2;
                ganador = "            ¡Felicidades!\n"
                        + "         " + jugador2 + ". has ganado ";
            } else {
                perdedor = "      " + jugador2 + ". te has rendido\n";
                ultimoGanador = jugador1;
                ganador = "            ¡Felicidades!\n"
                        + "         " + jugador1 + ". has ganado ";
            }
            JOptionPane.showMessageDialog(null, perdedor + ganador, "Juego Abandonado", JOptionPane.INFORMATION_MESSAGE);
            // Reinicia el tablero incluyendo el estado en el que se encuentra el juego para que no hayan errores con las otras opciones
            juegoEnProgreso = false;
            reestablecerVariables();
            tableroBorrado();
        }
    }

    public void mostrarUltimoGanador() {

        String mensaje;
        if (!juegoEnProgreso && ultimoGanador.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡El juego sigue sin un ganador definido!", "Aviso", JOptionPane.WARNING_MESSAGE);
        } else if (!juegoEnProgreso) {
            if ("Empate".equals(ultimoGanador)) {
                mensaje = "El último resultado fue un empate.";
            } else {
                mensaje = "El último ganador es: " + ultimoGanador;
            }
            JOptionPane.showMessageDialog(null, mensaje, "Último Ganador", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "¡El juego aún está en progreso!", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
