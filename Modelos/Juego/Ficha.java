package Modelos.Juego;



/**
 * Representa una ficha en el juego, que puede ser de un color específico. Cada
 * ficha tiene un color asociado, que se define mediante un valor entero.
 *
 * @author Christian Paniagua Castro Y Reyman Barquero Ramírez
 */
public class Ficha {

    public int negro = 1;
    public int blanco = 2;
    
    public Ficha() {
    }

    public int getNegro() {
        return negro;
    }

    public void setNegro(int negro) {
        this.negro = negro;
    }

    public int getBlanco() {
        return blanco;
    }

    public void setBlanco(int blanco) {
        this.blanco = blanco;
    }

    
    
    
}
