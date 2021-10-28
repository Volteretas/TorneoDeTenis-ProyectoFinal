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
public class Patrocinio {
    private int id_patrocinio;
    private Jugador jugador;
    private Patrocinador patrocinador;

    public Patrocinio(int id_patrocinio, Jugador jugador, Patrocinador patrocinador) {
        this.id_patrocinio = id_patrocinio;
        this.jugador = jugador;
        this.patrocinador = patrocinador;
    }

    public Patrocinio(Jugador jugador, Patrocinador patrocinador) {
        this.jugador = jugador;
        this.patrocinador = patrocinador;
    }

    public Patrocinio() {
    }

    public int getId_patrocinio() {
        return id_patrocinio;
    }

    public void setId_patrocinio(int id_patrocinio) {
        this.id_patrocinio = id_patrocinio;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Patrocinador getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(Patrocinador patrocinador) {
        this.patrocinador = patrocinador;
    }

    @Override
    public String toString() {
        return "Patrocinio{" + "id_patrocinio=" + id_patrocinio + ", jugador=" + jugador + ", patrocinador=" + patrocinador + '}';
    }
    
    
}
