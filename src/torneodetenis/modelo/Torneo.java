/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torneodetenis.modelo;

import java.time.LocalDate;

/**
 *
 * @author Santiago
 */
public class Torneo {
    private int id_torneo;
    private String nombre_torneo;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public Torneo(int id_torneo, String nombre_torneo, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id_torneo = id_torneo;
        this.nombre_torneo = nombre_torneo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Torneo(String nombre_torneo, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.nombre_torneo = nombre_torneo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Torneo() {
    }

    public int getId_torneo() {
        return id_torneo;
    }

    public void setId_torneo(int id_torneo) {
        this.id_torneo = id_torneo;
    }

    public String getNombre_torneo() {
        return nombre_torneo;
    }

    public void setNombre_torneo(String nombre_torneo) {
        this.nombre_torneo = nombre_torneo;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Torneo{" + "id_torneo=" + id_torneo + ", nombre_torneo=" + nombre_torneo + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + '}';
    }
    
    
}
