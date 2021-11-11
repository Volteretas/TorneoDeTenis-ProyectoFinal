/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis.modelo;


import java.time.LocalDateTime;

/**
 *
 * @author Santiago
 */
public class Partido {
    private int id_partido;
    private Torneo torneo;
    private Estadio estadio;
    private LocalDateTime fechayhora;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;
    private String estado;
    private String resultado;

    public Partido(int id_partido, Torneo torneo, Estadio estadio, LocalDateTime fechayhora, Jugador jugador1, Jugador jugador2, String estado, String resultado) {
        this.id_partido = id_partido;
        this.torneo = torneo;
        this.estadio = estadio;
        this.fechayhora = fechayhora;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.estado = estado;
        this.resultado = resultado;
    }

    public Partido(Torneo torneo, Estadio estadio, LocalDateTime fechayhora, Jugador jugador1, Jugador jugador2, String estado, String resultado) {
        this.torneo = torneo;
        this.estadio = estadio;
        this.fechayhora = fechayhora;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.estado = estado;
        this.resultado = resultado;
    }

    public Partido() {
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public LocalDateTime getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(LocalDateTime fechayhora) {
        this.fechayhora = fechayhora;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Partido{" + "id_partido=" + id_partido + ", torneo=" + torneo + ", estadio=" + estadio + ", fechayhora=" + fechayhora + ", estado=" + estado + ", resultado=" + resultado + '}';
    }
    
    
    
}
