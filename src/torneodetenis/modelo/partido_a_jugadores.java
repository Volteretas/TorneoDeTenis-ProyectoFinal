/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis.modelo;

/**
 *
 * @author Santiago
 */
public class partido_a_jugadores {
    private int id_partido_a_jugadores;
    private Partido partido;
    private Jugador jugador;
    private boolean resultado;

    public partido_a_jugadores(int id_partido_a_jugadores, Partido partido, Jugador jugador, boolean resultado) {
        this.id_partido_a_jugadores = id_partido_a_jugadores;
        this.partido = partido;
        this.jugador = jugador;
        this.resultado = resultado;
    }

    public partido_a_jugadores(Partido partido, Jugador jugador, boolean resultado) {
        this.partido = partido;
        this.jugador = jugador;
        this.resultado = resultado;
    }

    public partido_a_jugadores() {
    }

    public int getId_partido_a_jugadores() {
        return id_partido_a_jugadores;
    }

    public void setId_partido_a_jugadores(int id_partido_a_jugadores) {
        this.id_partido_a_jugadores = id_partido_a_jugadores;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }
    
    
}
