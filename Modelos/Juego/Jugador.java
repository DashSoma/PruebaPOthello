package Modelos.Juego;

/**
 *
 * Clase que representa un jugador en el juego. Un jugador tiene un nombre y un
 * color de ficha.
 *
 * @author Christian Paniagua Castro Y Reyman Barquero Ramírez
 */
public class Jugador {

    private String nombre;
    private int color;
    public String jugador1;
    public String jugador2;
    public int jugadorActual;
    public String ultimoGanador;

    public Jugador() {
    }
    
    public Jugador(String nombre, int color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public int getColor() {
        return color;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public int getJugadorActual() {
        return jugadorActual;
    }
}
